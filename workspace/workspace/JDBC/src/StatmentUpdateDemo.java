import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StatmentUpdateDemo {

	public static void main(String[] args) {
		Connection conn = null;
		
//		String upt = "update person set city = 'Mumbai' where name = 'Polo'";
		String del = "delete from person where name = ? ";
		try {
			conn = JdbcUtil.getConnection();
//			Statement stmt = conn.createStatement();
//			stmt.executeUpdate(upt);
//			System.out.println("Record Updated");
			PreparedStatement stmt = conn.prepareStatement(del);
			stmt.setString(1, args[0]);
			stmt.executeUpdate();
			System.out.println("Record Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
