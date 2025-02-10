
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance);
    }
}

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}


class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; 

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    
    public double calculateInterest() {
        return balance * interestRate;
    }
}


class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; 
    private double loanLimit = 5000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

   
    public double calculateInterest() {
        return balance * interestRate;
    }

   
    public void applyForLoan(double amount) {
        if (amount <= loanLimit) {
            System.out.println("Loan Approved: " + amount);
        } else {
            System.out.println("Loan Denied. Exceeds limit.");
        }
    }

    public double calculateLoanEligibility() {
        return balance * 2; 
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SAV123", "Alice", 5000),
            new CurrentAccount("CUR456", "Bob", 3000)
        };

        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("Interest Earned: " + account.calculateInterest());
            
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(4000);
                System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
            }
            System.out.println("--------------------");
        }
    }
}
