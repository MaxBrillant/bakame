package CloudOperations;

import java.sql.*; 

public class mysql{
	public static Connection con;
	
public static void main(String args[]){  

	try{
	
		Class.forName("com.mysql.jdbc.Driver");  

	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/bakame_database","root","maxbr-37");  
//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();
	
	ResultSet rs=stmt.executeQuery("select * from users");
	while(rs.next())  
	System.out.println(rs.getString("username")+"  "+rs.getString("password"));
	con.close();
	}
	catch(Exception e){ System.out.println(e);
	} 
} 

public static void connectToDB() {
	try{
		
		Class.forName("com.mysql.jdbc.Driver");  

	con=DriverManager.getConnection( 
			"jdbc:mysql://localhost:3306/bakame_database","root","maxbr-37");  
//here sonoo is database name, root is username and password  
	}
	catch(Exception e){ System.out.println(e);
	} 
	
}
}  
