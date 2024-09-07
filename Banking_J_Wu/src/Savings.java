/**
 * Child class of the Account class; imitates a savings account
 */
public class Savings extends Account{

    /**
     * Default constructor for the savings class, inherits the Account class' constructor
     */
    public Savings(){
        super();
    }

    /**
     * Constructor for the savings class
     * @param name The name of the account holder
     * @param taxID The tax ID number of the account
     * @param balance The starting balance in the savings account
     */
    public Savings(String name, int taxID, double balance){
        super(name, taxID, balance);
    }

    /**
     * A withdrawal method that takes a specified amount out of the savings account
     * @param amount The amount to withdraw
     */
    public void doWithdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            numWithdraws++;
            last10withdraws[numWithdraws % 10] = amount;
        } else {
            System.out.println("Insufficient balance to withdraw for $" + amount);
        }
    }

    /**
     * Display method that prints out the user's basic info (name, tax ID, current balance) and the withdrawal record and deposit record
     */
    public void display(){
        super.display();
        System.out.println("Withdrawal record:");
        for(int i = 0; i < last10withdraws.length; i++){
            if(last10withdraws[i] != 0){
                System.out.println("$" + last10withdraws[i]);
            }
        }
        System.out.println("Deposit record:");
        for(int i = 0; i < last10deposits.length; i++){
            if(last10deposits[i] != 0){
                System.out.println("$" + last10deposits[i]);
            }
        }
    }

}
