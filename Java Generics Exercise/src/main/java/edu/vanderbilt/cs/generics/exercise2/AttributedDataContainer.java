package edu.vanderbilt.cs.generics.exercise2;

/**
 *
 * @ToDo
 *
 * Before starting this exercise, read through the Java
 * Generics Tutorial up to "Bounded Type Parameters":
 *
 * https://docs.oracle.com/javase/tutorial/java/generics/why.html
 *
 *
 */

/**
 * @ToDo
 *
 * The DataContainerTest does not compile because this class
 * isn't parameterizable with types that implement Attributed.
 *
 * Refactor the AttributedDataContainer class so that the "data"
 * can be parameterized with any type that implements the
 * Attributed interface.
 *
 * You should know what locations to update now, because you
 * completed exercise1.
 *
 * When you are done, the AttributedDataContainerTest should compile
 * and pass the test.
 *
 * After you have passed the AttributedDataContainerTest, uncomment
 * the lines in the MappingTest and
 * move on to the Mapping class.
 *
 */

// You will need to update the class declaration
public class AttributedDataContainer<T extends Attributed<?>> {

    private double lat;
    private double lon;

    // This will need updating
    private T data;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    // This will need updating
    public T getData() {
        return data;
    }

    // This will need updating
    public void setData(T data) {
        this.data = data;
    }
}
