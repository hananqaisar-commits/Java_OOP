package com.musiclibrary.model;

public class Media implements Playable, Comparable<Media> {
    private String title;
    public double durationSeconds;
    private int releaseYear;
    public Artist artist;

    public Media(String title, int durationSeconds, int releaseYear) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid title");
            this.title = "Untitled";
        } else {
            this.title = title;
        }
        if (durationSeconds < 0) {
            System.out.println("Invalid duration");
            this.durationSeconds = 0;
        } else {
            this.durationSeconds = durationSeconds;
        }
        if (releaseYear >= 1877 && releaseYear <= 2100) {
            this.releaseYear = releaseYear;
        } else {
            System.out.println("Invalid release year");
            this.releaseYear = 2024;
        }
    }

    public String getArtistInfo() {
        return artist != null ? String.format("Artist: %s", artist.getName()) : "Unknown Artist";
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double getDurationSeconds() {
        return this.durationSeconds;
    }

    public int return_min() {
        return (int) getDurationSeconds() / 60;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public int compareTo(Media other) {
        int result = this.getTitle().compareToIgnoreCase(other.getTitle());
        if (result == 0) {
            if (this.getReleaseYear() > other.getReleaseYear()) {
                return 1;
            } else if (this.getReleaseYear() < other.getReleaseYear()) {
                return -1;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Media))
            return false;

        Media other = (Media) obj;

        if (this.getDurationSeconds() != other.getDurationSeconds()) {
            return false;
        }
        if (this.getReleaseYear() != other.getReleaseYear()) {
            return false;
        }
        if (!this.getTitle().equalsIgnoreCase(other.getTitle())) {
            return false;
        }
        if (this.artist == null || other.artist == null) {
            return this.artist == other.artist;
        }
        return this.artist.equals(other.artist);
    }

    @Override
    public String toString() {
        return String.format("Title: %s | Duration: %d mins | Release Year: %d | Artist: %s",
                getTitle(), return_min(), getReleaseYear(), getArtistInfo());
    }
}
