package cc.atm;

public abstract class Transaction {

    protected final IScreen screen;
    protected final IKeypad keypad;
    protected final IBankInformationSystem bankInformationSystem;
    protected final CustomerAccount customerAccount;

    protected Transaction(IScreen screen, IKeypad keypad, IBankInformationSystem bankInformationSystem, CustomerAccount customerAccount) {
        this.screen = screen;
        this.keypad = keypad;
        this.bankInformationSystem = bankInformationSystem;
        this.customerAccount = customerAccount;
    }

    public abstract void execute();
}
