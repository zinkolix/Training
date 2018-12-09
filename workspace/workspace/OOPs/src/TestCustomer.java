import com.mphasis.bank.FrequentCustomer;
import com.mphasis.bank.SeasonalCustomer;
import com.mphasis.org.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		Customer c1 = new Customer("Anshu",10000);
		c1.display();
		Customer c2 = new Customer("Shama", 12000);
		c2.display();
		System.out.println("----Frequent-----");
		FrequentCustomer fc = new FrequentCustomer("Pratik");
		fc.display();
		System.out.println("----Seasonal-----");
		SeasonalCustomer sc = new SeasonalCustomer("abc");
		sc.display();
	}

}
