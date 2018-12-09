package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hola")
public class HelloService {
	
	@GET
	public String sayHello() {
		return "Hola Zubair";
	}
	
	@GET
	@Path("{name}")
	public String sayHello(@PathParam("name") String name) {
		return "Hola " + name;
	}
}
