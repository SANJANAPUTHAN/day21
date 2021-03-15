package day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo2 {
public static void main(String[] args) {
	try
	{
		PreparedStatement updateSales;
		PreparedStatement updateTotal;
		String updatesales="update coffees "+"set sales=? where coffee_name like ?";
		String updatetotal="update coffees "+"set total=total+? where coffee_name like ?";
		String query="select * from coffees";
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/ey","root","sanj21");
		updateSales=conn.prepareStatement(updatesales);
		System.out.println(updateSales);
		updateTotal=conn.prepareStatement(updatetotal);
		int[] sales= {21,43,90,89,70};
		String coffee_name[]= {"black","espresso","capucchino","decaf","blackdecaf"};
		for(int i=0;i<sales.length;i++)
		{
			updateSales.setInt(1, sales[i]);
			updateSales.setString(2, coffee_name[i]);			
			updateSales.executeUpdate();
			updateTotal.setInt(1, sales[i]);
			updateTotal.setString(2,coffee_name[i]);
			updateTotal.executeUpdate();
			
			
		}
		updateSales.close();
		updateTotal.close();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getString("coffee_name")+" "+rs.getInt("sales")+" "+rs.getInt("total"));
		}
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
