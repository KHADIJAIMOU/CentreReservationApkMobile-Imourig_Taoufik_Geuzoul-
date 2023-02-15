package com.example.centrereservation.model;

public class Salle {
    // Attributs
    private int idSalle;
    private String typeSalle;
    private int nbSeats;
    private boolean availablity;
    private String image;
    // constricteur
    public Salle(int idSalle, String typeSalle, int nbSeats, boolean availablity, String image) {
        this.idSalle = idSalle;
        this.typeSalle = typeSalle;
        this.nbSeats = nbSeats;
        this.availablity = availablity;
        this.image = image;
    }
    // getters

    public int getIdSalle() {
        return idSalle;
    }

    public String getTypeSalle() {
        return typeSalle;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public boolean isAvailablity() {
        return availablity;
    }

    public String getImage() {
        return image;
    }
    // setters

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setTypeSalle(String typeSalle) {
        this.typeSalle = typeSalle;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    public void setAvailablity(boolean availablity) {
        this.availablity = availablity;
    }

    public void setImage(String image) {
        this.image = image;
    }
    // toString

    @Override
    public String toString() {
        return "Salle{" +
                "idSalle=" + idSalle +
                ", typeSalle='" + typeSalle + '\'' +
                ", nbSeats=" + nbSeats +
                ", availablity=" + availablity +
                ", image='" + image + '\'' +
                '}';
    }
}
