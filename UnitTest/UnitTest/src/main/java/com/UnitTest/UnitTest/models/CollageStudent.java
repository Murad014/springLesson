package com.UnitTest.UnitTest.models;

import org.springframework.stereotype.Component;


public class CollageStudent implements Student{
    private String firstName;
    private String lastname;
    private String emailAddress;
    private StudentGrades studentGrades;


    public CollageStudent(){

    }

    public CollageStudent(String firstName, String lastname, String emailAddress){
        this.firstName = firstName;
        this.lastname = lastname;
        this.emailAddress = emailAddress;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public StudentGrades getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(StudentGrades studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public String studentInformation() {
        return getFullName() + " " + getEmailAddress() + " " + getStudentGrades();
    }

    @Override
    public String getFullName() {
        return getFirstName() + " " + getLastname();
    }
}
