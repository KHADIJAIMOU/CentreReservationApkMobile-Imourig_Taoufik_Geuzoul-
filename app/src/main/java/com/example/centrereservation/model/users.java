package com.example.centrereservation.model;

public class users {
    private String mobilePhone;
    private String adress;
    private String password;
    private String token ;
    private String email ;

    public users() {
    }

    public users(String mobilePhone, String adress, String password, String token, String email) {
        this.mobilePhone = mobilePhone;
        this.adress = adress;
        this.password = password;
        this.token = token;
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAdress() {
        return adress;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "users{" +
                "mobilePhone='" + mobilePhone + '\'' +
                ", adress='" + adress + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
