package service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/cart")
public class CartService {
	private ArrayList<String> items;
	
	public CartService() {
		items = new ArrayList<String>();
		items.add("iPhone");
		items.add("iPad");
	}
	
	@POST
	public String addItem(@QueryParam("item")String item) {
		items.add(item);
		System.out.println(item + " added to cart -------------------------");
		return item;
	}
	
	@GET
//	@Path("/{index}")
	public String getItem(@QueryParam("index") int index) {
		return items.get(index);
	}
	
	@Path("/plain")
	@GET
	@Produces("text/plain")
	public String showItems(){
		
		return items.toString();
	}
	
	@Path("/html")
	@GET
	@Produces("text/html")
	public String showItemHtml(){
		
		String body = items.toString();
		String result= "<html> " + "<title>" + "List" + "</title>"
		        + "<body><h1>" + body + "</h1></body>" + "</html> ";
		return result;
	}
	
	@Path("/exemel")
	@GET
	@Produces("text/html")
	public String showItemExemel(){
		
		String body = items.toString();
		String result= "<?xml version=\"1.0\"?>" + "<hello> "+ body + "</hello>";
		return result;
	}
	
	@Path("/json")
	@GET
	  @Produces("text/json")
	  public Response convertFtoC() throws JSONException {

		JSONObject jsonObject = new JSONObject();
//		String body = items.toString();
		
		jsonObject.put("1", items.get(0)); 
		jsonObject.put("2", items.get(1));
		String result= "@Produces(\"text/json\") Output: \n\nList: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
}
