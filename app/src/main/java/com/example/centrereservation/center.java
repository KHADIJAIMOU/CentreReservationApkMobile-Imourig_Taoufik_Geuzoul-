package com.example.centrereservation;

public class center {


    private  String name ,image, features;


    public center(String name, String image, String features) {
        this.name = name;
        this.image = image;
        this.features = features;
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

