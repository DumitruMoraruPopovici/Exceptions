package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {

    List<Student> studentList = new ArrayList<>();
    LocalDate curentDate = LocalDate.now();
    private int studentAge = 0;


    /**
     * method for adding a student in our list with validation for name, date of birth, gender and id
     */

    public List<Student> addStudent(String firstName, String lastName, LocalDate birthDate, String genderType, String id) throws ValidationException {

        if (birthDate.getYear() < 1900 || birthDate.getYear() > curentDate.getYear() - 18) {
            throw new ValidationException("Date of birth must be between 1900 and curent year -18");
        }
        if (firstName == null || lastName == null) {
            throw new ValidationException("First name and last name must not be empty");
        }
        if (!(genderType.equalsIgnoreCase("FEMALE") || genderType.equalsIgnoreCase("MALE"))) {
            throw new ValidationException("Gender should be MALE or FEMALE");
        }

        if (id.length() != 13) {
            throw new ValidationException("Id should have 13 characters");
        }

        if (genderType.equalsIgnoreCase("FEMALE")) {
            studentList.add(new Student(firstName, lastName, birthDate, Gender.FEMALE, id));
        } else {
            studentList.add(new Student(firstName, lastName, birthDate, Gender.MALE, id));
        }

        return studentList;
    }

    /**
     * Method for deleting students by ID and with the validation for the id
     */
    public List<Student> deleteStudent(String idForRemove) throws ValidationException {
        if (idForRemove == null || idForRemove.equalsIgnoreCase(" ")) {
            throw new ValidationException("Id shouldnt be empty");
        }

        for (Student student : studentList) {
            if (idForRemove.equals(student.id)) {
                studentList.remove(student);
                System.out.println("Student with the ID" + idForRemove + " was erased from the list");
                break;

            } else throw new ValidationException("Student doesnt exist");
        }
        return studentList;
    }

    /**
     * Method for calculating the age for a student
     */
    public int calculateAgeOfStudent(Student student) {
        return studentAge = curentDate.getYear() - student.birthDate.getYear();
    }

    /**
     * Method for retrieving a list of students with a certain age saved in to another list of students with that certain age
     * and with the required validation
     */
    public List<Student> retrieveStudent(int age) throws ValidationException {
        List<Student> studentWithAgeToRetrieve = new ArrayList<>();
        if (age < 0) {
            throw new ValidationException("Age must not be negative");
        }
        try {
            age = Integer.parseInt(String.valueOf(age));
        } catch (NumberFormatException e) {
            throw new ValidationException("Age is not a number");
        }

        for (Student student : studentList) {
            if (calculateAgeOfStudent(student) == age) {
                studentWithAgeToRetrieve.add(student);
            }
        }
        System.out.println(studentWithAgeToRetrieve.toString());
        return studentWithAgeToRetrieve;
    }

    /**
     * Method for sorting in order of last Name with validation for null student
     */
    public List<Student> listStudentByLastName() throws ValidationException {
        for (Student student : studentList) {
            if (student == null) {
                throw new ValidationException("We have an empty input");
            }
        }
        Collections.sort(studentList, new LastNameComparator());
        System.out.println("Sorted by last name " + studentList);
        return studentList;
    }

    /**
     * Method for sorting students in order of birth date
     */
    public List<Student> listStudentByBirthDate() throws ValidationException {
        for (Student student : studentList) {
            if (student == null) {
                throw new ValidationException("We have an empty input");
            }
        }
        Collections.sort(studentList, new BirthDateComparator());
        System.out.println("Sorted by birth name " + studentList);
        return studentList;
    }
}

