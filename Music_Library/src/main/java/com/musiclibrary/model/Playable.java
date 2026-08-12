package com.musiclibrary.model;

public interface Playable {
    double getDurationSeconds();

    default void play() {
        System.out.print("Playing Media... : ");
    }
}
