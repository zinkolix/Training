package bean;

public class Account {

	public void deposit(double amount) {
		System.out.println("Deposit amount " + amount);
	}

	public double getBalance() {
		System.out.println("Return balance " + 1000);
		return 1000;
	}

	public void withdraw(double amount) throws BalanceException {
		System.out.println("Withdraw amount " + amount);
		throw new BalanceException("Insufficient Funds! ");
	}

	public void summary() {
		System.out.println("Account Summary");
	}

	public void fundTransfer(int from, int to) {
		System.out.println("Transferring funds from " + from + " to " + to);
	}

}
