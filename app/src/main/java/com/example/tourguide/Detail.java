package com.example.tourguide;

public class Detail {

    private String name, timings, address, type;

    private static final int NO_IMAGE = -1;

    private int imageResourceId = NO_IMAGE;

    public Detail(String name, String timings, String address, String type) {
        this.name = name;
        this.timings = timings;
        this.type =type;
        this.address = address;
    }

    public Detail(String name, String timings, String address, int imageResourceId) {
        this.name = name;
        this.timings = timings;
        this.address = address;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getTimings() {
        return timings;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage(){
        return imageResourceId == NO_IMAGE;
    }

}
