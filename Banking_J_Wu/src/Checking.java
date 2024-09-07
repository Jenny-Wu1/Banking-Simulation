/**
 * A child class of the Account class; imitates a checking account
 */
public class Checking extends Account{

    private int[] last10checks;

    /**
     * Constructor for the checking class that inherits the constructor of the Account class
     */
    public Checking(){
        super();
        last10checks = new int[10];
    }

    /**
     * Constructor for the checking class that inherits the constructor of the Account class
     * @param name The name of the account holder
     * @param taxID The tax ID number of the user
     * @param balance The starting balance of the checking account
     */
    public Checking(String name, int taxID, double balance){
        super(name,taxID,balance);
        last10checks = new int[10];
    }

    /**
     * A method that writes a check and takes the specified amount of the balance
     * @param checkNum The check number
     * @param amount The amount the check is written for
     */
    public void writeCheck(int checkNum, double amount){
        if(balance >= amount){
            balance -= amount;
            numWithdraws++;
            last10checks[numWithdraws % 10] = checkNum;
            last10withdraws[numWithdraws % 10] = amount;
        } else {
            System.out.println("Insufficient funds to write Check #" +
                                checkNum + " for $" + amount);
        }
    }

    /**
     * A display method that displays the user's basic information(name, tax ID, balance) and it displays the check register and deposit record
     */
    public void display(){
        super.display();
        System.out.println("Check register:");
        for(int i = 0; i < last10checks.length; i++){   //Loops through the array to print out each check alongside it's amount
            if(last10checks[i] != 0){
                System.out.println("#" + last10checks[i] + " $" + last10withdraws[i]);
            }
        }
        System.out.println("Deposit record:");
        for(int i = 0; i < last10deposits.length; i++){ //Loops through the array to print out the last 10 deposits
            if(last10deposits[i] != 0){
                System.out.println("$" + last10deposits[i]);
            }
        }
    }

}
