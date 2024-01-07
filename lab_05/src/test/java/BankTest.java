import org.example.Bank;
import org.example.BankAccount;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = bank.createAccount("A Who", 1000);
        BankAccount account2 = bank.createAccount("Some One", 2000);

        account1.deposit(500);
        account2.withdraw(1000);

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 1 details:\n" + "Account Name - "+ account1.getAccountName() + "\n" + account1.getAccountSummary());
        System.out.println("_____________");
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Account 2 details:\n" + "Account Name - " + account2.getAccountName() + "\n" + account2.getAccountSummary());
        System.out.println("_____________");

        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 500);
        System.out.println("Account 1 balance after transfer: " + account1.getBalance());
        System.out.println("Account 2 balance after transfer: " + account2.getBalance());
    }
}