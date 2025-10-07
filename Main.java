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
package app;

import java.io.IOException;
import java.util.Map;

import model.Student;
import service.FileReaderService;
import service.FileWriterService;

/**
 * The Main class is the entry point of the Student Grade Formatter application.
 * 
 * This software reads two input files: - NameFile.txt: contains student IDs and
 * names - CourseFile.txt: contains student IDs, course codes, and grades
 * 
 * It calculates the final grades using the formula: Final Grade = (Test1 +
 * Test2 + Test3) * 0.2 + FinalExam * 0.4
 * 
 * Then it outputs a formatted file (FormattedGrades.txt) with aligned columns:
 * Student ID | Student Name | Course Code | Final Grade
 * 
 * Usage: - Update the input file paths if needed. - Run this class to generate
 * the formatted output file.
 */
public class Main {

    /**
     * The main method of the program.
     * 
     * It initializes file paths, reads input data, processes grades, and writes a
     * formatted report.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
	// Define file paths for (bad) student names, (bad) course grades, and output
	String nameFile = "data/NameFile.txt";
	String nameFileBad = "data/BadNameFile.txt";
	String courseFile = "data/CourseFile.txt";
	String courseFileBad = "data/BadCourseFile.txt";
	String outputFile = "output/FormattedGrades.txt";

	// Instantiate services for reading and writing files
	FileReaderService reader = new FileReaderService();
	FileWriterService writer = new FileWriterService();

	try {
	    // Read student names into a Map<studentId, Student>
	    Map<String, Student> students = reader.readStudents(nameFileBad);

	    // Populate student objects with their course and grade data
	    reader.readCourses(courseFileBad, students);

	    // Write formatted grades to output file (column-aligned)
	    writer.writeFormattedGrades(students, outputFile);

	    // Notify success
	    System.out.println("Formatted grades written successfully.");
	} catch (IOException e) {
	    // Handle and display any I/O errors gracefully
	    System.err.println("File processing error: " + e.getMessage());
	}
    }
}