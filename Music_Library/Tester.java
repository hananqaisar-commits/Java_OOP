import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {

        Media m1 = new Song("Jeena mera", 4, 2019, "Sad");
        Media m2 = new Song("Kesariya", 2, 2020, "Romantic");
        Media m3 = new PodcastEp("Forensic krwa lo!!!", 246, 2026, "Podcast", 3);
        m1.artist = new Artist("Atif Aslam", "Pakistan", 2300425);
        m2.artist = new Artist("Arigit Singh", "India", 73004325);
        m3.artist = new Artist("Hanan", "Pakistan", 13423);
        Playlist.items = new ArrayList<>();

        Playlist Likedone = new Playlist("Liked songs");
        Likedone.addItems(m2);
        Likedone.addItems(m1);
        Likedone.addItems(m3);

        Likedone.playAll(Likedone);
    }
}
