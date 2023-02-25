package com.example.centrereservation.model;

import java.util.Date;

public class Association   {
    private String idAssociation;

    private String firstName;
    private String lastName ;
    private String mobilePhone ;
    private String adress;
    private String matricule;
    private String email;
    private String password;
    private String typeUser;
    private String token;
    private  Integer etat;
    private Date dateCreation;
    private Date dateValidation;
    private Date lastConnection;
    private String adressIp ;

    private String nomAssociation;
    private String legalFile;
    private String Image;
    // constricteur


    public Association() {
    }

    public Association(String firstName, String lastName, String mobilePhone, String adress, String matricule, String email, String password, String typeUser, String token, Integer etat, Date dateCreation, Date dateValidation, Date lastConnection, String adressIp, String nomAssociation, String legalFile, String Image) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.adress = adress;
        this.matricule = matricule;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
        this.token = token;
        this.etat = etat;
        this.dateCreation = dateCreation;
        this.dateValidation = dateValidation;
        this.lastConnection = lastConnection;
        this.adressIp = adressIp;
        this.nomAssociation = nomAssociation;
        this.legalFile = legalFile;
        this.Image = Image;

    }

    public String getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(String idAssociation) {
        this.idAssociation = idAssociation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAdress() {
        return adress;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getToken() {
        return token;
    }

    public Integer getEtat() {
        return etat;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public String getAdressIp() {
        return adressIp;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }

    public void setAdressIp(String adressIp) {
        this.adressIp = adressIp;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }

    public void setLegalFile(String legalFile) {
        this.legalFile = legalFile;
    }

    public void setImage(String image) {
        Image = image;
    }
}
