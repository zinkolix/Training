
public class Subscription {
	
	private int price; // subscription total price in euro - cent
	private int length; // length of subscription in months

	
	//constructor :
	public Subscription(int price, int length) {
		this.price = price;
		this.length = length;
	}
	
	/**
	 * Calculate the monthly subscription price in euro, rounded up to  the nearest cent.
	 */
	
	public double pricePerMonth() {
		double r = (double) price / (double) length;
		return r;
	}
	
	/**
	 * Call this to cancel/nullify this subscription
	 */
	
	public void cancel(){
		length = 0;
	}
}
