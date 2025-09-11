package ca.bcit.comp2522.bank;

public class Main {
    private static void printPerson(Name name, BankClient client, BankAccount account) {
        System.out.println("Initials: " + name.getInitials());
        System.out.println("Full name: " + name.getFullName());
        System.out.println("Reversed name: " + name.getReverseName());

        System.out.println("Details: " + client.getDetails());
        System.out.println("Bank Account Details: " + account.getDetails());
        System.out.println();
    }

    public static void main(String[] args) {

        // Albert Einstein (March 14, 1879 – April 18, 1955)
        Name einsteinName = new Name("Albert", "Einstein");
        Date einsteinBirth = new Date(14, 3, 1879);
        Date einsteinDeath = new Date(18, 4, 1955);
        Date einsteinSignup = new Date(1, 1, 1900);
        Date einsteinClosed = new Date(14, 10, 1950);
        BankClient einsteinClient = new BankClient(einsteinName, einsteinBirth, einsteinDeath, 123001, einsteinSignup);
        BankAccount einsteinAcct = new BankAccount(einsteinClient, "abc123", einsteinSignup, einsteinClosed, 3141);

        System.out.println("Balance pre-deposit $" + einsteinAcct.getBalanceUsd());


        einsteinAcct.deposit(1000);
        System.out.println("Balance post-deposit $" + einsteinAcct.getBalanceUsd());

        einsteinAcct.withdraw(100, 3141);
        System.out.println("Balance post-withdraw $" + einsteinAcct.getBalanceUsd());

        printPerson(einsteinName, einsteinClient, einsteinAcct);
        System.out.println("Einstein account updated (post-withdrawal).");
        System.out.println();

        // Nelson Mandela (July 18, 1918 – December 5, 2013)
        Name mandelaName = new Name("Nelson", "Mandela");
        Date mandelaBirth = new Date(18, 7, 1918);
        Date mandelaDeath = new Date(5, 12, 2013);
        Date mandelaSignup = new Date(10, 5, 1994);
        BankClient mandelaClient = new BankClient(mandelaName, mandelaBirth, mandelaDeath, 654321, mandelaSignup);
        BankAccount mandelaAcct = new BankAccount(mandelaClient, "654321", mandelaSignup, null, 4664);

        System.out.println("Balance pre-deposit $" + mandelaAcct.getBalanceUsd());


        mandelaAcct.deposit(2000);
        System.out.println("Balance post-deposit $" + mandelaAcct.getBalanceUsd());
        mandelaAcct.withdraw(200, 4664);
        System.out.println("Balance post-withdraw $" + mandelaAcct.getBalanceUsd());

        printPerson(mandelaName, mandelaClient, mandelaAcct);
        System.out.println("Mandela account updated (post-withdrawal).");
        System.out.println();

        // Frida Kahlo (July 6, 1907 – July 13, 1954)
        Name fridaName = new Name("Frida", "Kahlo");
        Date fridaBirth = new Date(6, 7, 1907);
        Date fridaDeath = new Date(13, 7, 1954);
        Date fridaSignup = new Date(1, 1, 1940);
        Date fridaClosed = new Date(13, 7, 1954);
        BankClient fridaClient = new BankClient(fridaName, fridaBirth, fridaDeath, 123456, fridaSignup);
        BankAccount fridaAcct = new BankAccount(fridaClient, "frd123", fridaSignup, fridaClosed, 1907);

        System.out.println("Balance pre-deposit $" + fridaAcct.getBalanceUsd());
        fridaAcct.deposit(500);
        System.out.println("Balance post-deposit $" + fridaAcct.getBalanceUsd());

        fridaAcct.withdraw(50, 1907);
        System.out.println("Balance post-withdraw $" + fridaAcct.getBalanceUsd());

        printPerson(fridaName, fridaClient, fridaAcct);
        System.out.println("Frida account updated (post-withdrawal).");

        // Jackie Chan (April 7, 1954 – still alive)
        Name jackieName = new Name("Jackie", "Chan");
        Date jackieBirth = new Date(7, 4, 1954);
        Date jackieSignup = new Date(1, 10, 1980);
        BankClient jackieClient = new BankClient(jackieName, jackieBirth, null, 789001, jackieSignup);
        BankAccount jackieAcct = new BankAccount(jackieClient, "chan789", jackieSignup, null, 1954);
        // had $3000 then withdraw $500
        System.out.println("Balance pre-deposit $" + jackieAcct.getBalanceUsd());
        jackieAcct.deposit(3000);

        System.out.println("Balance post-deposit $" + jackieAcct.getBalanceUsd());
        jackieAcct.withdraw(500, 1954);

        System.out.println("Balance post-withdraw $" + jackieAcct.getBalanceUsd());

        printPerson(jackieName, jackieClient, jackieAcct);
        System.out.println("Jackie account updated (post-withdrawal).");
        System.out.println();
    }
}
