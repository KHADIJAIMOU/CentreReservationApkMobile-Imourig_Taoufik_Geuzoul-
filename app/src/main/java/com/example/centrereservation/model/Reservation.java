package com.example.centrereservation.model;




import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
    // Attributs
    private String idReservation;
    private String  idCentre;
    private String  idSalle;
    private String dateStart;
    private String dateEnd;
    private String timeStart;
    private String timeEnd;
    private String  Progress;
    private String notice;
//    private String nomAssociation;
//    private String nomCentre;

    // constricteur
    public Reservation(String idReservation, String dateStart, String dateEnd, String timeStart,String timeEnd, String Progress, String notice,String idCentre,String idSalle) {
        this.idReservation = idReservation;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.Progress = Progress;
        this.notice = notice;
        this.idCentre=idCentre;
        this.idSalle=idSalle;

    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("idReservation", idReservation);
        result.put("dateStart", dateStart);
        result.put("dateEnd", dateEnd);
        result.put("timeStart", timeStart);
        result.put("timeEnd", timeEnd);
        result.put("Progress", Progress);
        result.put("notice", notice);
        return result;
    }
    public Reservation() {
    }

    public String getIdReservation() {
        return idReservation;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getProgress() {
        return Progress;
    }

    public String getNotice() {
        return notice;
    }
    // setters

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setProgress(String progress) {
        Progress = progress;
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
