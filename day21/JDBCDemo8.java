package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo8
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
			Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from employee");
			rs.afterLast();
			while(rs.previous())
			{
				System.out.println(rs.getInt("eid")+ " "+ rs.getString("ename")+ " "+rs.getInt("flag"));
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
