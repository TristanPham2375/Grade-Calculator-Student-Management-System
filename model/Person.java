/**
 * Course: CP317 - Software Engineering
 * 
 * Authors: 1. 169066333 - Nguyen Hai Trung Pham - pham6333@mylaurier.ca 2.
 * 210815190 - Delaney Regehr - rege5190@mylaurier.ca 3. 169064727 - Wilfred
 * William - will4727@mylaurier.ca 4. 169067908 - Nicole Murison -
 * muri7908@mylaurier.ca
 * 
 * @version 2025-07-04
 */
package model;

/**
 * The Person class is an abstract base class representing a general person with
 * an ID and name.
 * 
 * It serves as a superclass for different roles such as Student, Instructor,
 * etc. Demonstrates inheritance and polymorphism by allowing subclasses to
 * override getRole().
 */

public abstract class Person {
    protected final String id; // Unique identifier for the person
    protected final String name; // Full name of the person

    /**
     * Constructs a Person with a given ID and name.
     * 
     * @param id   the person's ID (must not be null)
     * @param name the person's name (must not be null)
     */
    public Person(String id, String name) {
	this.id = id;
	this.name = name;
    }

    /**
     * Returns the ID of the person.
     * 
     * @return the person's ID
     */
    public String getId() {
	return id;
    }

    /**
     * Returns the name of the person.
     * 
     * @return the person's full name
     */
    public String getName() {
	return name;
    }

    /**
     * Abstract method to be overridden by subclasses to return their role.
     * 
     * @return the role (e.g., "Student")
     */
    public abstract String getRole();
}