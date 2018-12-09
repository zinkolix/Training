package application;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/community")
public class UserService {
	UserDao userDao = new UserDao();
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

//	@GET
//	@Path("/users/{userid}")
//	@Produces(MediaType.APPLICATION_XML)
//	public Response getUser(@PathParam("userid") int userid) {
//		User user = userDao.getUser(userid);
//		System.out.println("User hash code: " + user.hashCode());
//		
//		CacheControl cc = new CacheControl();
//		cc.setMaxAge(10);
//		cc.setPrivate(true);
//		
//		ResponseBuilder builder = Response.ok(user);
//		builder.cacheControl(cc);
//		return builder.build();
//	}

	@GET
	@Path("/users/{userid}")
	public Response getUser(@PathParam("userid") int userid, @Context Request request) {
		User user = userDao.getUser(userid);
		System.out.println("User Hash code: " + user.hashCode());
		
		CacheControl cc = new CacheControl();
	    cc.setMaxAge(86400);

	    EntityTag etag = new EntityTag(Integer.toString(user.hashCode()));
	    ResponseBuilder builder = request.evaluatePreconditions(etag);

	    // cached resource did change -> serve updated content
	    if(builder == null){
	        builder = Response.ok(user);
	        builder.tag(etag);
	    }

	    builder.cacheControl(cc);
	    return builder.build();
	}
	
	@POST
	@Path("/users/add")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser( @QueryParam("name") String name,
			@QueryParam("profession") String profession)
					throws IOException {
		User user = new User();
		user.setName(name);
		user.setProfession(profession);
		boolean flag = userDao.addUser(user);
		if (flag) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}	

	@PUT
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@QueryParam("id") int id, @QueryParam("name") String name,
			@QueryParam("profession") String profession)
					throws IOException {
		User user = userDao.getUser(id);
		user.setName(name);
		user.setProfession(profession);
		boolean flag = userDao.updateUser(user);
		if (flag) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}	

	@DELETE
	@Path("/users/delet/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("userid") int userid) {
		boolean flag = userDao.deleteUser(userid);
		if (flag) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}	
}


