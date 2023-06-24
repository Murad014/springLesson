package com.studentMVC.studentMVC.entity;

//CREATE TABLE student(
//        id INT PRIMARY KEY AUTO_INCREMENT,
//        first_name VARCHAR(30) NOT NULL,
//        last_name VARCHAR(30) NOT NULL,
//        email VARCHAR(30) NOT NULL UNIQUE,
//        phone VARCHAR(20) NOT NULL UNIQUE,
//        is_active TINYINT DEFAULT 1
//        );

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="is_active")
    private int isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Lesson> lessons;

    public Student(){

    }

    public Student(String firstName, String lastName, String email, String phone, int isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
