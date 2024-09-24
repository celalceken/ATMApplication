package cc.atm;

public class CardSlot implements ICardSlot {

    private int accountNumber;

    public int insertCard() {
        System.out.println("Inserting card...");
        Utilities.waiting(2000);
        this.accountNumber = 2; // The account number to be returned should be set here
        return verifyCard();
    }

    public int verifyCard() {
        System.out.println("Verifying card...");
        Utilities.waiting();
        return accountNumber;
    }

    public void ejectCard() {
        System.out.println("Ejecting card...");
        Utilities.waiting();
    }

    public boolean isCardInserted() {
        System.out.println("Card inserted...");
        Utilities.waiting();
        return true;
    }

    public void swallowCard() {
        System.out.println("Card swallowed...");
        Utilities.waiting();
    }
}
