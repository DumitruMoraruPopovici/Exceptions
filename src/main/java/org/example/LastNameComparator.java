package org.example;

import java.util.Comparator;

/**
 *  Comparator for last name
 */
public class LastNameComparator implements Comparator<Student> {
    public int compare (Student s1, Student s2) {
        return s1.lastName.compareTo(s2.lastName);
    }

}
