package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{
	private static String Url="jdbc:mysql://localhost:3306/e_commerce";
	private static String UserName="root";
	private static String Password="root";
	private static Connection con=null;
	
	
	
	
	public static  Connection connect() throws ClassNotFoundException, SQLException  
	{
		if(con==null)
		{
			System.out.println("Driver is loaded");
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 con=DriverManager.getConnection(Url,UserName,Password);
			 System.out.println("connection to Database is estableshed ");
		}
		return con;
	}
}
