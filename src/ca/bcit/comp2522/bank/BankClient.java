package ca.bcit.comp2522.bank;

public class BankClient {
    private final Name clientName;
    private final Date birthDate;
    private final Date deathDate;
    private final int clientNumber;
    private final Date signupDate;

    public BankClient(final Name clientName, final Date birthDate,
                      final Date deathDate,  final int clientNumber,
                      final Date signupDate) {
        this.clientName = clientName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.clientNumber = clientNumber;
        this.signupDate = signupDate;
    }

    public String getDetails() {
        boolean isClientAlive = deathDate == null;

        String status = isClientAlive ? "(alive)" : "(died " + deathDate + ")";

        return clientName.getFullName() +
                " client " +
                clientNumber +
                status +
                " joined the bank on " +
                signupDate.toString();
    }

    public String getClientName() {
        return clientName.getFullName();
    }

}
