package repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import entity.Flight;



public class JdbcFlightRepository implements FlightRepository {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int getTotalFlights() {
		String sql = "select count(*) from flights_test";
		int retVal = jdbcTemplate.queryForObject(sql, Integer.class);
		return retVal;
	}

	@Override
	public int getTotalFlights(String carrier) {
		Object[] params = { carrier };
		Integer retVal = jdbcTemplate.queryForObject("select count(*) from flights_test where carrier = ?", params,
				Integer.class);
		return retVal;
	}

	@Override
	public Map getFlightInfo(String flightNo) {
		Map results = jdbcTemplate.queryForMap("select * from flights_test where flightno=?", flightNo);
		return results;
	}

	@Override
	public List getFlights(String carrier) {
		List results = jdbcTemplate.queryForList("select * from flights_test where carrier = ?", carrier);
		return results;
	}

	@Override
	public void newFlight(Flight flight) {

		jdbcTemplate.update("insert into flights_test values(?,?,?,?)", flight.getFlightNo(), flight.getCarrier(),
				flight.getFrom(), flight.getTo());
	}

}
