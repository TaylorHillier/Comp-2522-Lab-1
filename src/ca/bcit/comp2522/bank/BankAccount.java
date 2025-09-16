package ca.bcit.comp2522.bank;

/**
 * Represents a bank account owned by a Bank Client. A
 * Bank Account tracks the client, account number, open/close
 * dates, associated PIN, and the current balance in USD.
 *
 */
public class BankAccount {
    private final BankClient client;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;
    private final int pin;
    private double balanceUsd;

    /**
     * Constructs a new BankAccount.
     *
     * @param client        the client who owns the account
     * @param accountNumber the unique identifier for this account
     * @param accountOpened the date the account was opened
     * @param accountClosed the date the account was closed, or {@code null} if still open
     * @param pin           the security PIN for account access
     */
    public BankAccount(final BankClient client, final String accountNumber,
                       final Date accountOpened, Date accountClosed, final int pin) {
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.pin = pin;
    }

    /**
     * Withdraws funds from the account without PIN verification.
     *
     * @param amountUsd the amount to withdraw in USD
     */
    public void withdraw(final double amountUsd) {
        balanceUsd -=  amountUsd;
    }

    /**
     * Withdraws funds from the account if the provided PIN matches.
     *
     * @param amountUsd  the amount to withdraw in USD
     * @param pinToMatch the PIN provided for verification
     * @throws IllegalArgumentException if the provided PIN does not match
     */
    public void withdraw(final double amountUsd, final int pinToMatch) {
        if(pinToMatch == pin) {
            balanceUsd -= amountUsd;
        } else {
            throw new IllegalArgumentException("Pin does not match.");
        }
    }

    /**
     * Deposits funds into the account.
     *
     * @param amountUsd the amount to deposit in USD
     */
    public void deposit(final double amountUsd){
        balanceUsd += amountUsd;
    }

    /**
     * Returns a formatted string with account details including the
     * client’s name, balance, account number, open date, and whether the
     * account is closed or still open.
     *
     * @return a string containing account details
     */
    public String getDetails() {
        String accountClosedMessage;

        accountClosedMessage = accountClosed != null ? (" closed " + accountClosed) : " is still open";

        return client.getClientName() +
                " had $" +
                balanceUsd +
                " USD in account #" +
                accountNumber +
                " which he opened on " +
                accountOpened.toString() +
                " " +
                accountClosedMessage;
    }

    /**
     * Returns the current account balance in USD.
     *
     * @return the account balance
     */
    public double getBalanceUsd() {
        return balanceUsd;
    }
}
