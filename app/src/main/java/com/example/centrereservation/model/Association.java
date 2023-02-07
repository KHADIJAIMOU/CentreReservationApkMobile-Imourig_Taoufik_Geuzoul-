package com.example.centrereservation.model;

import java.util.Date;

public class Association  extends Utilisateur {
    // Attributs
    private int idAssociation;
    private String nomAssociation;
    private String nomResponsable;
    private String legalFile;
    private String Image;
    // constricteur

    public Association(int idUser, String firstName, String lastName, String mobilePhone, String adress, String matricule, String email, String password, String typeUser, String token, int etat, Date dateCreate, Date dateValidation, Date lastConnection, String adressIp,  int idAssociation, String nomAssociation,String legalFile, String Image) {
         super(idUser, firstName, lastName, mobilePhone, adress, matricule, email, password, typeUser, token, etat, dateCreate, dateValidation, lastConnection, adressIp);


        this.idAssociation = idAssociation;
        this.nomAssociation = nomAssociation;
        this.nomResponsable = nomResponsable;
        this.legalFile = legalFile;
        this.Image = Image;
    }

    // getters


    public String getNomResponsable() {
        return nomResponsable;
    }

    public int getIdAssociation() {
        return idAssociation;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public String getLegalFile() {
        return legalFile;
    }

    public String getImage() {
        return Image;
    }

    public void setIdAssociation(int idAssociation) {
        this.idAssociation = idAssociation;
    }
    // setters

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }

    public void setLegalFile(String legalFile) {
        this.legalFile = legalFile;
    }

    public void setImage(String image) {
        this.Image = image;
    }
    // toString

    @Override
    public String toString() {
        return super.toString()+"Association{" +
                "idAssociation=" + idAssociation +
                ", nomAssociation='" + nomAssociation + '\'' +
                ", legalFile='" + legalFile + '\'' +
                ", image='" + Image + '\'' +
                '}';
    }
}
