package ex9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
	// Similar to bean entry in xml
	// Java annotation example
	@Bean(name = "currency")
	public ExchangeService exchange() {
		return new ExchangeService();
	}
}
