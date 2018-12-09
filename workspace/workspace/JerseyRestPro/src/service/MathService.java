package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/math")
public class MathService {
	
	@GET
	@Path("/sum/{n1}/{n2}")
	public String sum(@PathParam("n1") Integer n1, @PathParam("n2") Integer n2) {
		return "Result: " + (n1 + n2);
	}
}
