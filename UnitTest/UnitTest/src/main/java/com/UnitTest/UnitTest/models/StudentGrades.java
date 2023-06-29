package com.UnitTest.UnitTest.models;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class StudentGrades {

    private List<Double> mathGradeResults;
    public StudentGrades(){
        System.out.println("Student Grades constructor");
    }

    public StudentGrades(List<Double> mathGradeResults){
        this.mathGradeResults = mathGradeResults;
    }
    public double addGradeResultForSingleClass(List<Double> grades){
        double result = 0;
        for(double d: grades){
            result += d;
        }

        return result;
    }

    public double findGradePointAverage(List<Double> grades){
        int lengthOfGrades = grades.size();
        double sum = addGradeResultForSingleClass(grades);
        double result = sum / lengthOfGrades;

        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, RoundingMode.HALF_UP);
        return resultRound.doubleValue();
    }

    public Boolean isGradeGreater(double gradeOne, double gradeTwo){
        return gradeOne > gradeTwo;
    }

    public Object checkNull(Object obj){
        return obj;
    }

    public List<Double> getMathGradeResults(){return mathGradeResults;}

    public void setMathGradeResults(List<Double> mathGradeResults) {
        this.mathGradeResults = mathGradeResults;
    }

    @Override
    public String toString() {
        return "StudentGrades{" +
                "mathGradeResults=" + mathGradeResults +
                '}';
    }
}
