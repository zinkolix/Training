import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreCompiledDemo {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		// ? is placeholder, index starts with 1
		String sql = "insert into person values(?,?,?)";
		
		try {
			conn = JdbcUtil.getConnection();
			
			//Query is pre-compiled at this point
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			//place holders can be replaced with actual values
			stmt.setString(1, args[0]);
			stmt.setInt(2, Integer.parseInt(args[1]));
			stmt.setString(3, args[2]);
			
			stmt.executeUpdate(); 	// no need of query @ time of execution
			
		} catch (NumberFormatException e) {			
			e.printStackTrace();
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
