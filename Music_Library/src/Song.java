class Song extends Media {
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

    // equal song check with genre
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Song))
            return false;

        Song other = (Song) obj;

        return this.getGenre().equals(other.getGenre());
    }

    @Override
    public void play() {

        super.play();
        System.out.printf("%s by %s %d mins [%s] \n", getTitle(), artist.getName(),
                return_min(),
                getGenre());
    }
}