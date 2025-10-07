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
 * GradeCalculator provides a static utility method to compute a student's final
 * grade for a course based on four numerical inputs.
 * 
 * The calculation follows a specific weighting: - Test 1: 20% - Test 2: 20% -
 * Test 3: 20% - Final Exam: 40%
 * 
 * This utility is used by the Course class to compute final grades and ensures
 * consistent grade computation across the system.
 */
public class GradeCalculator {

    /**
     * Calculates the final grade using the formula: (Test1 + Test2 + Test3) * 0.2 +
     * FinalExam * 0.4
     * 
     * Grades are assumed to be between 0 and 100.
     *
     * @param grades An array of four doubles: [test1, test2, test3, finalExam]
     * @return Final weighted grade, rounded to one decimal place
     * @throws IllegalArgumentException if the grades array is null or not exactly 4
     *                                  elements long
     */
    public static double calculateFinalGrade(double[] grades) {
	if (grades == null || grades.length != 4) {
	    throw new IllegalArgumentException("Grade array must contain exactly four elements.");
	}

	double finalGrade = (grades[0] + grades[1] + grades[2]) * 0.2 + grades[3] * 0.4;

	// Round to one decimal place
	return Math.round(finalGrade * 10) / 10.0;
    }
}