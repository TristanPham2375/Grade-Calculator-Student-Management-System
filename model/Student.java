/**
 * Course: CP317 - Software Engineering
 * 
 * Authors:
 * 1. 169066333 - Nguyen Hai Trung Pham - pham6333@mylaurier.ca
 * 2. 210815190 - Delaney Regehr        - rege5190@mylaurier.ca
 * 3. 169064727 - Wilfred William       - will4727@mylaurier.ca
 * 4. 169067908 - Nicole Murison        - muri7908@mylaurier.ca
 * 
 * @version 2025-07-04
 */
/**
 * Course: CP317 - Software Engineering
 * 
 * Authors:
 * 1. 169066333 - Nguyen Hai Trung Pham - pham6333@mylaurier.ca
 * 2. 210815190 - Delaney Regehr        - rege5190@mylaurier.ca
 * 3. 169064727 - Wilfred William       - will4727@mylaurier.ca
 * 4. 169067908 - Nicole Murison        - muri7908@mylaurier.ca
 * 
 * @version 2025-07-04
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Student class represents a student with a unique ID and name.
 * 
 * Each student may be enrolled in multiple courses. This class stores a list of
 * all associated Course objects and allows adding new ones.
 * 
 * This class uses encapsulation to protect internal data and provides safe
 * access and mutation methods.
 */
public class Student extends Person {
    private List<Course> courses = new ArrayList<>(); // List of Course objects taken by the student

    /**
     * Constructs a Student with a given ID and name.
     * 
     * @param studentId the student's ID (must not be null)
     * @param name      the student's name (must not be null)
     * @throws IllegalArgumentException if studentId or name is null
     */
    public Student(String studentId, String name) {
	super(studentId, name);
	if (studentId == null || name == null) {
	    throw new IllegalArgumentException("Student data cannot be null");
	}
	this.courses = new ArrayList<>();
    }

    /**
     * Returns the list of courses the student is enrolled in.
     * 
     * @return list of Course objects
     */
    public List<Course> getCourses() {
	return courses;
    }

    /**
     * Adds a course to the student's course list. Ignores null input (offensive
     * programming).
     * 
     * @param course a valid Course object to add
     */
    public void addCourse(Course course) {
	if (course != null) {
	    this.courses.add(course);
	}
    }

    /**
     * Returns the role of this person (used for polymorphism).
     * 
     * @return the string "Student"
     */
    @Override
    public String getRole() {
	return "Student";
    }
}
