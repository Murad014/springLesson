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

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST,
    })
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    public void addStudent(Student student){
        if(students == null)
            students = new ArrayList<>();

        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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
