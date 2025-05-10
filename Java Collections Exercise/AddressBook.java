package edu.vanderbilt.cs.collections;

import java.util.*;
import java.util.List;

/**
 * @ToDo
 *
 * Implement all the methods in this class using either:
 *
 * 1. A single Java Map with a compound key strategy
 *    (e.g., String key = "person." +personName + ".phone." + phoneType)
 *
 * 2. A master map with sub-maps for each individual person
 *    String key = personName;
 *    Map personData = ....
 *    personData.put("phone" + phoneType, phoneNumber);
 *    Map addressBookData = ....
 *    addressBookData.put(key, personData);
 *
 * Whatever you do, you must have at least one Map that associates
 * a person's name with their data. It is not acceptable to have a
 * list of objects that you search through sequentially to find the
 * person in.
 *
 * There can only be one entry in the AddressBook for a given
 * name.
 *
 */
public class AddressBook {
    // Master map that holds each person's data
    private final Map<String, Map<String, Object>> addressBookData = new HashMap<>();

    /**
     * Sets the person's primary phone number in the address book.
     * @param personName Name of the person.
     * @param phoneNumber Primary phone number of the person.
     */
    public void setPersonPhoneNumber(String personName, String phoneNumber) {
        setPersonDetail(personName, "primaryPhone", phoneNumber);
    }

    /**
     * Gets the person's primary phone number from the address book.
     * @param personName Name of the person.
     * @return Primary phone number of the person, or null if not found.
     */
    public String getPersonPhoneNumber(String personName) {
        return (String) getPersonDetail(personName, "primaryPhone");
    }

    /**
     * Sets a phone number of a specific type for the person in the address book.
     * @param personName Name of the person.
     * @param phoneType Type of phone (e.g., "mobile", "home").
     * @param phoneNumber Phone number of the specified type.
     */
    public void setPersonPhoneNumber(String personName, String phoneType, String phoneNumber) {
        setPersonDetail(personName, "phone." + phoneType, phoneNumber);
    }

    /**
     * Gets the phone number of a specific type for the person from the address book.
     * @param personName Name of the person.
     * @param phoneType Type of phone (e.g., "mobile", "home").
     * @return Phone number of the specified type, or null if not found.
     */
    public String getPersonPhoneNumber(String personName, String phoneType) {
        return (String) getPersonDetail(personName, "phone." + phoneType);
    }

    /**
     * Sets the person's email address in the address book.
     * @param personName Name of the person.
     * @param email Email address of the person.
     */
    public void setPersonEmail(String personName, String email) {
        setPersonDetail(personName, "email", email);
    }

    /**
     * Gets the person's email address from the address book.
     * @param personName Name of the person.
     * @return Email address of the person, or null if not found.
     */
    public String getPersonEmail(String personName) {
        return (String) getPersonDetail(personName, "email");
    }

    /**
     * Adds a note about the person in the address book.
     * @param personName Name of the person.
     * @param noteType Type of note (e.g., "birthday", "favorite food").
     * @param data Content of the note.
     */
    public void setPersonNote(String personName, String noteType, String data) {
        setPersonDetail(personName, "note." + noteType, data);
    }

    /**
     * Gets a note about the person from the address book.
     * @param personName Name of the person.
     * @param noteType Type of note (e.g., "birthday", "favorite food").
     * @return Content of the note, or null if not found.
     */
    public String getPersonNote(String personName, String noteType) {
        return (String) getPersonDetail(personName, "note." + noteType);
    }

    /**
     * Sets the age of the person in the address book.
     * @param personName Name of the person.
     * @param age Age of the person.
     */
    public void setPersonAge(String personName, int age) {
        setPersonDetail(personName, "age", age);
    }

    /**
     * Gets the age of the person from the address book.
     * @param personName Name of the person.
     * @return Age of the person, or null if not found.
     */
    public Integer getPersonAge(String personName) {
        return (Integer) getPersonDetail(personName, "age");
    }

    /**
     * Returns a list of all names in the address book.
     * @return Array of names in the address book.
     */
    public String[] listNames() {
        Set<String> names = addressBookData.keySet();
        return names.toArray(new String[0]);
    }

    /**
     * Returns a list of names that start with the specified prefix.
     * If the prefix is null, it returns all names.
     * @param prefix Prefix to filter names.
     * @return List of names that start with the prefix.
     */
    public List<String> namesThatStartWith(String prefix) {
        List<String> matchingNames = new ArrayList<>();
        for (String name : addressBookData.keySet()) {
            if (prefix == null || name.startsWith(prefix)) {
                matchingNames.add(name);
            }
        }
        return matchingNames;
    }

    /**
     * Helper method to set a detail for a person in the address book.
     * @param personName Name of the person.
     * @param detailKey Key representing the detail (e.g., "primaryPhone", "email").
     * @param detailValue Value of the detail.
     */
    private void setPersonDetail(String personName, String detailKey, Object detailValue) {
        // Get the sub-map for the person, or create a new one if it doesn't exist
        Map<String, Object> personData = addressBookData.getOrDefault(personName, new HashMap<>());
        // Add or update the detail in the sub-map
        personData.put(detailKey, detailValue);
        // Put the updated sub-map back into the master map
        addressBookData.put(personName, personData);
    }

    /**
     * Helper method to get a detail for a person from the address book.
     * @param personName Name of the person.
     * @param detailKey Key representing the detail (e.g., "primaryPhone", "email").
     * @return Value of the detail, or null if not found.
     */
    private Object getPersonDetail(String personName, String detailKey) {
        // Get the sub-map for the person
        Map<String, Object> personData = addressBookData.get(personName);
        // Return the detail if it exists, or null if it doesn't
        return (personData != null) ? personData.get(detailKey) : null;
    }
}