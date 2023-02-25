package com.example.centrereservation.model;

public class salle {
    private int nbSeats,availability;
    private  String image,typeSalle,idSalle,idCentre;

    public salle() {
    }

    public salle(int nbSeats, int availability, String image, String typeSalle, String idSalle, String idCentre) {
        this.nbSeats = nbSeats;
        this.availability = availability;
        this.image = image;
        this.typeSalle = typeSalle;
        this.idSalle = idSalle;
        this.idCentre = idCentre;
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

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    @Override
    public String toString() {
        return "salle{" +
                "nbSeats=" + nbSeats +
                ", availability=" + availability +
                ", image='" + image + '\'' +
                ", typeSalle='" + typeSalle + '\'' +
                ", idSalle='" + idSalle + '\'' +
                ", idCentre='" + idCentre + '\'' +
                '}';
    }
}
