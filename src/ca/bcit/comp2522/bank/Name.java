package ca.bcit.comp2522.bank;

/**
 * This Name class represents a person's name with methods such as
 * returning initials, full name reversed full name and validating names.
 *
 * @author Taylor Hillier
 * @author Calvin Nguyen
 * @version 1.0
 */
public class Name {

    /** Maximum length allowed for a name in characters. */
    private static final int MAX_NAME_LENGTH = 45;

    /** A string that is not allowed in any name. */
    private static final String BANNED_NAME = "admin";

    /** The person's first name. */
    private final String first;

    /** The person's last name. */
    private final String last;

    /**
     * Constructs a new Name object.
     *
     * @param first for the first name
     * @param last for the last name
     * @throws IllegalArgumentException if null, blank, too long, or contains "admin"
     */
    public Name(final String first, final String last){
        validateName(first);
        validateName(last);

        this.first = first;
        this.last = last;
    }

     /**
      * Validation method that checks Name if it's null, blank, too long
      * or contains the word "admin"
      *
      * @param name for the name to validate
      * @throws IllegalArgumentException if null, blank, too long, or contains "admin"
      */
    private static void validateName(final String name) {
        if (name == null
                || name.isBlank()
                || name.length() >= MAX_NAME_LENGTH
                || name.toLowerCase().contains(BANNED_NAME.toLowerCase())) {
            throw new IllegalArgumentException("Name is not valid");
        }
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirst(){
        return first;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLast(){
        return last;
    }

    /**
     * Returns initials in the format "T.W.".
     *
     * @return the initials
     */
    public String getInitials(){
        final String firstInitial;
        final String lastInitial;

        firstInitial = first.substring(0, 1).toUpperCase();
        lastInitial = last.substring(0, 1).toUpperCase();

        return (firstInitial + "." + lastInitial + ".");
    }

    /**
     * Returns the full name with proper capitalization.
     *
     * @return the full name with capitalization applied
     */
    public String getFullName(){
        final String firstNameFirstLetter;
        final String lastNameFirstLetter;

        firstNameFirstLetter = first.substring(0, 1).toUpperCase();
        lastNameFirstLetter = last.substring(0, 1).toUpperCase();

        final String restOfFirstName;
        final String restOfLastName;

        restOfFirstName = first.substring(1).toLowerCase();
        restOfLastName = last.substring(1).toLowerCase();

        return (firstNameFirstLetter + restOfFirstName + " "
                + lastNameFirstLetter + restOfLastName);
    }

    /**
     * Returns the full name reversed.
     *
     * @return the full name as a reversed string
     */
    public String getReverseName() {
        final String fullName;
        fullName = getFullName();
        return new StringBuilder(fullName).reverse().toString();
    }

}
