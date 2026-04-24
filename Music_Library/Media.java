class Media implements Payable {
    private String title;
    private double durationSeconds;
    private int releaseYear;
    public Artist artist;

    public Media(String title, int durationSeconds, int releaseYear) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.title = title;
        }
        if (durationSeconds < 0) {
            System.out.println("Invalid");
        } else {
            this.durationSeconds = durationSeconds;
        }
        if (releaseYear >= 1877 && releaseYear <= 2100) {

            this.releaseYear = releaseYear;
        } else {
            System.out.println("Invalid");
        }
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public double getDurationSeconds() {
        return durationSeconds;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Media)) {
            return false;

        }
        Media other = (Media) obj;
        if (this.getTitle() == null) {
            return other.getTitle() == null;
        }
        if (!(this.getTitle().equalsIgnoreCase(other.title))) {
            return false;
        }
        return true;
    }

}