package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title_course")
    private String titleCourse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @OneToMany
    @JoinColumn(name="course_id")
    private List<Review> reviews;


    public Course(){}

    public Course(String titleCourse, Instructor instructor) {
        this.titleCourse = titleCourse;
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleCourse() {
        return titleCourse;
    }

    public void setTitleCourse(String titleCourse) {
        this.titleCourse = titleCourse;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void addReview(Review tempReview){
        if(reviews == null)
            reviews = new ArrayList<>();

        reviews.add(tempReview);


    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", titleCourse='" + titleCourse + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
