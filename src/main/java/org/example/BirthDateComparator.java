package org.example;

import java.util.Comparator;

public class BirthDateComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.birthDate.compareTo(s2.birthDate);
    }
}
