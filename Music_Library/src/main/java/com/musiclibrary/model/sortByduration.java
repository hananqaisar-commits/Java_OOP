package com.musiclibrary.model;

import java.util.Comparator;

public class sortByduration implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        return Double.compare(m1.getDurationSeconds(), m2.getDurationSeconds());
    }
}
