/**
 * A child class of the Account class; imitates a credit card account
 */
public class CreditCard extends Account{

    private int cardNumber;
    private String[] last10charges;

    /**
     * Default constructor for the credit card class, inherits the Account class' constructor
     */
    public CreditCard(){
        super();
        cardNumber = 0000000;
        last10charges = new String[10];
    }

    /**
     * Constructor for the credit card class
     * @param name The name of the account holder
     * @param taxID The tax ID number of the account
     * @param balance The starting balance on the credit card
     */
    public CreditCard(String name, int taxID, double balance){
        super(name, taxID, balance);
        cardNumber = 0000000;
        last10charges = new String[10];
    }

    /**
     * A debit charge method that imitates a charge placed on the credit card
     * @param name The name of where the charge is from i.e. Target, Amazon, etc
     * @param amount The amount the charge was for
     */
    public void debitCharge(String name, double amount){
        balance += amount;
        numWithdraws++;
        last10withdraws[numWithdraws % 10] = amount;
        last10charges[numWithdraws % 10] = name;
        System.out.println("Charge of $" + amount + " at " + name);
    }

    /**
     * A payment method that pays off the existing balance on the credit card
     * @param amount The amount to pay off
     */
    public void makePayment(double amount){
        balance -= amount;
        numDeposits++;
        last10deposits[numDeposits % 10] = amount;
        System.out.println("Payment of $" + amount + " has been made.");
    }

    /**
     * A display method that displays the user account's basic info (name, tax ID, current balance), as well as the account charges and deposit record
     */
    public void display(){
        super.display();
        System.out.println("Account charges: ");
        for(int i = 0; i < last10charges.length; i++){
            for(int j = 0; j < last10withdraws.length; j++){
                if(last10charges[i] != null && last10withdraws[j] != 0){
                    System.out.println("$" + last10withdraws[j] + " at "
                        + last10charges[i]);
                }
            }
        }
        System.out.println("Deposit record: ");
        for(int i = 0; i < last10deposits.length; i++){
            if(last10deposits[i] != 0){
                System.out.println("$" + last10deposits[i]);
            }
        }
    }

}
