package org.example;

import java.time.LocalDate;

/**
 *     create a Student repository which supports
 *     add student - exceptions when validating conditions mentioned bellow
 *     delete student (by ID - identifier) - exceptions: ID is empty, student does not exist
 *     retrieve all students with age X (for each student the age must be calculated, not stored in a field) - exceptions: age is not a number, age is negative
 *     list students and order by Last Name or Birth Date - exceptions: any input is empty
 *     these methods must validate inputs and throw exceptions if necessary
 * NOTES
 *     for each Student the following information needs to be collected
 *     First Name
 *     Last Name
 *     Date of Birth
 *     Gender
 *     ID (CNP)
 *     the following validations are expected
 *     date of birth between 1900 and current year - 18
 *     first name and last name should not be empty
 *     gender should be male or female (or M and F), upper / lower case should both be accepted
 *     for all the validations, the corresponding exception(s) should be thrown when a Student is created with data which breaks the validation constraint
 *     the testing application can demonstrate the implementation of the above requirements without requiring a special menu for creating the students or for choosing the operation
 *     create several test methods which perform separately a given scenario
 *     additionally, you should use Logger for tracing and error handling
 *
 *     Classes : StudentRepository, Student, Gender(Enum);
 *     Verbs : addStudent, deleteStudent, retrieveStudent, calculateAge, listAllStudents;
 *     Param: firstName, lastName, birthDate, gender, id;
 */
public class App 
{
    public static void main( String[] args ) throws ValidationException {
      StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent("Alexandra", "Popovici", LocalDate.of(1989,7,10),"FEMALE","2890710265356");
        studentRepository.addStudent("Alexandru", "Moraru", LocalDate.of(1994,6,10),"MALE","1890710265356");
        studentRepository.addStudent("Dumitru", "Barlea", LocalDate.of(1987,8,1),"MALE","1870710265356");
        studentRepository.listStudentByLastName();
        studentRepository.listStudentByBirthDate();
        studentRepository.deleteStudent("1870710265356");
        studentRepository.retrieveStudent(34);


    }
}

