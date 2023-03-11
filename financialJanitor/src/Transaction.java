import java.util.Arrays;
import java.util.Scanner;

public class Transaction {
    public static void main(String[] args) {
        System.out.println("This is a default account information:");// Print prompt
        double currentBalance = 234;
        System.out.println("The account number is: 123456789." + "The balance is "+ currentBalance + " Euro."); // Print ID
        System.out.println("The following information is about transaction: "); // Print account balance
        for (String i : args){
            System.out.println("");
            System.out.println("The amount of transaction is "+ i + " Euro. ");
            double transactionAmount = Double.parseDouble(i);
            currentBalance += transactionAmount;
            System.out.println("The latest account balance is " + currentBalance + " Euro.");

        }
    }
}