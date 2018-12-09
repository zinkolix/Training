
public class Account {

	private double balance;

	public Account(double balance) {
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
