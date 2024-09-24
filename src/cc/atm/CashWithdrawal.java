package cc.atm;

public class CashWithdrawal extends Transaction {

    private final ICashDispenser cashDispenser;

    public CashWithdrawal(IBankInformationSystem bankInformationSystem, IScreen screen, IKeypad keypad, CustomerAccount customerAccount, ICashDispenser cashDispenser) {
        super(screen, keypad, bankInformationSystem, customerAccount);
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        screen.displayMessage("You selected cash withdrawal");
        screen.displayMessage("Your balance: " + customerAccount.getBalance());

        if (cashDispenser.hasCash()) {
            screen.displayMessage("Please enter the amount to withdraw");
            int withdrawAmount = keypad.getInput();
            if (cashDispenser.hasSufficientCash(withdrawAmount)) {
                cashDispenser.dispenseCash(withdrawAmount);
                if (cashDispenser.isCashTaken()) {
                    customerAccount.setBalance(customerAccount.getBalance() - withdrawAmount);
                    screen.displayMessage("Your new balance: " + customerAccount.getBalance());
                    bankInformationSystem.updateAccount(customerAccount);
                } else {
                    screen.displayMessage("Cash not taken");
                    cashDispenser.acceptCash(withdrawAmount);
                }
            } else {
                screen.displayMessage("Insufficient cash in the ATM...");
            }
        } else {
            screen.displayMessage("No cash available in the ATM...");
            Utilities.waiting(2000);
        }
    }
}
