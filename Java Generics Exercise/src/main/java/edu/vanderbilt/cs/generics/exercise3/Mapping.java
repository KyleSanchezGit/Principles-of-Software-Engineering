package edu.vanderbilt.cs.generics.exercise3;

/**
 * @ToDo
 *
 * A Mapping object stores a relationship between an identifier
 * and a value. For example, you could have mappings of "names"
 * to "people" or mappings of "addresses" to "buildings".
 *
 * Refactor this class so that the classes for the identifier
 * and value can be parameterized separately from each other.
 *
 * After you have passed the MappingTest, uncomment
 * the lines in the NestedDataContainerTest and
 * move on to the NestedDataContainer class.
 */
public class Mapping<I, V> {

    private I identifier;
    private V value;

    public I getIdentifier() {
        return identifier;
    }

    public void setIdentifier(I identifier) {
        this.identifier = identifier;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
