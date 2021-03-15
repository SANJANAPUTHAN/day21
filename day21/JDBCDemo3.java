package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class JDBCDemo3 {
public static void main(String[] args) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from employee");
		ResultSetMetaData rdmd=rs.getMetaData();
		System.out.println(rdmd.getColumnCount());
		for(int i=1;i<=rdmd.getColumnCount();i++)
		{
			System.out.println(rdmd.getColumnName(i));
			System.out.println(rdmd.getColumnType(i));
			System.out.println(rdmd.getColumnLabel(i));
		}
		
	}
	catch (Exception e) {

	}
}
}
