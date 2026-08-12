package com.musiclibrary.service;

import com.musiclibrary.model.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryUtils {

    public static double totalDuration(List<Media> list) {
        double sec = 0.00;
        if (list == null) return sec;
        for (Media media : list) {
            sec = sec + media.getDurationSeconds();
        }
        return sec;
    }

    public static void playAll(Playlist playlist) {
        if (playlist == null || playlist.getItems() == null) return;
        for (Media n : playlist.getItems()) {
            if (n instanceof Song) {
                System.out.print("  - Song: ");
                n.play();
            } else if (n instanceof PodcastEp) {
                System.out.print("  - Podcast: ");
                n.play();
            }
        }
    }

    public static ArrayList<Song> songsInGenre(List<Media> list, String genre) {
        ArrayList<Song> returned = new ArrayList<>();
        if (list == null || genre == null) return returned;

        for (Media media : list) {
            if (media instanceof Song corrected) {
                String s_lowercase1 = corrected.getGenre().toLowerCase();
                String s_lowercase2 = genre.toLowerCase();

                if (s_lowercase1.equals(s_lowercase2)) {
                    returned.add(corrected);
                }
            }
        }
        return returned;
    }
}
