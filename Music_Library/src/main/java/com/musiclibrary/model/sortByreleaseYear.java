package com.musiclibrary.model;

import java.util.Comparator;

public class sortByreleaseYear implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        if (m1.getReleaseYear() < m2.getReleaseYear())
            return 1;
        if (m1.getReleaseYear() > m2.getReleaseYear())
            return -1;
        return 0;
    }
}
