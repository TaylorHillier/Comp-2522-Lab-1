package ca.bcit.comp2522.bank;

/**
 * Represents a client of the bank. A {@code BankClient} stores identifying
 * information such as the client's name, birthdate, optional death date,
 * client number, and the date they signed up with the bank.
 */
public class BankClient {
    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final int clientNumber;
    private final Date signupDate;

    /**
     * Constructs a new {@code BankClient}.
     *
     * @param clientName  the client's name
     * @param birthDate   the client's date of birth
     * @param deathDate   the client's date of death, or {@code null} if alive
     * @param clientNumber the unique client identifier
     * @param signupDate  the date the client joined the bank
     */
    public BankClient(final Name clientName, final Date birthDate,
                      final Date deathDate, final int clientNumber,
                      final Date signupDate) {
        this.clientName = clientName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.clientNumber = clientNumber;
        this.signupDate = signupDate;
    }

    /**
     * Returns a string containing client details including their full name,
     * client number, status (alive or with date of death), and the date they
     * joined the bank.
     *
     * @return a formatted string with client details
     */
    public String getDetails() {
        boolean clientAlive;
        String statusMessage;

        clientAlive = deathDate == null;

        statusMessage = clientAlive ? "(alive)" : "(died " + deathDate + ")";

        return clientName.getFullName() +
                " client " +
                clientNumber +
                statusMessage +
                " joined the bank on " +
                signupDate.toString();
    }

    /**
     * Returns the client's full name.
     *
     * @return the client's name as a string
     */
    public String getClientName() {
        return clientName.getFullName();
    }
}
