/**
 * Parent class account that holds the basic information regarding a user's bank accounts
 */
public class Account {

    protected String name;
    protected int taxID;
    protected double balance;
    protected double[] last10withdraws;
    protected double[] last10deposits;
    protected int numDeposits;
    protected int numWithdraws;

    /**
     * Constructor for the Account class, creates a new account with default information
     */
    public Account(){
        name = "";
        taxID = 0;
        balance = 0.00;
        last10withdraws = new double[10];
        last10deposits = new double[10];
        numDeposits = 0;
        numWithdraws = 0;
    }

    /**
     * Constructor for the Account class
     * @param name The name of the account holder
     * @param taxID The account holder's taxID
     * @param balance The starting balance of the account
     */
    public Account(String name, int taxID, double balance){
        this.name = name;
        this.taxID = taxID;
        this.balance = balance;
        last10withdraws = new double[10];
        last10deposits = new double[10];
        numDeposits = 0;
        numWithdraws = 0;
    }

    /**
     * Mutator method that sets the name for the account
     * @param name The account holder's name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Mutator method that sets the tax ID number for the account
     * @param taxID The tax ID number associated with the account
     */
    public void setTaxID(int taxID){
        this.taxID = taxID;
    }

    /**
     * Mutator method that sets the balance for the account
     * @param balance The balance amount
     */
    public void setBalance(double balance){
        this.balance = balance;
    }

    /**
     * Accessor method that returns the name of the account
     * @return A String that has the account holder's name
     */
    public String getName(){
        return name;
    }

    /**
     * Accessor method that returns the tax ID number of the account
     * @return An int that has the account's tax ID number
     */
    public int getTaxID(){
        return taxID;
    }

    /**
     * Accessor method that returns the current balance of the account
     * @return A double amount that indicates the current balance
     */
    public double getBalance(){
        return balance;
    }

    /**
     * A deposit method that inputs a specified amount into the user's balance
     * @param amount The amount of 'money' the user wants to add to their balance
     */
    public void makeDeposit(double amount){
        balance += amount;
        numDeposits++;
        last10deposits[numDeposits % 10] = amount;
    }

    /**
     * A display method that prints out the user's basic information including the account name, tax ID, and current balance
     */
    public void display(){
        System.out.println("Account Name: " + getName());
        System.out.println("Tax ID: " + getTaxID());
        System.out.println("Balance: $" + getBalance());
    }

}
