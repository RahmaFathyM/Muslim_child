package com.example.l.stories;

public class Stories_Card {
    private String nameStory ;
    private int id ;

    public String getNameStory() {
        return nameStory;
    }
    public void setNameStory(String nameStory) {
        this.nameStory = nameStory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stories_Card(String nameStory, int id) {
        this.nameStory = nameStory;
        this.id = id;
    }
}
