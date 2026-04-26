class Artist {
    private String name;
    private String country;
    private long followerCount;

    public Artist(String name, String country, long followerCount) {
        this.name = name;
        this.country = country;
        this.followerCount = followerCount;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public long getFollowerCount() {
        return followerCount;
    }

    public void addFollowers(long delta) {
        if (delta > 0) {
            this.followerCount += delta;
        } else {
            System.out.println("Invalid");
        }
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj)
            return true;
        if (otherObj == null)
            return false;
        if (!(otherObj instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) otherObj;

        if (this.name == null) {
            return other.name == null;
        }
        return (other.name.equalsIgnoreCase(this.name));
    }

    @Override
    public String toString() {
        return String.format("Artist: %s(%s) | Followers: %d", getName(), getCountry(), getFollowerCount());
    }

}Comparable