package com.HibernateValidation.HibernateValidation.modelView;


import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class Customer {

    @NotNull(message = "Name is required")
    @Size(min=2, max=20, message = "Name length must be between 2 and 20")
    private String firstName;

    @NotNull(message = "Surname is required")
    @Size(min=2, max=20, message = "Surname length must be between 2 and 20")
    private String lastName;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be equals or large than 0")
    @Max(value = 150, message = "Age must be range 1 to 150")
    @Digits(integer = 3, fraction = 0, message = "Age must be a numeric value")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
