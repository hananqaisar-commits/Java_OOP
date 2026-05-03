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
        double followers = this.followerCount / 1000000;// convert it into Million
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

        if (this.name == null) {// if this artist name is null then it commpare it with other.name(null)
            return other.name == null;
        }
        return (other.name.equalsIgnoreCase(this.name));// case sensitivity is also checked

        // 2nd way will be
        // String n1 = this.getName().toLowerCase();
        // String n2 = other.getName().toLowerCase();
        // return n1.equals(n2);
    }

    @Override
    public String toString() {
        return String.format("%s(%s) | Followers: %.2fM (Million)", getName(), getCountry(),
                getFollowerCount());
    }

}