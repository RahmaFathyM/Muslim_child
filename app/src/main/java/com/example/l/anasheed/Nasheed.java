package com.example.l.anasheed;

public class Nasheed {
    String title;
    int sound;

    public Nasheed(String title, int sound) {
        this.title = title;
        this.sound = sound;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
