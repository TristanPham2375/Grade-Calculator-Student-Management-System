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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.Course;
import model.Student;

/**
 * FileReaderService is responsible for reading structured input data from text
 * files and constructing in-memory objects such as Student and Course.
 * 
 * This class separates file reading logic from business logic to support
 * abstraction and modular design.
 */
public class FileReaderService extends FileService {
    @Override
    public void log(String message) {
	System.err.println("[Reader] " + message);
    }

    /**
     * Reads the NameFile.txt and constructs a map of Student objects.
     * 
     * Each line in the file should be in the format: studentId, studentName
     * 
     * @param nameFilePath the path to the NameFile.txt file
     * @return a map of studentId to Student objects
     * @throws IOException if file cannot be opened or read
     */
    public Map<String, Student> readStudents(String nameFilePath) throws IOException {
	Map<String, Student> studentMap = new HashMap<>();

	try (BufferedReader br = new BufferedReader(new FileReader(nameFilePath))) {
	    String line;
	    int lineNum = 0;

	    while ((line = br.readLine()) != null) {
		lineNum++;
		line = line.trim();

		if (line.isEmpty()) {
		    System.err.println("Line " + lineNum + " (NameFile.txt): Invalid format in: # Blank line");
		    continue;
		}

		String[] parts = line.split(",", -1); // keep empty tokens

		if (parts.length != 2) {
		    System.err.println("Line " + lineNum + " (NameFile.txt): Invalid format in: " + line);
		    continue;
		}

		String id = parts[0].trim();
		String name = parts[1].trim();

		if (id.isEmpty() || name.isEmpty()) {
		    System.err.println("Line " + lineNum + " (NameFile.txt): Invalid format in: " + line);
		    continue;
		}

		// Check if ID is numeric
		if (!id.matches("\\d+")) {
		    System.err.println("Line " + lineNum + " (NameFile.txt): Invalid format in: " + line);
		    continue;
		}

		studentMap.put(id, new Student(id, name));
	    }
	}

	return studentMap;
    }

    /**
     * Reads the CourseFile.txt and updates existing students with their courses.
     * 
     * Each line should be in the format: studentId, courseCode, test1, test2,
     * test3, finalExam
     * 
     * Courses are only added for student IDs already in the map.
     * 
     * @param courseFilePath path to the CourseFile.txt file
     * @param studentMap     a pre-populated map of students
     * @throws IOException if file reading fails
     */
    public void readCourses(String courseFilePath, Map<String, Student> studentMap) throws IOException {
	try (BufferedReader br = new BufferedReader(new FileReader(courseFilePath))) {
	    String line;
	    int lineNum = 0;

	    while ((line = br.readLine()) != null) {
		lineNum++;
		line = line.trim();

		if (line.isEmpty()) {
		    System.err.println("Line " + lineNum + " (CourseFile.txt): Invalid format in: # Blank line");
		    continue;
		}

		String[] parts = line.split(",", -1);

		if (parts.length != 6) {
		    System.err.println("Line " + lineNum + " (CourseFile.txt): Invalid format in: " + line);
		    continue;
		}

		String id = parts[0].trim();
		String courseCode = parts[1].trim();
		double[] grades = new double[4];

		if (id.isEmpty() || courseCode.isEmpty()) {
		    System.err.println("Line " + lineNum + " (CourseFile.txt): Invalid grade format in: " + line);
		    continue;
		}

		// Ensure ID is digits only
		if (!id.matches("\\d+")) {
		    System.err.println("Line " + lineNum + " (CourseFile.txt): Invalid grade format in: " + line);
		    continue;
		}

		boolean valid = true;
		for (int i = 0; i < 4; i++) {
		    String gradeStr = parts[i + 2].trim();
		    try {
			grades[i] = Double.parseDouble(gradeStr);
		    } catch (NumberFormatException e) {
			System.err.println("Line " + lineNum + " (CourseFile.txt): Invalid grade format in: " + line);
			valid = false;
			break;
		    }
		}

		if (!valid) {
		    continue;
		}

		if (!studentMap.containsKey(id)) {
		    System.err.println("Line " + lineNum + " (CourseFile.txt): Invalid grade format in: " + line);
		    continue;
		}

		studentMap.get(id).addCourse(new Course(courseCode, grades));
	    }
	}
    }
}
