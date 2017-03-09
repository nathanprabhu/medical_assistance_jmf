import java.io.*;
import java.sql.*;
import java.sql.*;
public class Database
{
   Connection con,con1;
	Statement st;
	ResultSet rs;

	
	public Connection getConnection(){
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine","root","admin");
		return con;
	}catch(Exception ex){
		ex.printStackTrace();
		System.out.println(ex);
	}
	return null;
}
	
	
}