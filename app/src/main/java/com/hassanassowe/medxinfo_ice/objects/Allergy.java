package com.hassanassowe.medxinfo_ice.objects;

public class Allergy {
    private String name;
    private String symptoms;
    private String treatmentInstructions;

    public Allergy(String name, String symptoms, String treatmentInstructions) {
        this.name = name;
        this.symptoms = symptoms;
        this.treatmentInstructions = treatmentInstructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTreatmentInstructions() {
        return treatmentInstructions;
    }

    public void setTreatmentInstructions(String treatmentInstructions) {
        this.treatmentInstructions = treatmentInstructions;
    }
}
