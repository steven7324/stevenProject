package com.demoqa.model;

import java.util.List;

public class Student {

    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String birthDate;
    private String subjects;
    private String hobbies;
    private String uploadPicture;
    private String currentAddress;
    private String stateAndCity;
    private String city;
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getUploadPicture() {
        return uploadPicture;
    }

    public void setUploadPicture(String uploadPicture) {
        this.uploadPicture = uploadPicture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getStateAndCity() {
        return stateAndCity;
    }

    public void setStateAndCity(String stateAndCity) {
        this.stateAndCity = stateAndCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student(List<Student> students) {
       this.students = students;
    }
}
