package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hola")
public class HelloService {
	@GET
	public String sayHello() {
		return "Hola Zubair";
	}
}
