package com.hassanassowe.medxinfo_ice.objects;

public class Condition {
    private String title;
    private String symptoms;
    private String medication;
    private String doctorSpecialst;


    public Condition(String title, String symptoms, String medication, String doctorSpecialst) {
        this.title = title;
        this.symptoms = symptoms;
        this.medication = medication;
        this.doctorSpecialst = doctorSpecialst;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDoctorSpecialst() {
        return doctorSpecialst;
    }

    public void setDoctorSpecialst(String doctorSpecialst) {
        this.doctorSpecialst = doctorSpecialst;
    }
}
