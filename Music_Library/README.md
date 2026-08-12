# Music Library 🎵 (Java 21 + Maven + MCP Server)

A modern **Java 21 + Maven** Music Library Management System integrated with **Model Context Protocol (MCP)** server capability. 

The application separates core backend domain logic (`Song`, `PodcastEp`, `Artist`, `Playlist`, `MusicLibraryService`) from the MCP stdio protocol layer (`MusicMcpServer`). This allows any MCP-compatible AI (Claude Desktop, Cursor, VS Code, Roo Code, Windsurf) to query media, search artists, add songs, and manage playlists dynamically using AI tools.

---

## 🏗️ Architecture

```
                          +-------------------------------+
                          |   AI Client (Claude/Cursor)   |
                          +---------------+---------------+
                                          | JSON-RPC 2.0 (stdio)
                                          v
                          +---------------+---------------+
                          |    MusicMcpServer (MCP)       |
                          +---------------+---------------+
                                          |
                                          v
                          +---------------+---------------+
                          |     MusicLibraryService       |
                          +---------------+---------------+
                                          |
               +--------------------------+--------------------------+
               |                          |                          |
               v                          v                          v
         [Song / Podcast]              [Artist]                  [Playlist]
```

### Key Components

1. **`com.musiclibrary.model`**:
   - `Media.java`: Base class implementing `Playable` and `Comparable`.
   - `Song.java`: Represents music tracks with genres.
   - `PodcastEp.java`: Represents podcast episodes with episode numbers and show titles.
   - `Artist.java`: Represents musical artists with follower counts.
   - `Playlist.java`: Manages collections of media.
   - `sortByduration.java` & `sortByreleaseYear.java`: Custom comparators.

2. **`com.musiclibrary.service`**:
   - `MusicLibraryService.java`: Encapsulates all domain operations, data persistence, search, filtering, and summaries. Completely independent of CLI or MCP.
   - `LibraryUtils.java`: Utility methods for duration calculations, genre filtering, and playback.

3. **`com.musiclibrary.mcp`**:
   - `MusicMcpServer.java`: Implements MCP stdio JSON-RPC 2.0 server. Routes AI tool calls directly to `MusicLibraryService`.

---

## 🛠️ MCP Tools Exposed to AI

The MCP server exposes 7 powerful tools to any connected AI assistant:

| Tool Name | Description | Required Arguments |
| :--- | :--- | :--- |
| `get_all_media` | Retrieves all songs and podcasts in the library | None |
| `get_all_artists` | Lists registered artists with country & follower stats | None |
| `get_songs_by_genre` | Filters songs by genre (e.g., `Romantic`, `Sad`, `Pop`, `Rock`, `Sufi`) | `genre` |
| `search_media` | Searches titles, artists, show names, or genres | `query` |
| `add_song` | Adds a new song and registers the artist if necessary | `title`, `artistName`, `genre`, `durationSeconds`, `releaseYear` |
| `get_library_summary` | Provides overall counts, total playback time, and statistics | None |
| `play_playlist` | Displays tracks inside a specific playlist | `playlistName` |

---

## 🚀 How to Run

### Requirements
- **Java 21+**
- **Apache Maven 3.9+**
- **Docker** *(optional)*

### 1. Build Project
```bash
mvn clean package -DskipTests
```

### 2. Run MCP Server (for AI Integration)
```bash
bash run_mcp.sh
```
*Or directly via java:*
```bash
java -jar target/music-library-mcp-1.0.0.jar
```

### 3. Run Standard CLI Menu
```bash
bash run.sh
```

### 4. Run with Docker 🐳
```bash
docker build -t music-library .
docker run -it music-library
```

---

## 🤖 AI Configuration Guide (How to connect AI to MCP)

### 1. Claude Desktop Setup
Open or create your Claude Desktop config file:
- **Linux**: `~/.config/Claude/claude_desktop_config.json`
- **macOS**: `~/Library/Application Support/Claude/claude_desktop_config.json`
- **Windows**: `%APPDATA%\Claude\claude_desktop_config.json`

Add the following configuration:
```json
{
  "mcpServers": {
    "java-music-library": {
      "command": "java",
      "args": [
        "-jar",
        "/home/hanan/Desktop/Java_OOP/Music_Library/target/music-library-mcp-1.0.0.jar"
      ]
    }
  }
}
```

### 2. Cursor / VS Code / Roo Code / Windsurf Setup
In your Cursor settings or Roo Code / MCP extension config (`mcp.json` or settings):
```json
{
  "mcpServers": {
    "music-library": {
      "command": "bash",
      "args": [
        "/home/hanan/Desktop/Java_OOP/Music_Library/run_mcp.sh"
      ]
    }
  }
}
```

---

## 💬 AI Commands & Prompts (Roman Urdu & English)

Once configured, you can command your AI using natural language prompts. The AI will automatically select and call the appropriate MCP tool!

### Example 1: Add a new song
- **Prompt (Roman Urdu)**:  
  `"AI, meri music library mei naya song add karo: title 'Pasoori', artist 'Ali Sethi', country 'Pakistan', genre 'Pop', duration 224 seconds, year 2022."`
- **AI Action**: Calls tool `add_song` with corresponding arguments.

### Example 2: Search for songs by genre
- **Prompt (Roman Urdu)**:  
  `"Music library se saaray 'Romantic' songs dikhao."`
- **AI Action**: Calls tool `get_songs_by_genre(genre: "Romantic")`.

### Example 3: Get total statistics
- **Prompt (Roman Urdu)**:  
  `"Mujhe puri music library ki summary aur total runtime batao."`
- **AI Action**: Calls tool `get_library_summary()`.

### Example 4: Search for media
- **Prompt (English)**:  
  `"Search for any songs or podcasts related to CyberSecurity or Atif Aslam."`
- **AI Action**: Calls tool `search_media(query: "CyberSecurity")`.

### Example 5: Play a playlist
- **Prompt (Roman Urdu)**:  
  `"Favorite Songs wali playlist ke saray gane play karke dikhao."`
- **AI Action**: Calls tool `play_playlist(playlistName: "Favorite Songs")`.

---

## 📝 License
MIT License - Student Project by **Hanan Qaisar**
