package com.example.centrereservation.model;

public class center {


    private  String name ,image, features,idCentre;
    private double latitude;
    private double longitude;


    public center() {
    }

    public center(String name, String image, String features, String idCentre) {
        this.name = name;
        this.image = image;
        this.features = features;
        this.idCentre = idCentre;
    }

    public center(String name, String image, String features,double latitude, double longitude, String idCentre) {
        this.name = name;
        this.image = image;
        this.features = features;
        this.latitude = latitude;
        this.longitude = longitude;

        this.idCentre = idCentre;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    @Override
    public String toString() {
        return "center{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", features='" + features + '\'' +
                ", idCentre='" + idCentre + '\'' +
                '}';
    }
}

