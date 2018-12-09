import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) {
//		String driver = "oracle.jdbc.OracleDriver";
//		String uri = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;

		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(uri,"ashwini","mphasis");
			conn = JdbcUtil.getConnection();
			System.out.println("Connected successfully :-) ");
			
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("DB Name: " + meta.getDatabaseProductName());
			System.out.println("DB Ver: " + meta.getDatabaseProductVersion() );
			System.out.println("Driver Name: " + meta.getDriverName());
			System.out.println("Driver Ver: " + meta.getDriverVersion());
			
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
