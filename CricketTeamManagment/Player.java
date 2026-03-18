package CricketTeamManagment;

class Player {
    private String name;
    private String role;// e.g: Bowler, Batsman, WicketKeeper
    private int matchPlayed;
    public static int totalplayers;

    public Player() {
        ++totalplayers;
    }

    public Player(String name, String role) {

        ++totalplayers;
        this.name = name;
        this.role = role;
    }

    public static int getTotalplayers() {
        return totalplayers;
    }
}