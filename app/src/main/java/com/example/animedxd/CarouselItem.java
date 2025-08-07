package com.example.animedxd;

public class CarouselItem {

    // These field names MUST match what you use in the adapter
    public int imageRes1;
    public String animeName;

    // A constructor to make creating items easier
    public CarouselItem(int imageRes1, String animeName) {
        this.imageRes1 = imageRes1;
        this.animeName = animeName;
    }
}
