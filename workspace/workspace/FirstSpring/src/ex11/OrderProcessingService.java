package ex11;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class OrderProcessingService implements MessageSourceAware {

	private MessageSource messageSource;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void placeOrder(int quantity) {
		int availabeQuantity = 2;
		if (quantity > availabeQuantity) {
			String errorMessage = messageSource.getMessage("insufficient.stock",
					new Object[] { availabeQuantity, quantity }, new Locale("en"));
			throw new RuntimeException(errorMessage);
		}
	}

}
