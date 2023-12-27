import java.util.ArrayList;
import java.util.List;

class CompanyShares {
    private String symbol;
    private int numberOfShares;

    public CompanyShares(String symbol, int numberOfShares) {
        this.symbol = symbol;
        this.numberOfShares = numberOfShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}

public class StockAccount {
    private List<CompanyShares> companySharesList;

    public StockAccount() {
        this.companySharesList = new ArrayList<>();
    }

    public double valueOf() {
        double totalValue = 0.0;
        for (CompanyShares shares : companySharesList) {
            // Placeholder stock price (replace with actual logic to get real-time prices)
            double stockPrice = 50.0;
            totalValue += stockPrice * shares.getNumberOfShares();
        }
        return totalValue;
    }

    public void buy(int amount, String symbol) {
        CompanyShares newTransaction = new CompanyShares(symbol, amount);
        companySharesList.add(newTransaction);
    }

    public void sell(int amount, String symbol) {
        // Placeholder logic to simulate selling shares
        for (CompanyShares shares : companySharesList) {
            if (shares.getSymbol().equals(symbol)) {
                if (shares.getNumberOfShares() >= amount) {
                    shares.setNumberOfShares(shares.getNumberOfShares() - amount);
                } else {
                    System.out.println("Not enough shares of " + symbol + " to sell.");
                }
                break;
            }
        }
    }

    public void printReport() {
        System.out.println("Stock Report:");
        for (CompanyShares shares : companySharesList) {
            System.out.println("Symbol: " + shares.getSymbol() +
                    ", Shares: " + shares.getNumberOfShares());
        }
        System.out.println("Total Portfolio Value: $" + valueOf());
    }

    public static void main(String[] args) {
        StockAccount stockAccount = new StockAccount();

        stockAccount.buy(10, "AAPL");
        stockAccount.sell(5, "AAPL");
        stockAccount.printReport();
    }
}
