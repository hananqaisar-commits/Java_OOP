package com.musiclibrary.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String playlistName;
    public List<Media> items;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.items = new ArrayList<>();
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<Media> getItems() {
        return items;
    }

    public void addItems(Media other) {
        if (other != null) {
            items.add(other);
        }
    }

    public void removeItems(Media other) {
        items.remove(other);
    }

    public int getSize(Playlist other) {
        return other != null && other.items != null ? other.items.size() : 0;
    }

    public Media getIndex(int index) {
        return items.get(index);
    }

    @Override
    public String toString() {
        return String.format("Playlist: %s | Size: %d", getPlaylistName(), items.size());
    }
}
