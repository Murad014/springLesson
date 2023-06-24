package com.studentMVC.studentMVC.entity;

import jakarta.persistence.*;


//CREATE TABLE lesson(
//        id INT PRIMARY KEY AUTO_INCREMENT,
//        lesson_name VARCHAR(50) NOT NULL,
//        credit DECIMAL DEFAULT 0.00,
//        money DECIMAL DEFAULT 0.00,
//        is_active tinyint DEFAULT 1,
//        student_id INT DEFAULT NULL,
//        FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE NO ACTION ON UPDATE NO ACTION
//        );

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="lesson_name")
    private String lessonName;

    @Column(name="credit")
    private double credit;

    @Column(name="money")
    private double money;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name="is_active")
    private int isActive;

    public Lesson(){

    }

    public Lesson(String lessonName, double credit, double money, int isActive) {
        this.lessonName = lessonName;
        this.credit = credit;
        this.money = money;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", credit=" + credit +
                ", money=" + money +
                ", isActive=" + isActive +
                '}';
    }
}
