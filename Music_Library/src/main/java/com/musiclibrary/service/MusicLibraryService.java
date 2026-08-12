package com.musiclibrary.service;

import com.musiclibrary.model.*;
import java.util.*;

/**
 * Core Backend Domain Service for Music Library Management.
 * Keeps business logic, persistence, and search separate from MCP/CLI protocol handlers.
 */
public class MusicLibraryService {
    private final List<Media> mediaList;
    private final List<Artist> artistList;
    private final Map<String, Playlist> playlists;

    public MusicLibraryService() {
        this.mediaList = new ArrayList<>();
        this.artistList = new ArrayList<>();
        this.playlists = new LinkedHashMap<>();
        initSampleData();
    }

    private void initSampleData() {
        // Artists
        Artist a1 = new Artist("Atif Aslam", "Pakistan", 230320425L);
        Artist a2 = new Artist("Arijit Singh", "India", 73004325L);
        Artist a3 = new Artist("Steave", "Unknown", 953342334L);
        Artist a4 = new Artist("Rahat Fateh Ali Khan", "Pakistan", 45080640L);

        artistList.add(a1);
        artistList.add(a2);
        artistList.add(a3);
        artistList.add(a4);

        // Songs
        Media m1 = new Song("Dil Lagi", 310, 2019, "Sad", a4);
        Media m2 = new Song("Dil Lagi (Romantic Version)", 345, 2020, "Romantic", a2);
        Media m3 = new Song("The End of Beginning", 230, 2018, "Emotional", a3);
        Media m4 = new Song("Tum Hi Ho", 260, 2013, "Romantic", a1);
        Media m5 = new Song("Tera Hona", 198, 2022, "Romantic", a1);
        Media m6 = new Song("Shape of You", 234, 2017, "Pop", a3);
        Media m7 = new Song("Bohemian Rhapsody", 354, 1975, "Rock", a3);
        Media m8 = new Song("Kun Faya Kun", 421, 2011, "Sufi", a2);

        // Podcasts
        Media m9 = new PodcastEp("Podcast No. 1: Intro to Python", 3235, 2021, "Podcast", 3);
        Media m10 = new PodcastEp("Tech Talk: Future of CyberSecurity", 2700, 2023, "Tech Talk", 7);
        Media m11 = new PodcastEp("Mind Matters: Sleep Science", 1980, 2024, "Mind Matters", 12);

        mediaList.add(m1);
        mediaList.add(m2);
        mediaList.add(m3);
        mediaList.add(m4);
        mediaList.add(m5);
        mediaList.add(m6);
        mediaList.add(m7);
        mediaList.add(m8);
        mediaList.add(m9);
        mediaList.add(m10);
        mediaList.add(m11);

        // Playlists
        Playlist favoriteSongs = new Playlist("Favorite Songs");
        favoriteSongs.addItems(m2);
        favoriteSongs.addItems(m1);
        favoriteSongs.addItems(m4);
        favoriteSongs.addItems(m5);

        Playlist sadSongs = new Playlist("Sad Songs");
        sadSongs.addItems(m1);
        sadSongs.addItems(m3);

        playlists.put(favoriteSongs.getPlaylistName().toLowerCase(), favoriteSongs);
        playlists.put(sadSongs.getPlaylistName().toLowerCase(), sadSongs);
    }

    public List<Media> getAllMedia() {
        return new ArrayList<>(mediaList);
    }

    public List<Artist> getAllArtists() {
        return new ArrayList<>(artistList);
    }

    public List<Song> getSongsByGenre(String genre) {
        return LibraryUtils.songsInGenre(mediaList, genre);
    }

    public List<Media> searchMedia(String query) {
        if (query == null || query.trim().isEmpty()) {
            return getAllMedia();
        }
        String q = query.toLowerCase().trim();
        List<Media> result = new ArrayList<>();
        for (Media m : mediaList) {
            if (m.getTitle().toLowerCase().contains(q)) {
                result.add(m);
            } else if (m.getArtist() != null && m.getArtist().getName().toLowerCase().contains(q)) {
                result.add(m);
            } else if (m instanceof Song song && song.getGenre().toLowerCase().contains(q)) {
                result.add(m);
            } else if (m instanceof PodcastEp podcast && podcast.getShowName().toLowerCase().contains(q)) {
                result.add(m);
            }
        }
        return result;
    }

    public Artist findOrCreateArtist(String name, String country) {
        for (Artist a : artistList) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        Artist newArtist = new Artist(name, country != null ? country : "Unknown", 1000000L);
        artistList.add(newArtist);
        return newArtist;
    }

    public Song addSong(String title, String artistName, String country, String genre, int durationSeconds, int releaseYear) {
        Artist artist = findOrCreateArtist(artistName, country);
        Song song = new Song(title, durationSeconds, releaseYear, genre, artist);
        mediaList.add(song);
        return song;
    }

    public PodcastEp addPodcast(String title, String showName, int epNo, int durationSeconds, int releaseYear) {
        PodcastEp podcast = new PodcastEp(title, durationSeconds, releaseYear, showName, epNo);
        mediaList.add(podcast);
        return podcast;
    }

    public Playlist getPlaylist(String playlistName) {
        if (playlistName == null) return null;
        return playlists.get(playlistName.toLowerCase().trim());
    }

    public Collection<Playlist> getAllPlaylists() {
        return playlists.values();
    }

    public Map<String, Object> getLibrarySummary() {
        Map<String, Object> summary = new LinkedHashMap<>();
        int songCount = 0;
        int podcastCount = 0;
        for (Media m : mediaList) {
            if (m instanceof Song) songCount++;
            else if (m instanceof PodcastEp) podcastCount++;
        }
        double totalSecs = LibraryUtils.totalDuration(mediaList);
        int totalMins = (int) (totalSecs / 60);

        summary.put("totalMediaCount", mediaList.size());
        summary.put("totalSongs", songCount);
        summary.put("totalPodcasts", podcastCount);
        summary.put("totalArtists", artistList.size());
        summary.put("totalDurationSeconds", totalSecs);
        summary.put("totalDurationFormatted", String.format("%d mins %d secs", totalMins, (int)(totalSecs % 60)));
        summary.put("totalPlaylists", playlists.size());
        return summary;
    }
}
