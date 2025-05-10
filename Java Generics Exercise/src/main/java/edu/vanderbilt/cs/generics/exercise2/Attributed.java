package edu.vanderbilt.cs.generics.exercise2;

import java.util.List;

/**
 * @ToDo
 *
 * Before going farther, proceed up to the Type Inference
 * section of the Java Generics Tutorial:
 * https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
 *
 * Right now, we can only have attributes that are Strings.
 * Refactor this class so that Attributed is parameterized
 * by a type that determines the type of the attributes.
 * The parameterization should be at the *interface* level
 * and not the method-level.
 *
 *
 */
public interface Attributed<T> {

    public List<T> getAttributes();

}
