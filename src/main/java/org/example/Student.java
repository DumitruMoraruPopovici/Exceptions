package org.example;

import java.time.LocalDate;

/**
 * Blueprint Class for student with parameters and behaviors
 */
public class Student {
    String firstName;
    String lastName;
    LocalDate birthDate;
    Gender gender;
    String id;

    public Student(String firstName, String lastName, LocalDate birthDate, Gender gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student " +
                firstName + '\'' +
                " " + lastName + '\'' +
                " with birthDate " + birthDate +
                ", gender=" + gender +
                ", id='" + id + '\'';
    }
}
