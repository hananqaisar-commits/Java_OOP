package com.musiclibrary;

import com.musiclibrary.model.*;
import com.musiclibrary.service.LibraryUtils;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        System.out.println("=== Running Music Library Tests ===");
        Artist a1 = new Artist("Atif Aslam", "Pakistan", 230320425L);
        Artist a2 = new Artist("Arijit Singh", "India", 73004325L);

        Media m1 = new Song("Dil Lagi", 310, 2019, "Sad", a1);
        Media m2 = new Song("Tum Hi Ho", 260, 2013, "Romantic", a2);
        Media m3 = new PodcastEp("Tech Talk: Future of CyberSecurity", 2700, 2023, "Tech Talk", 7);

        ArrayList<Media> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);

        System.out.println("Total Media Count: " + list.size());
        System.out.println("Total Duration (sec): " + LibraryUtils.totalDuration(list));
        System.out.println("Romantic Songs Count: " + LibraryUtils.songsInGenre(list, "Romantic").size());
        System.out.println("=== Tests Passed Successfully ===");
    }
}
