package com.example.madgroup;

public class Appointmentlab {

    private String patientName,email,date,time;
    private Integer contactNumber,chemId;

    public Appointmentlab() {
    }

    public Appointmentlab(String patientName, String email, String date, String time, Integer contactNumber, Integer chemId) {
        this.patientName = patientName;
        this.email = email;
        this.date = date;
        this.time = time;
        this.contactNumber = contactNumber;
        this.chemId = chemId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getChemId() {
        return chemId;
    }

    public void setChemId(Integer chemId) {
        this.chemId = chemId;
    }
}
