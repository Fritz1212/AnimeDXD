// File: Review.java
package com.example.animedxd;

public class Review {
    private String name;
    private String date;
    private String score;
    private String content;

    public Review(String name, String date, String score, String content) {
        this.name = name;
        this.date = date;
        this.score = score;
        this.content = content;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getScore() {
        return score;
    }

    public String getContent() {
        return content;
    }
}