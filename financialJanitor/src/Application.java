public class Application {

    public static void main(String[] args) {
        final BalanceRepository balanceRepository = new BalanceRepository();
        final TransactionService transactionService = new TransactionService(balanceRepository);
        final TransactionRequestHandler transactionRequestHandler = new TransactionRequestHandler(transactionService);

        transactionRequestHandler.handleRequest(args);
    }
}
