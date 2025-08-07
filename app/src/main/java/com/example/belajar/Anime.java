package com.example.belajar;

public class Anime {
    private String title;
    private String genre;
    private String synopsis;
    private int imageResId;

    public Anime(String title, String genre, String synopsis, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.synopsis = synopsis;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getSynopsis() { return synopsis; }
    public int getImageResId() { return imageResId; }
}