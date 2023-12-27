import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stock {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }

    @Override
    public String toString() {
        return "Stock Name: " + stockName +
               ", Number of Shares: " + numberOfShares +
               ", Share Price: $" + sharePrice;
    }
}

class StockPortfolio {
    private List<Stock> stocks;

    public StockPortfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("\nStock Report:");
        for (Stock stock : stocks) {
            System.out.println(stock);
            System.out.println("Stock Value: $" + stock.calculateStockValue() + "\n");
        }
        System.out.println("Total Portfolio Value: $" + calculateTotalValue());
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio stockPortfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();

        for (int i = 1; i <= numberOfStocks; i++) {
            System.out.println("\nEnter details for Stock " + i + ":");
            System.out.print("Enter Stock Name: ");
            String stockName = scanner.next();

            System.out.print("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();

            System.out.print("Enter Share Price: $");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
        }

        stockPortfolio.printStockReport();
        scanner.close();
    }
}

