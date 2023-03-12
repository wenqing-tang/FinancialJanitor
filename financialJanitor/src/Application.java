import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        final BalanceRepository balanceRepository = new BalanceRepository();
        final TransactionService transactionService = new TransactionService(balanceRepository);
        if (args[0].equals("log")) {
            Arrays.stream(args, 1, args.length)
                    .map(Double::parseDouble)
                    .forEach(transactionService::logTransaction);
        } else if (args[0].equals("show")) {
            System.out.println("The balance is " + balanceRepository.getBalance());

        } else {
            System.out.println("""
                    Usage: ./run.sh command
                    commands:
                    - log
                    - show""");
        }
    }
}
