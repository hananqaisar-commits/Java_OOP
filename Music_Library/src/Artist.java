class Artist {
    private String name;
    private String country;
    private double followerCount;

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

    public double getFollowerCount() {
        double followers = this.followerCount / 1000000;
        return followers;
    }

    public void addFollowers(long moreFollowers) {
        if (moreFollowers > 0) {
            this.followerCount += moreFollowers;
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
        return String.format("%s(%s) | Followers: %.2fM (Million)", getName(), getCountry(),
                getFollowerCount());
    }

}