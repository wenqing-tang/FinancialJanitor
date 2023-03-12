import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionRequestHandler {

    private final TransactionService transactionService;

    public TransactionRequestHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void handleRequest(String[] shellArgs) {
        try {
            final String command = shellArgs[0];
            final List<Double> transactions = Arrays.stream(shellArgs, 1, shellArgs.length)
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            handle(command, transactions);
        } catch (ArrayIndexOutOfBoundsException | JanitorMisusingException e) {
            System.out.println("""
                    Usage: ./run.sh command
                    commands:
                    - log [ transaction-1, [ transaction-2, [ ... ] ] ]
                    - show""");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void handle(String command, List<Double> transactions) {
        switch (command) {
            case "log" -> transactionService.logTransactions(transactions);
            case "show" -> transactionService.showBalance();
            default -> throw new JanitorMisusingException();
        }
    }
}
