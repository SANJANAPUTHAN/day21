package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCDemo1 {
public static void main(String[] args) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21"); 
		 //System.out.println(con);
		 Statement stmt=conn.createStatement();
		 //int i1=stmt.executeUpdate("insert into employee values (21,'sanjana',1)");
		 int i2=stmt.executeUpdate("insert into employee values (31,'shilpha',2)");
		 int i3=stmt.executeUpdate("insert into employee values (05,'anu',3)");
		 ResultSet rs=stmt.executeQuery("select * from employee");
		 while(rs.next())
		 {
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		 }
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
