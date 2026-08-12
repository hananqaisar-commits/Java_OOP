package com.musiclibrary;

import com.musiclibrary.model.*;
import com.musiclibrary.service.LibraryUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void header1(String heading) {
        System.out.print("\n ________________________________________________________\n");
        System.out.printf("|   %-52s |\n", heading);
        System.out.println("|________________________________________________________|\n");
    }

    public static void header2(String section, String heading) {
        System.out.print("\n ________________________________________________________\n");
        System.out.printf("| %-5s||  %-45s |\n", section, heading);
        System.out.println("|________________________________________________________|\n");
    }

    public static void divider() {
        System.out.println(" ---------------------------------------------------------------");
    }

    public static void dividerlong() {
        System.out.println(
                " -------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void menu() {
        System.out.println();
        header1("               MENU MUSIC-LIBRARY");
        System.out.println(" 1)  Show Artists");
        System.out.println(" 2)  Show All Media (Heterogeneous List)");
        System.out.println(" 3)  Play Playlist");
        System.out.println(" 4)  Sort by Title & Year  (Natural Order)");
        System.out.println(" 5)  Sort by Duration      (Ascending)");
        System.out.println(" 6)  Sort by Release Year  (Descending)");
        System.out.println(" 7)  Artist Comparisons    (equals)");
        System.out.println(" 8)  Library Utilities     (songsInGenre etc)");
        System.out.println(" 9)  Playall playlist");
        System.out.println(" 10) Total duration of all media");
        System.out.println(" 0)  Exit");
        System.out.print("\n ________________________________________________________\n");
        System.out.printf("  Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Media> list = new ArrayList<>();
        Playlist likedSongs = new Playlist("Favorite Songs");
        Playlist personal = new Playlist("Sad Songs");

        menu();
        if (!input.hasNextInt()) return;
        int choice = input.nextInt();

        Artist a1 = new Artist("Atif Aslam", "Pakistan", 230320425L);
        Artist a2 = new Artist("Arijit Singh", "India", 73004325L);
        Artist a3 = new Artist("Atif Aslam", "Pakistan", 1342343L);
        Artist a4 = new Artist("Steave", "Unknown", 953342334L);
        Artist a5 = new Artist("Rahat Fateh Ali Khan", "Pakistan", 45080640L);

        Media m1 = new Song("Dil Lagi", 310, 2019, "Sad", a5);
        Media m2 = new Song("Dil Lagi (Romantic Version)", 345, 2020, "Romantic", a2);
        Media m3 = new Song("Dil Lagi (Romantic Version)", 345, 2020, "Romantic", a2);
        Media m4 = new Song("The End of Beginning", 230, 2018, "Emotional", a4);
        Media m5 = new Song("Tum Hi Ho", 260, 2013, "Romantic", a3);
        Media m6 = new Song("Tera Hona", 198, 2022, "Romantic", a1);
        Media m7 = new Song("Shape of You", 234, 2017, "Pop", a4);
        Media m8 = new Song("Bohemian Rhapsody", 354, 1975, "Rock", a4);
        Media m9 = new Song("Kun Faya Kun", 421, 2011, "Sufi", a2);

        Media m12 = new PodcastEp("Podcast No. 1: Intro to Python", 3235, 2021, "Podcast", 3);
        Media m10 = new PodcastEp("Tech Talk: Future of CyberSecurity", 2700, 2023, "Tech Talk", 7);
        Media m11 = new PodcastEp("Mind Matters: Sleep Science", 1980, 2024, "Mind Matters", 12);

        while (choice != 0) {
            switch (choice) {
                case 1:
                    header1("Artist Created");
                    System.out.printf(" %-25s %-15s %-8s\n", "Name", "Country", "Followers");
                    divider();
                    System.out.printf(" %-25s %-15s %.2fM\n", a1.getName(), a1.getCountry(), a1.getFollowerCount());
                    System.out.printf(" %-25s %-15s %.2fM\n", a2.getName(), a2.getCountry(), a2.getFollowerCount());
                    System.out.printf(" %-25s %-15s %.2fM\n", a3.getName(), a3.getCountry(), a3.getFollowerCount());
                    System.out.printf(" %-25s %-15s %.2fM\n", a4.getName(), a4.getCountry(), a4.getFollowerCount());
                    System.out.printf(" %-25s %-15s %.2fM\n", a5.getName(), a5.getCountry(), a5.getFollowerCount());
                    menu();
                    choice = input.nextInt();
                    break;
                case 2:
                    header2("9.2", "Building heterogeneous ArrayList<Media>");
                    if (list.isEmpty()) {
                        list.add(m1); list.add(m2); list.add(m3); list.add(m4);
                        list.add(m5); list.add(m6); list.add(m7); list.add(m8);
                        list.add(m9); list.add(m10); list.add(m11); list.add(m12);
                    }
                    System.out.println("\n  Songs created:");
                    System.out.printf("  %-3s %-1s %-40s %-40s %-10s %-4s\n", "#", "|", "Title", "Artist", "Genre", "Year");
                    dividerlong();

                    int i = 1;
                    for (Media media : list) {
                        if (media instanceof Song other) {
                            System.out.printf("  %-3d %-1s %-40s %-40s %-10s %-4d\n", i, "|", other.getTitle(),
                                    other.getArtistInfo(), other.getGenre(), other.getReleaseYear());
                            ++i;
                        }
                    }

                    System.out.println("\n  Podcast created:");
                    System.out.printf("  %-3s %-1s %-45s %-45s %-4s\n", "#", "|", "Title", "Show", "Ep No");
                    dividerlong();

                    int j = 1;
                    for (Media media : list) {
                        if (media instanceof PodcastEp other) {
                            System.out.printf("  %-3d %-1s %-45s %-45s %-4d\n", j, "|", other.getTitle(),
                                    other.getShowName(), other.getEpNo());
                            ++j;
                        }
                    }

                    header1("Whole list heterogeneous nature");
                    System.out.printf("\n  %-5s %-2s %-14s %-40s\n", "Index", "|", "Type", "Title");
                    divider();
                    for (int k = 0; k < list.size(); k++) {
                        System.out.printf("  %-5d %-2s %-14s %-40s\n", (k + 1), "|",
                                list.get(k).getClass().getSimpleName(),
                                list.get(k).getTitle());
                    }

                    menu();
                    choice = input.nextInt();
                    break;
                case 3:
                    if (likedSongs.getItems().isEmpty()) {
                        likedSongs.addItems(m2); likedSongs.addItems(m1); likedSongs.addItems(m4);
                        likedSongs.addItems(m5); likedSongs.addItems(m6); likedSongs.addItems(m7); likedSongs.addItems(m3);
                        if (personal.getItems().isEmpty()) {
                            personal.addItems(m2); personal.addItems(m5); personal.addItems(m8); personal.addItems(m9);
                        }
                    }
                    header2("9.3", "Polymorphic play() via LibraryUtils.playAll");
                    System.out.println("  Playing playlist: " + likedSongs.getPlaylistName());
                    dividerlong();
                    LibraryUtils.playAll(likedSongs);

                    System.out.println("\n  Playing playlist: " + personal.getPlaylistName());
                    dividerlong();
                    LibraryUtils.playAll(personal);

                    header1("Remove Dil lagi from Sad songs");
                    personal.removeItems(m2);
                    System.out.println("After removing: ");
                    LibraryUtils.playAll(personal);

                    menu();
                    choice = input.nextInt();
                    break;
                case 4:
                    header2("9.4", "Natural order — ties handle year");
                    if (list.isEmpty()) {
                        System.out.println("Add list first");
                    } else {
                        Collections.sort(list);
                        System.out.printf("  %-3s %-42s %-6s\n", "#", "Title", "Year");
                        divider();
                        for (int m = 0; m < list.size(); m++) {
                            System.out.printf("  %-3d %-42s %-6d\n",
                                    (m + 1), list.get(m).getTitle(), list.get(m).getReleaseYear());
                        }
                    }
                    menu();
                    choice = input.nextInt();
                    break;
                case 5:
                    header2("9.5a", "Comparator--sortByduration (Ascending)");
                    if (list.isEmpty()) {
                        System.out.println("Add list of media first");
                    } else {
                        Collections.sort(list, new sortByduration());
                        System.out.printf("  %-3s %-42s %-10s\n", "#", "Title", "Duration");
                        divider();
                        for (int z = 0; z < list.size(); z++) {
                            int d = (int) list.get(z).getDurationSeconds();
                            System.out.printf("  %-3d %-42s %d:%02d\n", z + 1, list.get(z).getTitle(), d / 60, d % 60);
                        }
                    }
                    menu();
                    choice = input.nextInt();
                    break;
                case 6:
                    header2("9.5b", "Comparator 2--sortByreleaseYear (Descending)");
                    if (list.isEmpty()) {
                        System.out.println("Add media list first");
                    } else {
                        Collections.sort(list, new sortByreleaseYear());
                        System.out.printf("  %-3s %-42s %-6s\n", "#", "Title", "Year");
                        divider();
                        for (int m = 0; m < list.size(); m++) {
                            System.out.printf("  %-3d %-42s %-6d\n", m + 1, list.get(m).getTitle(), list.get(m).getReleaseYear());
                        }
                    }
                    menu();
                    choice = input.nextInt();
                    break;
                case 7:
                    header2("9.6", "equals() — Artist comparisons");
                    System.out.println("  Case 1: Same name & country");
                    System.out.printf("  Artist 1 : %s\n", a1.toString());
                    System.out.printf("  Artist 3 : %s\n", a3.toString());
                    System.out.printf("  Result   : %b\n", a1.equals(a3));
                    divider();

                    System.out.println("  Case 2: Media m2 and Media m3");
                    System.out.printf("  Media m2 : %s\n", m2.toString());
                    System.out.printf("  Media m3 : %s\n", m3.toString());
                    System.out.printf("  Result   : %b\n", m2.equals(m3));

                    menu();
                    choice = input.nextInt();
                    break;
                case 8:
                    if (list.isEmpty()) {
                        System.out.println("\nAdd Media list first");
                    } else {
                        header2("9.7", "LibraryUtils utility methods");
                        double total_secs = LibraryUtils.totalDuration(list);
                        int min = (int) total_secs / 60;
                        int sec = (int) total_secs % 60;
                        System.out.printf("\tTotal = %.1f seconds = %d:%02d (mm:ss)\n\n", total_secs, min, sec);

                        ArrayList<Song> romanticSongs = LibraryUtils.songsInGenre(list, "Romantic");
                        System.out.printf("\tgenre= Romantic ---> %d songs found:\n", romanticSongs.size());
                        for (Song s : romanticSongs) {
                            System.out.printf("\t  - %s\n", s.getTitle());
                        }
                    }
                    menu();
                    choice = input.nextInt();
                    break;
                case 9:
                    System.out.printf("\n  LibraryUtils.playAll(playlist): %s\n", personal.getPlaylistName());
                    LibraryUtils.playAll(personal);
                    menu();
                    choice = input.nextInt();
                    break;
                case 10:
                    if (list.isEmpty()) {
                        System.out.println("\nAdd media list first");
                    } else {
                        header2("9.8", "Total Library Duration");
                        double total = LibraryUtils.totalDuration(list);
                        int minute = (int) total / 60;
                        int seconds = (int) total % 60;
                        System.out.printf("  Total media items  : %d\n", list.size());
                        System.out.printf("  Total duration     : %d : %02d (mm : ss)\n", minute, seconds);
                    }
                    menu();
                    choice = input.nextInt();
                    break;
                default:
                    break;
            }
        }
        input.close();
    }
}
