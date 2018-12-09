
class BankAccount {
	private double balance = 4500.0;
	
	public void withdraw(double amount) {
		try {
			Thread.sleep(100);
			if(amount < balance) {
				Thread.sleep(100);
				balance = balance - amount;
				System.out.println("Balance left: " + balance);
			}
			else
				System.out.println("Insufficient Balance! ");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}

class Transaction implements Runnable {
	
	BankAccount bankAccount;
	double amount;
	
	Transaction(BankAccount bankAccount, double amount) {
		this.bankAccount = bankAccount;
		this.amount = amount;
	}
	@Override
	public void run() {
		bankAccount.withdraw(amount);
	}
}

public class ConcurrentAccessDemo {
	
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		Transaction tx1 = new Transaction(bankAccount, 3500.0);
		Transaction	tx2 = new Transaction(bankAccount, 3500.0);
		new Thread(tx1).start();
		new Thread(tx2).start();	
	}
	

}
