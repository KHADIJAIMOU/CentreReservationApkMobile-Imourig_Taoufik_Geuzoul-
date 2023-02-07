package com.example.centrereservation.model;

import java.util.Date;

public class Centre {
    // Attributs
    private int idCentre;
    private String Name;
    private String Features;
    private String Coordinate;
    private String image;
    private int idUser;
    private String firstName;
    private String lastName ;
    private String mobilePhone ;
    private String adress;
    private String matricule;
    private String email;
    private String password;
    private String typeUser;
    private String token;
    private  int etat;
    private Date dateCreation;
    private Date dateValidation;
    private Date lastConnection;
    private String adressIp ;
    // constricteur
    public Centre(int idCentre, String name, String features, String coordinate, String image) {
        this.idCentre = idCentre;
        this.Name = name;
        this.Features = features;
        this.Coordinate = coordinate;
        this.image = image;
    }
    public Centre(int idCentre, String name, String features, String coordinate, String image,  int idUser, String firstName, String lastName, String mobilePhone, String adress, String matricule, String email, String password) {
        this.idCentre = idCentre;
        this.Name = name;
        this.Features = features;
        this.Coordinate = coordinate;
        this.image = image;
        this.firstName=firstName;
        this.lastName=lastName;
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.adress = adress;
        this.matricule = matricule;
        this.email = email;
        this.password = password;
    }
    // getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public  int getIdCentre() {
        return idCentre;
    }

    public String getName() {
        return Name;
    }

    public String getFeatures() {
        return Features;
    } public int getIdUser() {
        return idUser;
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

    public int getEtat() {
        return etat;
    }

    public Date getdateCreation() {
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

    public String getCoordinate() {
        return Coordinate;
    }

    public String getImage() {
        return image;
    }
    // setters

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setFeatures(String features) {
        Features = features;
    }

    public void setCoordinate(String coordinate) {
        Coordinate = coordinate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setdateCreation(Date dateCreation) {
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
    // toString

    @Override
    public String toString() {
        return "Centre{" +
                "idCentre=" + idCentre +
                ", Name='" + Name + '\'' +
                ", Features=" + Features +
                ", Coordinate='" + Coordinate + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
