import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Flight;
import repository.FlightRepository;

public class FlighRepositoryTest {
	
	@Test
	public void testFlights() {
		ApplicationContext context = new ClassPathXmlApplicationContext("appctx.xml");
		FlightRepository flightRepository = (FlightRepository)context.getBean("flightRepository");
		
		System.out.println(flightRepository.getTotalFlights());
		System.out.println(flightRepository.getTotalFlights("KINGFISHER"));
		
		Map map = flightRepository.getFlightInfo("KL-102");
		for (Object key : map.keySet()) {
			System.out.println(key + " - " + map.get(key));
		}
		
		for (Object elem : flightRepository.getFlights("KINGFISHER")) {
			System.out.println(elem);
		}
		
		Flight f1 = new Flight();
		f1.setFlightNo("6E-420");
		f1.setCarrier("Indigo");
		f1.setFrom("Mumbai");
		f1.setTo("Mangalore");
		flightRepository.newFlight(f1);
	}

}
