import java.sql.*;

public class Admin
{
	
	//ArrayList<user> adminList;
	//Statement database;
	//private boolean grant_admin_right;
	
	public void addUser(Statement stmt,String userID, String username,String password,String firstname,String lastname,String email,
			   String activate,String activateKey,String resetKey,String resetDate)
	{
		// add the user with given parameters
	}
	public void removeUser(String userID)
	{
		// remove the entire cell with the userID
	}
	public void grantAdminRight(String userID)
	{
		// use userID to update the cell with the admin confirmation
	}
	public static void main(String[] args) 
	{
   		Connection conn = null;
   		Statement stmt = null;
   		try
		{
			Class.forName("com.mysql.jdbc.Driver");

      			//STEP 3: Open a connection
      			System.out.println("Connecting to database...");
      			conn = DriverManager.getConnection(DB_URL, USER, PASS);

      			//STEP 4: Execute a query
      			System.out.println("Creating database...");
      			stmt = conn.createStatement();
      
      			String sql = "CREATE DATABASE STUDENTS";
      			stmt.executeUpdate(sql);
      			System.out.println("Database created successfully...");
   		}
		catch(SQLException se)
		{
      			//Handle errors for JDBC
      			se.printStackTrace();
   		}
		catch(Exception e)
		{
      			//Handle errors for Class.forName
      			e.printStackTrace();
   		}
		finally
		{
      			//finally block used to close resources
      			try
			{
         			if(stmt!=null)
            				stmt.close();
      			}
			catch(SQLException se2)
			{
      			}// nothing we can do
      			try
			{
         			if(conn!=null)
            				conn.close();
      			}
			catch(SQLException se)
			{
         			se.printStackTrace();
      			}//end finally try
   		}//end try
   		System.out.println("Goodbye!");
	}
}
