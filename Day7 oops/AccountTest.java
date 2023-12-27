class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0.0) {
            this.balance = initialBalance;
        } else {
            throw new IllegalArgumentException("Initial balance must be non-negative.");
        }
    }

    public void credit(double amount) {
        if (amount >= 0.0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Credit amount must be non-negative.");
        }
    }

    public void debit(double amount) {
        if (amount >= 0.0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Debit successful. Remaining balance: $" + balance);
            } else {
                System.out.println("Debit amount exceeded account balance. Balance unchanged.");
            }
        } else {
            throw new IllegalArgumentException("Debit amount must be non-negative.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.0);

        System.out.println("Initial balance: $" + account.getBalance());

        account.credit(500.0);
        System.out.println("After crediting $500.0, balance: $" + account.getBalance());

        account.debit(200.0);
        System.out.println("After debiting $200.0, balance: $" + account.getBalance());

        account.debit(1500.0); // This debit amount exceeds the balance
        System.out.println("After debiting $1500.0, balance: $" + account.getBalance());
    }
}
