package cc.atm;

public interface IBankInformationSystem {
    public CustomerAccount verifyUser(int accountNumber, int pin);

    public void updateAccount(CustomerAccount customerAccount);
}
