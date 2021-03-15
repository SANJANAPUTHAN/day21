package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo5
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
			PreparedStatement ps=conn.prepareStatement("delete from employee where eid=?");
			Statement stmt=conn.createStatement();
			String query="select * from employee";
			ps.setInt(1, 21);
			ps.executeUpdate();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt("eid")+" "+rs.getString("ename")+" "+rs.getInt("flag"));
			}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
