package cc.atm;

public class CashDispenser implements ICashDispenser {

    private int availableCashAmount = 1000;

    public void dispenseCash(int amount) {
        System.out.println("Dispensing cash...");
        availableCashAmount -= amount;
    }

    public void acceptCash(int amount) {
        System.out.println("Accepting cash...");
        availableCashAmount += amount;
    }

    public boolean hasCash() {
        return availableCashAmount > 0;
    }

    public boolean hasSufficientCash(int withdrawAmount) {
        return availableCashAmount > withdrawAmount;
    }

    public boolean isCashValid() {
        return true;
    }

    public boolean isCashTaken() {
        return true;
    }
}
