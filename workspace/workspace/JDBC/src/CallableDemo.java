import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			CallableStatement stmt = conn.prepareCall("{call pkg_assign.return_data(?,?,?)}");
			stmt.setInt(1, 10); 	//	Setting IN param vale
			stmt.registerOutParameter(2, Types.DOUBLE);	// 	expected OUT type param 2
			stmt.registerOutParameter(3, Types.DOUBLE);		// 	expected OUT type param 3
			stmt.execute();		// invoking procedure in database
			
			System.out.println(stmt.getDouble(2) + " = " + stmt.getDouble(3));
			stmt = conn.prepareCall("{? = call pkg_assign.emp_fn(?)}");
			stmt.setInt(2, 7369);
			stmt.registerOutParameter(1, Types.DOUBLE);
			stmt.execute();
			
			System.out.println("Tax: " + stmt.getDouble(1));
			
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
