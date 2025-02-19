import java.util.*;

public class BankingSystem {
    Map<Integer, Double> accounts = new HashMap<>();
    TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accNumber, double balance) {
        accounts.put(accNumber, balance);
        sortedAccounts.put(balance, accNumber);
    }

    public void withdraw(int accNumber, double amount) {
        if (accounts.containsKey(accNumber) && accounts.get(accNumber) >= amount) {
            accounts.put(accNumber, accounts.get(accNumber) - amount);
            withdrawalQueue.add(accNumber);
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accNumber = withdrawalQueue.poll();
            System.out.println("Processed withdrawal for account: " + accNumber);
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 10000);

        bank.withdraw(1001, 2000);
        bank.processWithdrawals();
    }
}

