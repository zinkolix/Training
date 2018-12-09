import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	public static void main(String[] args) {
		String sql1 = "insert into person values ('Mili', 19, 'Mumbai')";
		String sql2 = "update person set age=22 where name='Polo'";
		String sql3 = "delete from person where name='Lilli'";
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			// Setting auto-commit off - its on by default
			conn.setAutoCommit(false);
			//Executing batch of queries
			stmt.executeBatch();
			//if everything goes well
			conn.commit(); //commit changes
		} catch (SQLException e) {
			//something went wrong - exception occurred
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
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
