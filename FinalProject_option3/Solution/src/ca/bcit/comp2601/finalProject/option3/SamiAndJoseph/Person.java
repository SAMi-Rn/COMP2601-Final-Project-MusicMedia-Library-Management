package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The Person class
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final String ageGroup;

    /**
     * main constructor
     * @param firstName String for the firstName
     * @param lastName String for the lastName
     * @param ageGroup String for the age group
     */
    public Person(final String firstName,
                  final String lastName,
                  final String ageGroup) {
        this.firstName = StringValidator.validString(firstName);
        this.lastName  = StringValidator.validString(lastName);
        this.ageGroup  = StringValidator.validString(ageGroup);
    }

    /**
     * getter for the firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * getter for the lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * getter for the ageGroup
     * @return ageGroup
     */
    public String getAgeGroup() {
        return ageGroup;
    }

    @Override
    public String toString() {
        return firstName + '|' + lastName + '|' + ageGroup;
    }
}
