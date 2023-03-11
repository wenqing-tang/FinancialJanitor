import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BalanceRepository {

    private final Path balanceFile;

    public BalanceRepository() {
        this.balanceFile = Path.of("balance.txt");
        if (Files.notExists(this.balanceFile)) {
            saveBalance(0.);
        }
    }

    public Double getBalance() {
        try {
            final byte[] bytes = Files.readAllBytes(balanceFile);
            return Double.parseDouble(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveBalance(Double balance) {
        try {
            Files.write(balanceFile, Double.toString(balance).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
