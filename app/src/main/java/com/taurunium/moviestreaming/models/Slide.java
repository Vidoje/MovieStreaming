package com.taurunium.moviestreaming.models;

public class Slide {
    private int image;
    private String title;

    public Slide() {
    }

    public Slide(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
