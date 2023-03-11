public class TransactionService {

    private final BalanceRepository balanceRepository;

    public TransactionService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public void logTransaction(Double transaction) {
        final double currentBalance = balanceRepository.getBalance();

        System.out.println("\n>>>");
        System.out.println(" The account number is: 123456789. The balance is " + currentBalance + " Euro.");
        System.out.println(" Log " + transaction + " Euro.");
        final double nextBalance = currentBalance + transaction;
        System.out.println(" The latest account balance is " + nextBalance + " Euro.");

        balanceRepository.saveBalance(nextBalance);
    }
}
