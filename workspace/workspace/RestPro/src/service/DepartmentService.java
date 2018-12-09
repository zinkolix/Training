package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/departments")
public class DepartmentService {

  @GET
  @Produces("application/xml")
  public String showDepartments() {
    // Return all departments.
    return "<department id=\"12345\">"
      + "<link rel=\"self\" href=\"/departments/12345\" />"
      + "<name>Solutions Development</name>"
      + "</department>";
  }

  @Path("{id}")
  @GET
  @Produces("application/xml")
  public String showDepartment(@PathParam("id") int id) {
    // Return department by ID.
    return "<department id=\"" + id + "\">"
      + "<link rel=\"self\" href=\"/departments/" + id + "\" />"
      + "<name>Solutions Development</name>"
      + "</department>";
  }
}