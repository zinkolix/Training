

public class Transaction {
	private String type;
	private double amount;
	private double balance;
	
	public Transaction() {
	
	}

	public Transaction(String type, double amount, double balance) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}
	
	public void print() {
		System.out.printf("%-5s \t %10.2f0 \t %10.2f0 \n", type, amount, balance);
	}
	
	

}
