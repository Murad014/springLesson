package com.UnitTest.UnitTest;

import com.UnitTest.UnitTest.models.CollageStudent;
import com.UnitTest.UnitTest.models.StudentGrades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class SBUnitTest {
    private static int count = 0;
    @Value("${info.app.name}")
    private String appInfo;
    @Value("${info.app.description}")
    private String appDescription;
    @Value("${info.app.version}")
    private String appVersion;
    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    private CollageStudent student;
    @Autowired
    private StudentGrades studentGrades;

    @BeforeEach
    public void beforeEach(){
        count ++;
        System.out.println("Testing: " + appInfo + " which is " + appDescription +
                " Version: " + appVersion + ". Execution of test method." + count);
        student.setFirstName("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric.roby@asdasd.az");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.00, 85.00, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);
    }

    @DisplayName("Add grade results for student grades")
    @Test
    public void addGradeResultsForStudentGrades(){
        System.out.println(student.getStudentGrades().getMathGradeResults());
        Assertions.assertEquals(353.25,
                studentGrades.addGradeResultForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }

}
