package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The StringValidator class to validate the Strings in the package
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class StringValidator
{
    /**
     * check if the String is null or blank to throw the IllegalArgumentException
     * @param string is the String we try to validate
     * @return String if it is valid
     */
    public static String validString (final String string)
    {
        if (string == null || string.isBlank())
        {
            throw new IllegalArgumentException("Invalid Input!");
        }

        return string;
    }
}
