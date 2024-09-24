/**
 * The ATM class is the module where operations are initiated.
 *
 * @author  Celal Çeken
 */
package cc.atm;

import cc.atm.database.VirtualDatabaseDriver;

public class ATM {
    private final IScreen screen;
    private final IKeypad keypad;
    private final ICashDispenser cashDispenser;
    private final ICardSlot cardSlot;

    private static final int VIEW_BALANCE = 1;
    private static final int WITHDRAW_CASH = 2;
    private static final int DEPOSIT_CASH = 3;
    private static final int EXIT = 4;

    public ATM() {
        screen = new Screen();
        keypad = new Keypad();
        cashDispenser = new CashDispenser();
        cardSlot = new CardSlot();
    }

    public void start() {
        screen.displayMessage("Please insert your card into the slot 123...");
        Utilities.waiting();
        int accountNumber = this.verifyCard();
        if (accountNumber != 0) {
            screen.displayMessage("Enter your PIN (2)");
            int pin = keypad.getInput();
            IBankInformationSystem bankInformationSystem = new BankInformationSystem(new VirtualDatabaseDriver());
            // IBankInformationSystem bankInformationSystem = new BankInformationSystem(new PostgreSQLDriver());

            CustomerAccount customerAccount = this.verifyUser(accountNumber, pin, bankInformationSystem);
            // CustomerAccount customerAccount = this.verifyUser(accountNumber, bankInformationSystem);
            if (customerAccount != null) {
                screen.displayMessage("User verification successful...: " + customerAccount);
                chooseTransaction(bankInformationSystem, customerAccount);
            } else {
                screen.displayMessage("Your account could not be verified");
                cardSlot.ejectCard();
            }
        } else {
            screen.displayMessage("Your card could not be verified");
            cardSlot.ejectCard();
        }
    }

    private int verifyCard() {
        return cardSlot.insertCard();
    }

    private CustomerAccount verifyUser(int accountNumber, int pin, IBankInformationSystem bankInformationSystem) {
        // private CustomerAccount verifyUser(int accountNumber, IBankInformationSystem bankInformationSystem) {

        return bankInformationSystem.verifyUser(accountNumber, pin);
        // In case of failure to verify, re-enter the PIN, and if incorrect 3 times, the card should be retained.
        /*int pin;
        int counter = 0;
        CustomerAccount customerAccount = null;
        do {
            screen.displayMessage("Enter your PIN");
            pin = keypad.getInput();
            customerAccount = bankInformationSystem.verifyUser(accountNumber, pin);
        } while (customerAccount == null && ++counter < 3);

        return customerAccount;*/
    }

    private void chooseTransaction(IBankInformationSystem bankInformationSystem, CustomerAccount customerAccount) {
        int selection;
        do {
            selection = showMainMenu();
            screen.clearScreen();
            switch (selection) {
                case VIEW_BALANCE:
                    Transaction viewBalance = new ViewBalance(screen, keypad, customerAccount);
                    viewBalance.execute();
                    break;
                case WITHDRAW_CASH:
                    Transaction withdrawCash = new CashWithdrawal(bankInformationSystem, screen, keypad, customerAccount, cashDispenser);
                    withdrawCash.execute();
                    break;

                case DEPOSIT_CASH:
                    Transaction depositCash = new CashDeposit(bankInformationSystem, screen, keypad, customerAccount, cashDispenser);
                    depositCash.execute();
                    break;

                case EXIT:
                    screen.displayMessage("Exiting");
                    cardSlot.ejectCard();
                    break;
                default:
                    screen.displayMessage("You must enter a number between 1 and 4");
            }
        } while (selection != 4);
    }

    private int showMainMenu() {
        screen.displayMessage("**********************************************");
        screen.displayMessage("Main Menu");
        screen.displayMessage("1-View Balance");
        screen.displayMessage("2-Withdraw Cash");
        screen.displayMessage("3-Deposit Cash");
        screen.displayMessage("4-Exit");
        screen.displayMessage("Your Selection:");
        screen.displayMessage("**********************************************");
        return keypad.getInput();
    }
}
