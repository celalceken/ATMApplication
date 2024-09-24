package cc.atm;

public class CashDeposit extends Transaction {

    private final ICashDispenser cashDispenser;

    public CashDeposit(IBankInformationSystem bankInformationSystem, IScreen screen, IKeypad keypad, CustomerAccount customerAccount, ICashDispenser cashDispenser) {
        super(screen, keypad, bankInformationSystem, customerAccount);
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        screen.displayMessage("You selected cash deposit");
        screen.displayMessage("Your balance: " + customerAccount.getBalance());
        screen.displayMessage("Please enter the amount to deposit");
        int depositAmount = keypad.getInput();
        screen.displayMessage("Please place the cash in the slot");
        if (cashDispenser.isCashValid()) {
            customerAccount.setBalance(customerAccount.getBalance() + depositAmount);
            screen.displayMessage("Your new balance: " + customerAccount.getBalance());
            bankInformationSystem.updateAccount(customerAccount);
        } else {
            screen.displayMessage("Invalid cash");
        }
    }
}
