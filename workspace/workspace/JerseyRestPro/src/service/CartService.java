package service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/cart")
public class CartService {
	private ArrayList<String> items;
	
	public CartService() {
		items = new ArrayList<String>();
		items.add("iPhone");
		items.add("iPad");
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addItem(@FormParam("item")String item) {
		items.add(item);
		System.out.println(item + " added to cart -------------------------");
		return item;
	}
	
	@GET
	public String getItem(@QueryParam("index") int index) {
		return items.get(index);
	}
	
	@GET
	@Path("/all")
	@Produces("application/xml")
	public String getItems() {
		String output = "<items>";
		for (String item : items) {
			output += "<item>" + item + "</item>";
		}
		output += "</items>";
		return output;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateItem(@FormParam("index") int index, @FormParam("item") String item) {
		items.set(index, item);
		System.out.println(item + " item updated in cart---------------");
		return item;
	}
	
	@DELETE
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String removeItem(@FormParam("index") int index) {
		String item = items.remove(index);
		System.out.println(item + " item removed from cart---------------");
		return item;
	}
}






