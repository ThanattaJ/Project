import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
   private long accId;
    private double balance;
    private Date dateCreated;
    private Customer cust;
    private final static String ACCTYPE = "";
    private static long sequenceId = 1000000001;

    public BankAccount() {
        accId = genAccId();
    }

    public BankAccount(Customer cu, double initialBalance) {
        accId = genAccId();
        balance = initialBalance;
        dateCreated = new Date();
        cust = cu;
    }

    public long genAccId() {
        return sequenceId++;
    }

    public long getAccId() {
        return accId;
    }
   
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDateCreated() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(dateCreated);
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public static String getACCTYPE() {
        return ACCTYPE;
    }
   
    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            double newBalance = balance - amount;
            balance = newBalance;
        } else {
            System.out.println("You cannot withdraw, your withdraw amount greater than balance!!!!");
        }
    }

    public void transfer(BankAccount target, double amount) {
        withdraw(amount);
        target.deposit(amount);
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "\nBank Account Id : " + accId + "\n\n"
                + cust + "\n\n"
                + "Balance : " + balance + "\n\n"
                + "Date Created: " + sdf.format(dateCreated);
    }
    
}
