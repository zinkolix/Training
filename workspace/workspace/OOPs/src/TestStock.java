import com.mphasis.stock.Stock;
import com.mphasis.stock.StockSingleton;

public class TestStock {

	public static void main(String[] args) {
		
//		Stock s1 = new Stock();
//		s1.viewQuote();
//		s1.getQuote();
//		s1.setQuote();
		Stock s1 = StockSingleton.getStock();
		s1.viewQuote();
		s1.getQuote();
	}

}
