package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/employees")
public class EmployeeService {

	@GET
	@Produces("application/xml")
	public String showEmployees() {
		// Return all employees.
		return "<employee id=\"1580\">" + "<link rel=\"self\" href=\"/employees/1580\" />"
				+ "<firstName>Zubair</firstName>" 
				+ "<lastName>Shaikh</lastName>" 
					+ "<department id=\"12345\">"
						+ "<link rel=\"self\" href=\"/departments/12345\" />" 
					+ "</department>" 
				+ "</employee>";
	}

	@Path("{id}")
	@GET
	@Produces("application/xml")
	public String showEmployee(@PathParam("id") int id) {
		// Return employee by ID.
		return "<employee id=\"" + id + "\">" + "<link rel=\"self\" href=\"/employees/" + id + "\" />"
				+ "<firstName>Zubair</firstName>" 
				+ "<lastName>Shaikh</lastName>" 
					+ "<department id=\"12345\">"
						+ "<link rel=\"self\" href=\"/departments/12345\" />" 
					+ "</department>" 
				+ "</employee>";
	}
}

