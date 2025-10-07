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

/**
 * The Course class represents a course taken by a student, including the course
 * code and the grades achieved.
 * 
 * Each course has: - a unique course code (e.g., CP317) - an array of 4 grades:
 * test1, test2, test3, final exam
 * 
 * This class also provides a method to calculate the final grade based on
 * weighted grading policy: - test1/test2/test3: 20% each - final exam: 40%
 */
public class Course {
    private final String code; // Course code (e.g., "CP317")
    private final double[] grades; // Array of 4 grades: 3 tests + 1 final exam

    /**
     * Constructs a new Course with a code and an array of 4 grades.
     * 
     * @param code   the course code (e.g., "CP317")
     * @param grades an array of 4 grades: test1, test2, test3, finalExam
     * @throws IllegalArgumentException if code is null, grades is null, or
     *                                  grades.length != 4
     */
    public Course(String code, double[] grades) {
	if (code == null || grades == null || grades.length != 4) {
	    throw new IllegalArgumentException("Invalid course data");
	}
	this.code = code;
	this.grades = grades;
    }

    /**
     * Returns the course code.
     * 
     * @return the course code
     */
    public String getCode() {
	return code;
    }

    /**
     * Calculates and returns the final grade for this course. Uses GradeCalculator
     * to compute weighted average.
     * 
     * @return final course grade rounded to one decimal
     */
    public double calculateFinalGrade() {
	return GradeCalculator.calculateFinalGrade(grades);
    }
}