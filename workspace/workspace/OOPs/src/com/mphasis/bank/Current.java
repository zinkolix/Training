package com.mphasis.bank;

public class Current extends Account {
	private double overDraft;
	
	public Current() {
		
	}

	public Current(String holder) {
		super(holder, INIT_CUR_BAL);
		this.overDraft = OD_LIMIT;
		
	}

	@Override
	public void deposit(double amount) {
		if(overDraft < OD_LIMIT) {
			double temp = OD_LIMIT - overDraft;			
			overDraft += amount - temp; 
			amount -= temp;
			balance  += amount; 
		}else
			balance += amount;
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount > (balance + overDraft))
			throw new BalanceException("Insufficient Funds");
		else 
		if(balance < amount && amount <= OD_LIMIT) {
			overDraft -= amount;
		}
		else 
			balance -= amount;
				
	}
	

}
