package cc.atm;

public class CustomerAccount {
    private int accountNumber;
    private double balance;
    private Customer customer;

    public CustomerAccount(int accountNumber, double balance, String firstName, String lastName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = new Customer(firstName, lastName);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" + "firstName: " + customer.getFirstName() + " lastName: " + customer.getLastName() +
                ", balance=" + balance + '}';
    }
}
