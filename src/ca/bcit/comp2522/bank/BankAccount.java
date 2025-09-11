package ca.bcit.comp2522.bank;

public class BankAccount {
    private final BankClient client;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;
    private final int pin;
    private double balanceUsd;

    public BankAccount(final BankClient client, final String accountNumber,
                       final Date accountOpened, Date accountClosed, final int pin) {
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.pin = pin;
    }

    public void withdraw(final double amountUsd) {
        balanceUsd -=  amountUsd;
    }

    public void withdraw(final double amountUsd, final int pinToMatch) {
        if(pinToMatch == pin) {
            balanceUsd -= amountUsd;
        } else {
            throw new IllegalArgumentException("Pin does not match.");
        }
    }

    public void deposit(final double amountUsd){
        balanceUsd += amountUsd;
    }

    public String getDetails() {
        String isAccountClosed = accountClosed != null ? (" closed " + accountClosed) : " is still open";
        return client.getClientName() +
                " had $" +
                balanceUsd +
                " USD in account #" +
                accountNumber +
                " which he opened on " +
                accountOpened.toString() +
                " " +
                isAccountClosed;
    }

    public double getBalanceUsd() {
        return balanceUsd;
    }
}
