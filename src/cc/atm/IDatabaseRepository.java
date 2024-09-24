package cc.atm;

public interface IDatabaseRepository {
    public CustomerAccount verifyUser(int accountNumber, int pin);

    public void updateAccount(CustomerAccount customerAccount);
}
