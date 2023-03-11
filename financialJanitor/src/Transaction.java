import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Transaction {
    public static void main(String[] args) throws IOException {
        System.out.println("This is a default account information:");// Print prompt
        final Path balanceFile = Path.of("balance.txt");
        double currentBalance;
        try {
            final byte[] bytes;
            bytes = Files.readAllBytes(balanceFile);
            currentBalance = Double.parseDouble(new String(bytes));
        } catch (NoSuchFileException e) {
            Files.write(balanceFile, Double.toString(0).getBytes());
            currentBalance = 0;
        }
        System.out.println("The account number is: 123456789." + "The balance is " + currentBalance + " Euro."); // Print ID
        System.out.println("The following information is about transaction: "); // Print account balance
        for (String i : args) {
            System.out.println("");
            System.out.println("The amount of transaction is " + i + " Euro. ");
            double transactionAmount = Double.parseDouble(i);
            currentBalance += transactionAmount;
            System.out.println("The latest account balance is " + currentBalance + " Euro.");
        }
        Files.write(balanceFile, Double.toString(currentBalance).getBytes());
    }
}
