package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCDemo9 {
public static void main(String[] args) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
		Statement stmt=conn.createStatement();
		conn.setAutoCommit(false);
		Savepoint sp=null;
		try
		{
			stmt.executeUpdate("update employee set flag=0 where eid=11");
			sp=conn.setSavepoint("first");
			stmt.executeUpdate("update employee set flag=1 where eeid=2");
			conn.commit();
			
		}
		catch (Exception e) {
			conn.rollback(sp);
			conn.commit();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
