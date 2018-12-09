

public final class AccountFactory {

	 private AccountFactory() {
		
	 }
	 
	 public static Bank createAccount(String holder, String type){
		 Bank acnt = null;
		 
		 if(type.equalsIgnoreCase("Savings"))
			 acnt = new Savings(holder);
		 else
			 acnt = new Current(holder);
		 
		 return acnt;
	 }
}