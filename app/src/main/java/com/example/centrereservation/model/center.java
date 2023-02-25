package com.example.centrereservation.model;

public class center {


    private  String name ,image, features,idCentre;


    public center() {
    }

    public center(String name, String image, String features, String idCentre) {
        this.name = name;
        this.image = image;
        this.features = features;
        this.idCentre = idCentre;
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

