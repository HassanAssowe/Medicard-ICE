package com.hassanassowe.medxinfo_ice.objects;

public class Medication {
    private String title;
    private String dosage;
    private String description;

    public Medication(String title, String dosage, String description) {
        this.title = title;
        this.dosage = dosage;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
