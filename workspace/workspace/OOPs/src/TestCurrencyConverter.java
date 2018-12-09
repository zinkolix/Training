import com.mphasis.currency.Currency;
import com.mphasis.currency.CurrencyConverter;
import com.mphasis.currency.Dollar;
import com.mphasis.currency.Rupee;

public class TestCurrencyConverter {
	public static void main(String[] args) {
		
		CurrencyConverter cc = new CurrencyConverter();
		Currency inr = new Rupee();
		Currency usd = new Dollar();
		
		double result = cc.convert(usd, inr, 100);
		System.out.println("Result:  " + result);
		
	}

}
