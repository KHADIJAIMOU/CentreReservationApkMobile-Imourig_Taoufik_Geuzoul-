package com.example.centrereservation.model;


import javafx.scene.image.ImageView;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
    // Attributs
    private int idReservation;
    private Date dateStart;
    private Date dateEnd;
    private Time timeStart;
    private Time timeEnd;
    private String  Progress;
    private String notice;
    private String nomAssociation;
    private String nomCentre;
    // constricteur
    public Reservation(int idReservation, Date dateStart, Date dateEnd, Time timeStart, Time timeEnd, String Progress, String notice, String nomAssociation,    String nomCentre) {
        this.idReservation = idReservation;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.Progress = Progress;
        this.notice = notice;
        this.nomAssociation=nomAssociation;
        this.nomCentre=nomCentre;
    }
    // getters
    public String getNomAssociation() {
        return nomAssociation;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public String getProgress() {
        return Progress;
    }

    public String getNotice() {
        return notice;
    }
    // setters

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setNomCentre(String nomCentre) {

        this.nomCentre = nomCentre;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
    // toString
    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", Progress='" + Progress + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
