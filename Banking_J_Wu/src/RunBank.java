/*
* Name: Jenny Wu
* Date: 03.07.2024
* Class: CSC 1120.01
* Pledge: I have neither given nor received unauthorized aid on this
*         program.
* Description: A generic bank account system with a checking, savings
*              and a credit card account with multiple functions like
*              depositing, withdrawing, writing a check, payments,
*              making a charge, and displaying the balances on each account.
* Input: The user types numbers 1-10 each associating with a specific
*        action regarding the respective accounts and will be given the
*        option to input how much money is being manipulated.
* Output: The program will display the menu interface with all the
*         different options used to manipulate the 3 different accounts
*         and the rolling balances of each.
*/

import java.util.InputMismatchException;
import java.util.Scanner;
public class RunBank {

    /**
     * prints out the basic menu
     */
    public static void menu(){
        System.out.println("************************************************************************************************");
        System.out.println("\t\t\t\t\t\t\t  Wu Banking LLC Financial Services ");
        System.out.println("************************************************************************************************");
        System.out.println("\tOptions: ");
        System.out.println("\t\t 1. Savings Deposit \t\t\t 2. Savings Withdrawal \t\t\t 3. Checking Deposit");
        System.out.println("\t\t 4. Write a Check \t\t\t\t 5. Credit Card Payment \t\t 6. Make a Charge");
        System.out.println("\t\t 7. Display Savings \t\t\t 8. Display Checking \t\t\t 9. Display Credit Card");
        System.out.println("\t\t 10. Exit");
        System.out.println("\tSelect Option (#1-10): ");
    }

    public static void main(String[] args) throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        InputMismatchException problem = new InputMismatchException("Invalid Response, please enter your tax ID numbers.");
        System.out.println("Welcome to Wu Banking LLC Financial Services!");
        System.out.println("To create your new account, we just need a few basic information.");
        System.out.println("Please enter the name of the account holder: ");
        String acName = scan.next();

        int tID = 0;
        try {
            System.out.println("Please enter your tax ID: ");
            tID = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid response, please re-enter your tax ID number.");
        }

        System.out.println("Thank you! You will start off with $100 each in your Checking and Savings accounts \n" +
                "and your credit card will have a starting balance of $100 as well. :)");

        Account a = new Account(acName, tID, 100.00);
        Checking c = new Checking(acName, tID, 100.00);
        Savings s = new Savings(acName, tID, 100.00);
        CreditCard cc = new CreditCard(acName, tID, 100.00);

        boolean exit = false;
        while (!exit) {
            System.out.println("================================================================================================");
            System.out.println("\t Checking Balance: $" + c.getBalance() + "\t | \t Savings Balance: $" + s.getBalance()
                    + "\t | \t Credit Card Balance: $" + cc.getBalance());
            System.out.println("================================================================================================");
            menu();
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Option Selected: Savings Deposit");
                    System.out.println("How much would you like to deposit into Savings? (balance: $" + s.getBalance()
                            + "): $");
                    double sdAmount = scan.nextDouble();
                    System.out.println("Making deposit of $" + sdAmount);
                    s.makeDeposit(sdAmount);
                    break;
                case 2:
                    System.out.println("Option Selected: Savings Withdrawal");
                    System.out.println("How much would you like to withdraw from Savings? (balance: $" + s.getBalance()
                            + "): $");
                    double swAmount = scan.nextDouble();
                    System.out.println("Making withdrawal of $" + swAmount);
                    s.doWithdraw(swAmount);
                    break;
                case 3:
                    System.out.println("Option Selected: Checking Deposit");
                    System.out.println("How much would you like to deposit into Checking? (balance: $" + c.getBalance()
                            + "): $");
                    double cdAmount = scan.nextDouble();
                    System.out.println("Making deposit of $" + cdAmount);
                    c.makeDeposit(cdAmount);
                    break;
                case 4:
                    System.out.println("Option Selected: Write a Check");
                    System.out.println("What's this check number?");
                    int cNum = scan.nextInt();
                    System.out.println("How much would you like to write a check for? (Checking balance: $" + c.getBalance()
                            + "): $");
                    double chAmount = scan.nextDouble();
                    System.out.println("Making withdrawal of $" + chAmount);
                    c.writeCheck(cNum, chAmount);
                    break;
                case 5:
                    System.out.println("Option Selected: Credit Card Payment");
                    System.out.println("How much would you like to pay? (Credit Card balance: $" + cc.getBalance()
                            + "): $");
                    double ccpAmount = scan.nextDouble();
                    cc.makePayment(ccpAmount);
                    break;
                case 6:
                    System.out.println("Option Selected: Make a Charge");
                    System.out.println("Where is this charge from? i.e Target, Amazon, etc");
                    String chargeName = scan.next();
                    System.out.println("How much was the charge? (Credit Card balance: $" + cc.getBalance()
                            + ") \t Account balance: $" + a.getBalance());
                    double ccChargeAmount = scan.nextDouble();
                    cc.debitCharge(chargeName, ccChargeAmount);
                    break;
                case 7:
                    System.out.println("Option Selected: Display Savings");
                    s.display();
                    break;
                case 8:
                    System.out.println("Option Selected: Display Checking");
                    c.display();
                    break;
                case 9:
                    System.out.println("Option Selected: Display Credit Card");
                    cc.display();
                    break;
                case 10:
                    System.out.println("Thank you for choosing Wu Banking Financial Services! I hope you had a good time with us :)");
                    exit = true;
                    break;
                default:
                    System.out.println("Error! Please enter a number between 1 and 10.");
            }
        }
    }
}
