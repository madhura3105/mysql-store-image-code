package jdbc1;
import java.io.*;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
public class StoreImage1 {
	public static void main(String [] args)
	{
		String url="jdbc:mysql://localhost:3306/school1";
		String user="root";
		String password="Root";
		
		String filePath="D:/Software/one.jpg";
		try{
			Connection conn=DriverManager.getConnection(url, user, password);
			
			String sql="INSERT INTO student(name,image)values(?,?)";
			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1,"ONE");
			
			InputStream inputStream=new FileInputStream(new File(filePath));
			statement.setBlob(2,inputStream);
			
			int row=statement.executeUpdate();
			if(row > 0)
			{
				System.out.println("A contact was inserted with photo image");
			}
			conn.close();
			
		}
		catch(SQLException ex)
		{
			
			ex.printStackTrace();
			
		}
		catch(IOException ex)
		{
			
			ex.printStackTrace();
		}
		
	}
}
