import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetConcurrentDemo {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select name, age, city from person");
			
			rs.absolute(3); // moves the cursor to the first row of rs
		    rs.updateString("NAME", "alladin"); // updates the
		          // NAME column of row 5 to be AINSWORTH
		    rs.updateRow(); // updates the row in the data source
//			rs.moveToInsertRow(); // moves cursor to the insert row
//			rs.updateString(1,"Polo"); // updates the
//			      // first column of the insert row to be AINSWORTH
//			rs.updateInt(2,35); // updates the second column to be 35
//			rs.updateString(3, "Manali");
//			rs.insertRow();
//			rs.moveToCurrentRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
