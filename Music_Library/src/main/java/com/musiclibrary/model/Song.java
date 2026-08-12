package com.musiclibrary.model;

public class Song extends Media {
    private String genre;

    public Song(String title, int durationSeconds, int releaseYear, String genre, Artist artist) {
        super(title, durationSeconds, releaseYear);
        this.genre = genre;
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Song))
            return false;

        Song other = (Song) obj;

        if (!super.equals(other))
            return false;

        return this.getGenre() != null && this.getGenre().equalsIgnoreCase(other.getGenre());
    }

    @Override
    public void play() {
        super.play();
        String artistName = artist != null ? artist.getName() : "Unknown Artist";
        System.out.printf("%s by %s %d mins [%s]\n", getTitle(), artistName, return_min(), getGenre());
    }

    @Override
    public String toString() {
        String artistName = artist != null ? artist.getName() : "Unknown Artist";
        return String.format("Song: %s | Artist: %s | Genre: %s | Year: %d | Duration: %d mins",
                getTitle(), artistName, getGenre(), getReleaseYear(), return_min());
    }
}
