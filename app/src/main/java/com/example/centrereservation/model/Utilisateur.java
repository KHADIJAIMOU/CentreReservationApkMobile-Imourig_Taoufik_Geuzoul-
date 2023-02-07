package com.example.centrereservation.model;

import java.util.Date;

public class Utilisateur {
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

    public Utilisateur(int idUser, String firstName, String lastName, String mobilePhone, String adress, String matricule, String email, String password, String typeUser, String token, int etat, Date dateCreation, Date dateValidation, Date lastConnection, String adressIp) {
        this.idUser = idUser;
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
    }

    public int getIdUser() {
        return idUser;
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

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", adress='" + adress + '\'' +
                ", matricule='" + matricule + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", typeUser='" + typeUser + '\'' +
                ", token='" + token + '\'' +
                ", etat=" + etat +
                ", dateCreation=" + dateCreation +
                ", dateValidation=" + dateValidation +
                ", lastConnection=" + lastConnection +
                ", adressIp='" + adressIp + '\'' +
                '}';
    }

}
