import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        final BalanceRepository balanceRepository = new BalanceRepository();
        final TransactionService transactionService = new TransactionService(balanceRepository);

        Arrays.stream(args)
                .map(Double::parseDouble)
                .forEach(transactionService::logTransaction);
    }
}
