package com.example.centrereservation.model;

public class Materiel {
    // Attributs
    private  int idMateriel;
    private String name;
    private  int nbMateriel;
    private String typeMatériel;
    // constricteur
    public Materiel(int idMateriel, String name, int nbMateriel, String typeMatériel) {
        this.idMateriel = idMateriel;
        this.name = name;
        this.nbMateriel = nbMateriel;
        this.typeMatériel = typeMatériel;
    }
    // getters


    public int getIdMateriel() {
        return idMateriel;
    }

    public String getName() {
        return name;
    }

    public int getNbMateriel() {
        return nbMateriel;
    }

    public String getTypeMatériel() {
        return typeMatériel;
    }
    // setters

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNbMateriel(int nbMateriel) {
        this.nbMateriel = nbMateriel;
    }

    public void setTypeMatériel(String typeMatériel) {
        this.typeMatériel = typeMatériel;
    }
    // toString

    @Override
    public String toString() {
        return "Materiel{" +
                "idMateriel=" + idMateriel +
                ", name='" + name + '\'' +
                ", nbMateriel=" + nbMateriel +
                ", typeMatériel='" + typeMatériel + '\'' +
                '}';
    }
}
