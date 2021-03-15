package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo7 {
public static void main(String[] args) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
		Statement st=conn.createStatement();
		st.execute("create table manager (mid int, mname varchar(20), mflag int)");
		conn.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
