package cc.atm;

public interface ICashDispenser {
    public void dispenseCash(int amount);

    public void acceptCash(int amount);

    public boolean hasCash();

    public boolean hasSufficientCash(int withdrawAmount);

    public boolean isCashValid();

    public boolean isCashTaken();

    // public boolean isPartialCashTaken();
}
