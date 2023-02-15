package com.example.centrereservation;

public class salle {
    private int nbSeats,availability;
    private  String image,typeSalle;

    public salle() {
    }

    public salle(int nbSeats, int availability, String image, String typeSalle) {
        this.nbSeats = nbSeats;
        this.availability = availability;
        this.image = image;
        this.typeSalle = typeSalle;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTypeSalle(String typeSalle) {
        this.typeSalle = typeSalle;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public int getAvailability() {
        return availability;
    }

    public String getImage() {
        return image;
    }

    public String getTypeSalle() {
        return typeSalle;
    }

}
