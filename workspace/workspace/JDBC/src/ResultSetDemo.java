import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) {
		String sql = "select * from person";
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println(meta.getColumnLabel(1) + "\t" + meta.getColumnLabel(2) + "\t" + meta.getColumnLabel(3));
			while(rs.next())
				System.out.println(rs.getString(1) + "\t" + rs.getInt("age") + "\t" + rs.getString(3));
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
