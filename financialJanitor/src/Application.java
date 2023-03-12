import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        final BalanceRepository balanceRepository = new BalanceRepository();
        final TransactionService transactionService = new TransactionService(balanceRepository);
        switch (args[0]) {
            case "log" -> {
                final List<Double> transactions = Arrays.stream(args, 1, args.length)
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
                transactionService.logTransactions(transactions);
            }
            case "show" -> transactionService.showBalance();
            default -> System.out.println("""
                    Usage: ./run.sh command
                    commands:
                    - log
                    - show""");
        }
    }
}
