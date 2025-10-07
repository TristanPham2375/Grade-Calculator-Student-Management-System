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
package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import model.Course;
import model.Student;

/**
 * FileWriterService is responsible for writing formatted output to a text file
 * that lists students and their final course grades in a column-aligned
 * structure.
 * 
 * This class ensures the output is: - Easy to read and visually structured -
 * Sorted by student ID - Rounded to one decimal place
 */
public class FileWriterService extends FileService {

    @Override
    public void log(String message) {
	System.out.println("[Writer] " + message);
    }

    /**
     * Writes formatted student grade data to an output file.
     * 
     * The output includes a header and a list of: Student ID | Student Name |
     * Course Code | Final Grade All columns are aligned using fixed-width
     * formatting.
     * 
     * @param studentMap a map of studentId to Student objects
     * @param outputPath the destination path of the formatted output file
     * @throws IOException if the file cannot be written to
     */
    public void writeFormattedGrades(Map<String, Student> studentMap, String outputPath) throws IOException {
	// Convert the map to a list and sort students by ID
	List<Student> sortedStudents = new ArrayList<>(studentMap.values());
	sortedStudents.sort(Comparator.comparing(Student::getId));

	// Try-with-resources to ensure writer is closed automatically
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

	    // Write formatted header
	    String header = String.format("%-12s %-25s %-10s %-11s", "Student ID", "Student Name", "Course",
		    "Final Grade");
	    bw.write(header);
	    bw.newLine();

	    // Write separator line under header
	    bw.write("=".repeat(header.length()));
	    bw.newLine();

	    // Write each student's courses and final grades
	    for (Student s : sortedStudents) {
		for (Course c : s.getCourses()) {
		    double finalGrade = c.calculateFinalGrade();

		    // Format: left-aligned columns, final grade right-aligned with 1 decimal
		    String line = String.format("%-12s %-25s %-10s %10.1f", s.getId(), s.getName(), c.getCode(),
			    finalGrade);

		    bw.write(line);
		    bw.newLine();
		}
	    }
	}
    }
}
