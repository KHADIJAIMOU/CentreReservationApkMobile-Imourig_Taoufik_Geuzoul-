package com.example.centrereservation;

public class center {


    private  String name ,image, features;
    private double latitude;
    private double longitude;


    public center(String name, String image, String features) {
        this.name = name;
        this.image = image;
        this.features = features;
    }
    public center(String name, String image, String features,double latitude, double longitude) {
        this.name = name;
        this.image = image;
        this.features = features;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getfeatures() {
        return features;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setfeatures(String coordonate) {
        this.features = coordonate;
    }

    public center() {
    }

    @Override
    public String toString() {
        return "center{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", coordonate='" + features + '\'' +
                '}';
    }
}

