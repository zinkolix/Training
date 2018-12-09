
public class AccountTest {

	private double balance;

	public AccountTest(double balance) {
		this.balance = balance;
	}
	
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) throws BalanceException {
		balance -= amount;
		return balance;
	}

	public double getBalance() {
		return balance;
	}
	
	
	
}
