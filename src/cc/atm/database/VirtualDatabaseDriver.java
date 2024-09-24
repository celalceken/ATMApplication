package cc.atm.database;

import cc.atm.CustomerAccount;
import cc.atm.IDatabaseRepository;
import cc.atm.Utilities;

public class VirtualDatabaseDriver implements IDatabaseRepository {
    @Override
    public CustomerAccount verifyUser(int accountNumber, int password) {
        CustomerAccount customerAccount = null;
        System.out.println("Bank information system is verifying the user...");
        Utilities.waiting(2000);
        System.out.println("Connected to the database (virtual DBMS) and querying the user...");
        Utilities.waiting(2000);

        if (accountNumber == 2 && password == 2)
            customerAccount = new CustomerAccount(accountNumber, 1000, "Zeynep", "Gökdoğan");

        return customerAccount;
    }

    @Override
    public void updateAccount(CustomerAccount customerAccount) {
        System.out.println("Bank information system updated the account...");
    }
}
