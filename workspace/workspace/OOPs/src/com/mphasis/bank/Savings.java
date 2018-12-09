package com.mphasis.bank;

public class Savings extends Account {

	public Savings() {
		
	}

	public Savings(String holder) {
		super(holder, MIN_SAV_BAL);
		
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance - MIN_SAV_BAL)) {
			balance -= amount;
//			if(idx <= txns.length)
//				txns[idx ++] = new Transaction("DB",amount, balance);
			txnsVec.add(new Transaction("DB",amount, balance));
		}
			
		else 
			throw new BalanceException("Insufficient Fund");
	}	

}
