import java.util.*;

public class Tester {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Media objects
        Media m1 = new Song("Dil Lagi", 134, 2019, "Sad");
        Media m2 = new Song("Dil Lagi (Romantic Version)", 345, 2020, "Romantic");
        Media m3 = new PodcastEp("Podcast No. 1: Introduction to Python", 3235, 2021, "Podcast", 3);
        Media m4 = new Song("The End of Beginning", 230, 2018, "Emotional");

        // artists
        m1.artist = new Artist("Atif Aslam", "Pakistan", 230320425);
        m2.artist = new Artist("Arijit Singh", "India", 73004325);
        m3.artist = new Artist("Atif Aslam", "Pakistan", 1342343);
        m4.artist = new Artist("Steave", "Unknown", 953342334);

        // Playlist
        Playlist likedSongs = new Playlist("Favorite Songs");
        likedSongs.addItems(m2);
        likedSongs.addItems(m1);
        likedSongs.addItems(m4);

        Playlist personal = new Playlist("Sad Songs");
        personal.addItems(m2);
        personal.addItems(m3);

        System.out.println("===============Playlist=============");
        System.out.println(likedSongs);
        System.out.println(personal);

        System.out.println("=============Comparision============");
        System.out.printf("Compare %s with %s: ", m1.getArtist(), m3.getArtist());
        System.out.println(m1.artist.equals(m3.artist)); // true
        System.out.printf("Comapre %s with %s: ", m1.getArtist(), m2.getArtist());
        System.out.println(m1.artist.equals(m2.artist)); // false

        // creating list to store all media's ans then sort it
        List<Media> list = new ArrayList<>();
        list.add(m4);
        list.add(m1);
        list.add(m2);
        list.add(m3);

        // here i am sortting my list by overridding compareTo method in media class
        Collections.sort(list);

        // Print sorted list through Collections
        System.out.println("<<<<==============---Sorting by Title & release year---=============>>>> ");
        System.out.println("Sorted list:");
        for (Media media : list) {
            System.out.println(media);
        }

        // Play all playlist
        likedSongs.playAll(likedSongs);
        personal.playAll(personal);

        // size of playlist
        likedSongs.getSize(likedSongs);
        personal.getSize(personal);

        System.out.println("<<<<==============---Sorting by Durations(Accending)---=============>>>> ");
        Collections.sort(list, new sortByduration());
        System.out.println("Sorted list:");
        for (Media media : list) {
            System.out.println(media);
        }

        System.out.println("<<<<==============---Sorting by Release Years(Decending)---=============>>>> ");
        Collections.sort(list, new sortByreleaseYear());
        System.out.println("Sorted list:");
        for (Media media : list) {
            System.out.println(media);
        }

        input.close();
    }
}