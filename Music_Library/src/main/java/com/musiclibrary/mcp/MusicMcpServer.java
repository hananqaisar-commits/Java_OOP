package com.musiclibrary.mcp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.musiclibrary.model.*;
import com.musiclibrary.service.MusicLibraryService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Model Context Protocol (MCP) Server for Java 21 Music Library.
 * Communicates with AI clients (Claude Desktop, Cursor, VS Code, Roo Code) via JSON-RPC 2.0 Stdio.
 */
public class MusicMcpServer {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final MusicLibraryService musicService;

    public MusicMcpServer() {
        this.musicService = new MusicLibraryService();
    }

    public static void main(String[] args) {
        logErr("Starting Java 21 Music Library MCP Server...");
        MusicMcpServer server = new MusicMcpServer();
        server.listen();
    }

    public void listen() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                try {
                    JsonNode requestNode = mapper.readTree(line);
                    handleRequest(requestNode);
                } catch (Exception e) {
                    logErr("Error parsing request: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            logErr("Server IO exception: " + e.getMessage());
        }
    }

    private void handleRequest(JsonNode req) {
        String method = req.has("method") ? req.get("method").asText() : "";
        JsonNode idNode = req.get("id");

        if (idNode == null || idNode.isNull()) {
            // Notification or invalid request (notifications require no response)
            if ("notifications/initialized".equals(method)) {
                logErr("Received notifications/initialized handshake.");
            }
            return;
        }

        switch (method) {
            case "initialize":
                sendResponse(idNode, createInitializeResult());
                break;
            case "ping":
                sendResponse(idNode, mapper.createObjectNode());
                break;
            case "tools/list":
                sendResponse(idNode, createToolsListResult());
                break;
            case "tools/call":
                sendResponse(idNode, handleToolCall(req.get("params")));
                break;
            default:
                sendErrorResponse(idNode, -32601, "Method not found: " + method);
                break;
        }
    }

    private ObjectNode createInitializeResult() {
        ObjectNode result = mapper.createObjectNode();
        result.put("protocolVersion", "2024-11-05");

        ObjectNode capabilities = mapper.createObjectNode();
        capabilities.set("tools", mapper.createObjectNode());
        result.set("capabilities", capabilities);

        ObjectNode serverInfo = mapper.createObjectNode();
        serverInfo.put("name", "music-library-mcp-server");
        serverInfo.put("version", "1.0.0");
        result.set("serverInfo", serverInfo);

        return result;
    }

    private ObjectNode createToolsListResult() {
        ObjectNode result = mapper.createObjectNode();
        ArrayNode tools = mapper.createArrayNode();

        // 1. get_all_media
        tools.add(buildToolSchema(
                "get_all_media",
                "Retrieve all media items (songs and podcasts) in the music library.",
                mapper.createObjectNode()
        ));

        // 2. get_all_artists
        tools.add(buildToolSchema(
                "get_all_artists",
                "Retrieve all registered music artists, their countries, and follower counts.",
                mapper.createObjectNode()
        ));

        // 3. get_songs_by_genre
        ObjectNode genreProps = mapper.createObjectNode();
        ObjectNode genreNode = mapper.createObjectNode();
        genreNode.put("type", "string");
        genreNode.put("description", "Genre name (e.g. Romantic, Sad, Pop, Rock, Sufi)");
        genreProps.set("genre", genreNode);
        tools.add(buildToolSchema(
                "get_songs_by_genre",
                "Filter and return all songs matching a specific genre.",
                genreProps,
                "genre"
        ));

        // 4. search_media
        ObjectNode searchProps = mapper.createObjectNode();
        ObjectNode queryNode = mapper.createObjectNode();
        queryNode.put("type", "string");
        queryNode.put("description", "Keyword query to search titles, artists, or genres");
        searchProps.set("query", queryNode);
        tools.add(buildToolSchema(
                "search_media",
                "Search media items by title keyword, artist name, show name, or genre.",
                searchProps,
                "query"
        ));

        // 5. add_song
        ObjectNode addSongProps = mapper.createObjectNode();
        addSongProps.set("title", createStringProp("Title of the song"));
        addSongProps.set("artistName", createStringProp("Name of the artist"));
        addSongProps.set("country", createStringProp("Country of the artist (optional, defaults to Unknown)"));
        addSongProps.set("genre", createStringProp("Genre of the song (e.g. Pop, Romantic, Rock)"));
        addSongProps.set("durationSeconds", createIntProp("Duration of the song in seconds"));
        addSongProps.set("releaseYear", createIntProp("Release year of the song (e.g. 2023)"));

        tools.add(buildToolSchema(
                "add_song",
                "Add a new song to the music library. Automatically registers artist if not existing.",
                addSongProps,
                "title", "artistName", "genre", "durationSeconds", "releaseYear"
        ));

        // 6. get_library_summary
        tools.add(buildToolSchema(
                "get_library_summary",
                "Get high-level music library statistics including total count, duration, and artist stats.",
                mapper.createObjectNode()
        ));

        // 7. play_playlist
        ObjectNode playlistProps = mapper.createObjectNode();
        playlistProps.set("playlistName", createStringProp("Name of playlist (e.g. 'Favorite Songs', 'Sad Songs')"));
        tools.add(buildToolSchema(
                "play_playlist",
                "Get tracks and details inside a named playlist.",
                playlistProps,
                "playlistName"
        ));

        result.set("tools", tools);
        return result;
    }

    private ObjectNode handleToolCall(JsonNode params) {
        if (params == null || !params.has("name")) {
            return buildTextResult("Error: Missing tool name in params.", true);
        }

        String toolName = params.get("name").asText();
        JsonNode args = params.has("arguments") ? params.get("arguments") : mapper.createObjectNode();

        try {
            switch (toolName) {
                case "get_all_media": {
                    List<Media> mediaList = musicService.getAllMedia();
                    StringBuilder sb = new StringBuilder("=== Music Library Media Items (" + mediaList.size() + ") ===\n");
                    for (int i = 0; i < mediaList.size(); i++) {
                        sb.append(String.format("%d. %s\n", i + 1, mediaList.get(i).toString()));
                    }
                    return buildTextResult(sb.toString(), false);
                }
                case "get_all_artists": {
                    List<Artist> artistList = musicService.getAllArtists();
                    StringBuilder sb = new StringBuilder("=== Registered Artists (" + artistList.size() + ") ===\n");
                    for (int i = 0; i < artistList.size(); i++) {
                        sb.append(String.format("%d. %s\n", i + 1, artistList.get(i).toString()));
                    }
                    return buildTextResult(sb.toString(), false);
                }
                case "get_songs_by_genre": {
                    String genre = args.has("genre") ? args.get("genre").asText() : "";
                    List<Song> songs = musicService.getSongsByGenre(genre);
                    if (songs.isEmpty()) {
                        return buildTextResult("No songs found for genre: '" + genre + "'.", false);
                    }
                    StringBuilder sb = new StringBuilder("=== Songs in Genre '" + genre + "' (" + songs.size() + ") ===\n");
                    for (Song s : songs) {
                        sb.append("- ").append(s.toString()).append("\n");
                    }
                    return buildTextResult(sb.toString(), false);
                }
                case "search_media": {
                    String query = args.has("query") ? args.get("query").asText() : "";
                    List<Media> results = musicService.searchMedia(query);
                    if (results.isEmpty()) {
                        return buildTextResult("No media found matching search query: '" + query + "'.", false);
                    }
                    StringBuilder sb = new StringBuilder("=== Search Results for '" + query + "' (" + results.size() + ") ===\n");
                    for (Media m : results) {
                        sb.append("- ").append(m.toString()).append("\n");
                    }
                    return buildTextResult(sb.toString(), false);
                }
                case "add_song": {
                    String title = args.get("title").asText();
                    String artistName = args.get("artistName").asText();
                    String country = args.has("country") ? args.get("country").asText() : "Unknown";
                    String genre = args.get("genre").asText();
                    int durationSeconds = args.get("durationSeconds").asInt();
                    int releaseYear = args.get("releaseYear").asInt();

                    Song added = musicService.addSong(title, artistName, country, genre, durationSeconds, releaseYear);
                    return buildTextResult("Successfully added song:\n" + added.toString(), false);
                }
                case "get_library_summary": {
                    Map<String, Object> summary = musicService.getLibrarySummary();
                    StringBuilder sb = new StringBuilder("=== Music Library Summary ===\n");
                    summary.forEach((k, v) -> sb.append(String.format("• %s: %s\n", k, v)));
                    return buildTextResult(sb.toString(), false);
                }
                case "play_playlist": {
                    String playlistName = args.has("playlistName") ? args.get("playlistName").asText() : "";
                    Playlist pl = musicService.getPlaylist(playlistName);
                    if (pl == null) {
                        StringBuilder available = new StringBuilder("Playlist '" + playlistName + "' not found. Available playlists:\n");
                        for (Playlist p : musicService.getAllPlaylists()) {
                            available.append("- ").append(p.getPlaylistName()).append("\n");
                        }
                        return buildTextResult(available.toString(), false);
                    }
                    StringBuilder sb = new StringBuilder("=== Playing Playlist: " + pl.getPlaylistName() + " (" + pl.getItems().size() + " items) ===\n");
                    for (Media m : pl.getItems()) {
                        sb.append("- ").append(m.toString()).append("\n");
                    }
                    return buildTextResult(sb.toString(), false);
                }
                default:
                    return buildTextResult("Unknown tool: " + toolName, true);
            }
        } catch (Exception e) {
            logErr("Error executing tool " + toolName + ": " + e.getMessage());
            return buildTextResult("Error executing tool " + toolName + ": " + e.getMessage(), true);
        }
    }

    private ObjectNode buildToolSchema(String name, String description, ObjectNode properties, String... requiredFields) {
        ObjectNode schema = mapper.createObjectNode();
        schema.put("name", name);
        schema.put("description", description);

        ObjectNode inputSchema = mapper.createObjectNode();
        inputSchema.put("type", "object");
        inputSchema.set("properties", properties);

        if (requiredFields.length > 0) {
            ArrayNode requiredNode = mapper.createArrayNode();
            for (String field : requiredFields) {
                requiredNode.add(field);
            }
            inputSchema.set("required", requiredNode);
        }
        schema.set("inputSchema", inputSchema);
        return schema;
    }

    private ObjectNode createStringProp(String desc) {
        ObjectNode node = mapper.createObjectNode();
        node.put("type", "string");
        node.put("description", desc);
        return node;
    }

    private ObjectNode createIntProp(String desc) {
        ObjectNode node = mapper.createObjectNode();
        node.put("type", "integer");
        node.put("description", desc);
        return node;
    }

    private ObjectNode buildTextResult(String text, boolean isError) {
        ObjectNode result = mapper.createObjectNode();
        ArrayNode content = mapper.createArrayNode();
        ObjectNode textObj = mapper.createObjectNode();
        textObj.put("type", "text");
        textObj.put("text", text);
        content.add(textObj);
        result.set("content", content);
        if (isError) {
            result.put("isError", true);
        }
        return result;
    }

    private void sendResponse(JsonNode id, ObjectNode result) {
        ObjectNode resp = mapper.createObjectNode();
        resp.put("jsonrpc", "2.0");
        resp.set("id", id);
        resp.set("result", result);
        outputJson(resp);
    }

    private void sendErrorResponse(JsonNode id, int code, String message) {
        ObjectNode resp = mapper.createObjectNode();
        resp.put("jsonrpc", "2.0");
        resp.set("id", id);
        ObjectNode errorObj = mapper.createObjectNode();
        errorObj.put("code", code);
        errorObj.put("message", message);
        resp.set("error", errorObj);
        outputJson(resp);
    }

    private static void outputJson(ObjectNode json) {
        try {
            String str = mapper.writeValueAsString(json);
            System.out.println(str);
            System.out.flush();
        } catch (JsonProcessingException e) {
            logErr("Failed to serialize response: " + e.getMessage());
        }
    }

    private static void logErr(String msg) {
        System.err.println("[MCP Server Log] " + msg);
    }
}
