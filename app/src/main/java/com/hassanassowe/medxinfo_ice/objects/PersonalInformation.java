package com.hassanassowe.medxinfo_ice.objects;

import java.time.LocalDate;

public class PersonalInformation {
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate date;

    private double height;
    private String heightMetric;

    private double weight;
    private String weightMetric;

    private String bloodGroup;
    private String organDonorStatus;
    private String address;
    private String phoneNumber;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHeightMetric() {
        return heightMetric;
    }

    public void setHeightMetric(String heightMetric) {
        this.heightMetric = heightMetric;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightMetric() {
        return weightMetric;
    }

    public void setWeightMetric(String weightMetric) {
        this.weightMetric = weightMetric;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getOrganDonorStatus() {
        return organDonorStatus;
    }

    public void setOrganDonorStatus(String organDonorStatus) {
        this.organDonorStatus = organDonorStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
