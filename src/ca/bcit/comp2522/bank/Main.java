package ca.bcit.comp2522.bank;

/**
 * The Main class demonstrates the creation of bank clients and accounts,
 * performing deposits and withdrawals, and printing account details.
 *
 */
public class Main {

    // Month Constants
    private static final int JAN = 1;
    private static final int FEB = 2;
    private static final int MAR = 3;
    private static final int APR = 4;
    private static final int MAY = 5;
    private static final int JUN = 6;
    private static final int JUL = 7;
    private static final int AUG = 8;
    private static final int SEP = 9;
    private static final int OCT = 10;
    private static final int NOV = 11;
    private static final int DEC = 12;

    //Einstein Info
    private static final int EINSTEIN_BIRTH_DAY = 14;
    private static final int EINSTEIN_BIRTH_MONTH = MAR;
    private static final int EINSTEIN_BIRTH_YEAR = 1879;

    private static final int EINSTEIN_DEATH_DAY = 18;
    private static final int EINSTEIN_DEATH_MONTH = APR;
    private static final int EINSTEIN_DEATH_YEAR = 1955;

    private static final int EINSTEIN_SIGNUP_DAY = 1;
    private static final int EINSTEIN_SIGNUP_MONTH = JAN;
    private static final int EINSTEIN_SIGNUP_YEAR = 1900;

    private static final int EINSTEIN_CLOSED_DAY = 14;
    private static final int EINSTEIN_CLOSED_MONTH = OCT;
    private static final int EINSTEIN_CLOSED_YEAR = 1950;

    //Mandela Info
    private static final int MANDELA_BIRTH_DAY = 18;
    private static final int MANDELA_BIRTH_MONTH = JUL;
    private static final int MANDELA_BIRTH_YEAR = 1918;

    private static final int MANDELA_DEATH_DAY = 5;
    private static final int MANDELA_DEATH_MONTH = DEC;
    private static final int MANDELA_DEATH_YEAR = 2013;

    private static final int MANDELA_SIGNUP_DAY = 10;
    private static final int MANDELA_SIGNUP_MONTH = MAY;
    private static final int MANDELA_SIGNUP_YEAR = 1994;

    //Frida Khalo Info
    private static final int FRIDA_BIRTH_DAY = 6;
    private static final int FRIDA_BIRTH_MONTH = JUL;
    private static final int FRIDA_BIRTH_YEAR = 1907;

    private static final int FRIDA_DEATH_DAY = 13;
    private static final int FRIDA_DEATH_MONTH = JUL;
    private static final int FRIDA_DEATH_YEAR = 1954;

    private static final int FRIDA_SIGNUP_DAY = 1;
    private static final int FRIDA_SIGNUP_MONTH = JAN;
    private static final int FRIDA_SIGNUP_YEAR = 1940;

    private static final int FRIDA_CLOSED_DAY = 13;
    private static final int FRIDA_CLOSED_MONTH = JUL;
    private static final int FRIDA_CLOSED_YEAR = 1954;

    //Jackie Chan Info
    private static final int JACKIE_BIRTH_DAY = 7;
    private static final int JACKIE_BIRTH_MONTH = APR;
    private static final int JACKIE_BIRTH_YEAR = 1954;

    private static final int JACKIE_SIGNUP_DAY = 1;
    private static final int JACKIE_SIGNUP_MONTH = OCT;
    private static final int JACKIE_SIGNUP_YEAR = 1980;

    // Account/Password Constants
    private static final int EINSTEIN_ACCOUNT_NUMBER = 123001;
    private static final String EINSTEIN_PASSWORD = "abc123";
    private static final int EINSTEIN_PIN = 3141;

    private static final int MANDELA_ACCOUNT_NUMBER = 654321;
    private static final String MANDELA_PASSWORD = "654321";
    private static final int MANDELA_PIN = 4664;

    private static final int FRIDA_ACCOUNT_NUMBER = 123456;
    private static final String FRIDA_PASSWORD = "frd123";
    private static final int FRIDA_PIN = 1907;

    private static final int JACKIE_ACCOUNT_NUMBER = 789001;
    private static final String JACKIE_PASSWORD = "chan789";
    private static final int JACKIE_PIN = 1954;

    // Transaction amount constants
    private static final int DEPOSIT_1000 = 1000;
    private static final int DEPOSIT_2000 = 2000;
    private static final int DEPOSIT_500 = 500;
    private static final int DEPOSIT_3000 = 3000;

    private static final int WITHDRAW_100 = 100;
    private static final int WITHDRAW_200 = 200;
    private static final int WITHDRAW_50 = 50;
    private static final int WITHDRAW_500 = 500;

    /**
     * Prints details of a person including their name, client details,
     * and associated bank account details.
     *
     * @param name    the person's {@link Name}
     * @param client  the person's {@link BankClient}
     * @param account the person's {@link BankAccount}
     */
    private static void printPerson(Name name, BankClient client, BankAccount account) {
        System.out.println("Initials: " + name.getInitials());
        System.out.println("Full name: " + name.getFullName());
        System.out.println("Reversed name: " + name.getReverseName());

        System.out.println("Details: " + client.getDetails());
        System.out.println("Bank Account Details: " + account.getDetails());
        System.out.println();
    }

    /**
     * Main method that sets up example clients and bank accounts,
     * simulates deposits and withdrawals, and prints updated details.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {

        // Albert Einstein (March 14, 1879 – April 18, 1955)
        Name einsteinName = new Name("Albert", "Einstein");
        Date einsteinBirth = new Date(EINSTEIN_BIRTH_DAY, EINSTEIN_BIRTH_MONTH, EINSTEIN_BIRTH_YEAR);
        Date einsteinDeath = new Date(EINSTEIN_DEATH_DAY, EINSTEIN_DEATH_MONTH, EINSTEIN_DEATH_YEAR);
        Date einsteinSignup = new Date(EINSTEIN_SIGNUP_DAY, EINSTEIN_SIGNUP_MONTH, EINSTEIN_SIGNUP_YEAR);
        Date einsteinClosed = new Date(EINSTEIN_CLOSED_DAY, EINSTEIN_CLOSED_MONTH, EINSTEIN_CLOSED_YEAR);
        BankClient einsteinClient = new BankClient(einsteinName, einsteinBirth, einsteinDeath, EINSTEIN_ACCOUNT_NUMBER, einsteinSignup);
        BankAccount einsteinAcct = new BankAccount(einsteinClient, EINSTEIN_PASSWORD, einsteinSignup, einsteinClosed, EINSTEIN_PIN);

        System.out.println("Balance pre-deposit $" + einsteinAcct.getBalanceUsd());
        einsteinAcct.deposit(DEPOSIT_1000);
        System.out.println("Balance post-deposit $" + einsteinAcct.getBalanceUsd());
        einsteinAcct.withdraw(WITHDRAW_100, EINSTEIN_PIN);
        System.out.println("Balance post-withdraw $" + einsteinAcct.getBalanceUsd());
        printPerson(einsteinName, einsteinClient, einsteinAcct);
        System.out.println();

        // Nelson Mandela (July 18, 1918 – December 5, 2013)
        Name mandelaName = new Name("Nelson", "Mandela");
        Date mandelaBirth = new Date(MANDELA_BIRTH_DAY, MANDELA_BIRTH_MONTH, MANDELA_BIRTH_YEAR);
        Date mandelaDeath = new Date(MANDELA_DEATH_DAY, MANDELA_DEATH_MONTH, MANDELA_DEATH_YEAR);
        Date mandelaSignup = new Date(MANDELA_SIGNUP_DAY, MANDELA_SIGNUP_MONTH, MANDELA_SIGNUP_YEAR);
        BankClient mandelaClient = new BankClient(mandelaName, mandelaBirth, mandelaDeath, MANDELA_ACCOUNT_NUMBER, mandelaSignup);
        BankAccount mandelaAcct = new BankAccount(mandelaClient, MANDELA_PASSWORD, mandelaSignup, null, MANDELA_PIN);

        System.out.println("Balance pre-deposit $" + mandelaAcct.getBalanceUsd());
        mandelaAcct.deposit(DEPOSIT_2000);
        System.out.println("Balance post-deposit $" + mandelaAcct.getBalanceUsd());
        mandelaAcct.withdraw(WITHDRAW_200, MANDELA_PIN);
        System.out.println("Balance post-withdraw $" + mandelaAcct.getBalanceUsd());
        printPerson(mandelaName, mandelaClient, mandelaAcct);
        System.out.println();

        // Frida Kahlo (July 6, 1907 – July 13, 1954)
        Name fridaName = new Name("Frida", "Kahlo");
        Date fridaBirth = new Date(FRIDA_BIRTH_DAY, FRIDA_BIRTH_MONTH, FRIDA_BIRTH_YEAR);
        Date fridaDeath = new Date(FRIDA_DEATH_DAY, FRIDA_DEATH_MONTH, FRIDA_DEATH_YEAR);
        Date fridaSignup = new Date(FRIDA_SIGNUP_DAY, FRIDA_SIGNUP_MONTH, FRIDA_SIGNUP_YEAR);
        Date fridaClosed = new Date(FRIDA_CLOSED_DAY, FRIDA_CLOSED_MONTH, FRIDA_CLOSED_YEAR);
        BankClient fridaClient = new BankClient(fridaName, fridaBirth, fridaDeath, FRIDA_ACCOUNT_NUMBER, fridaSignup);
        BankAccount fridaAcct = new BankAccount(fridaClient, FRIDA_PASSWORD, fridaSignup, fridaClosed, FRIDA_PIN);

        System.out.println("Balance pre-deposit $" + fridaAcct.getBalanceUsd());
        fridaAcct.deposit(DEPOSIT_500);
        System.out.println("Balance post-deposit $" + fridaAcct.getBalanceUsd());
        fridaAcct.withdraw(WITHDRAW_50, FRIDA_PIN);
        System.out.println("Balance post-withdraw $" + fridaAcct.getBalanceUsd());
        printPerson(fridaName, fridaClient, fridaAcct);

        // Jackie Chan (April 7, 1954 – still alive)
        Name jackieName = new Name("Jackie", "Chan");
        Date jackieBirth = new Date(JACKIE_BIRTH_DAY, JACKIE_BIRTH_MONTH, JACKIE_BIRTH_YEAR);
        Date jackieSignup = new Date(JACKIE_SIGNUP_DAY, JACKIE_SIGNUP_MONTH, JACKIE_SIGNUP_YEAR);
        BankClient jackieClient = new BankClient(jackieName, jackieBirth, null, JACKIE_ACCOUNT_NUMBER, jackieSignup);
        BankAccount jackieAcct = new BankAccount(jackieClient, JACKIE_PASSWORD, jackieSignup, null, JACKIE_PIN);

        System.out.println("Balance pre-deposit $" + jackieAcct.getBalanceUsd());
        jackieAcct.deposit(DEPOSIT_3000);
        System.out.println("Balance post-deposit $" + jackieAcct.getBalanceUsd());
        jackieAcct.withdraw(WITHDRAW_500, JACKIE_PIN);
        System.out.println("Balance post-withdraw $" + jackieAcct.getBalanceUsd());
        printPerson(jackieName, jackieClient, jackieAcct);
        System.out.println();
    }
}
