package cc.atm;

public class BankInformationSystem implements IBankInformationSystem {

    private IDatabaseRepository database;

    public BankInformationSystem(IDatabaseRepository database) {
        this.database = database;
    }

    public CustomerAccount verifyUser(int accountNumber, int pin) {
        return database.verifyUser(accountNumber, pin);
    }

    public void updateAccount(CustomerAccount customerAccount) {
        database.updateAccount(customerAccount);
    }
}
