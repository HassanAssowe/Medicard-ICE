package com.hassanassowe.medxinfo_ice.objects;

public class Contacts {
    private String firstName;
    private String lastName;
    private String relation;
    private String phoneNumber;

    public Contacts(String firstName, String lastName, String relation, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relation = relation;
        this.phoneNumber = phoneNumber;
    }

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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
