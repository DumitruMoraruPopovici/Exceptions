package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void givenAStudentRepositoryAddStudent() throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();

        studentRepository.addStudent("Alex", "Baba", LocalDate.of(1987,1,2), "FEMALE", "1234567891234");

        assertEquals(1, studentRepository.studentList.size());
    }

    @Test
    void givenAStudentRepositoryDeleteStudentById () throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent("Alex", "Baba", LocalDate.of(1987,1,2), "FEMALE", "1234567891234");
        studentRepository.deleteStudent("1234567891234");

        assertEquals(0,studentRepository.studentList.size());
    }

    @Test
    void givenAgeCalculateAgeOfStudent () throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Alex", "Baba", LocalDate.of(1987,1,2), Gender.FEMALE, "1234567891234");

        assertEquals(36, studentRepository.calculateAgeOfStudent(student));

    }

    @Test
    void givenAStudentRepositoryRetrieveStudentByAge () throws ValidationException {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent("Alex", "Baba", LocalDate.of(1987,1,2), "FEMALE", "1234567891234");

        List<Student> studentToRetrieveByAge = studentRepository.retrieveStudent(36);

        assertEquals(1,studentToRetrieveByAge.size());

    }


}