package com.hibernateAdvance.hibernateAdvance.dao;

import com.hibernateAdvance.hibernateAdvance.entity.Course;
import com.hibernateAdvance.hibernateAdvance.entity.Instructor;
import com.hibernateAdvance.hibernateAdvance.entity.InstructorDetail;
import java.util.*;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void delete(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    void addCourse(Course course);

    Course findCoursById(int id);

}
