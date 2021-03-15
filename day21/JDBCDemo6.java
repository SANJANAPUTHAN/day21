package day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCDemo6 {
	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
			System.out.println("Enter increment value...");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String sc=br.readLine();
			int p=Integer.parseInt(sc);
			CallableStatement stmt=conn.prepareCall("{call setempid(?)}");
			stmt.setInt(1, p);
			stmt.execute();
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt("eid")+" "+rs.getString("ename")+" "+rs.getInt("flag"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
