import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Database {

	/**
	*		Database is implemented using the singleton class to ensure that only one table
	*		in the  database;
	*		The instance will be used to create a table of users in the database
	*		
	*
	*/
	private static Database instance =null;
	private Connection c = null;
    private Statement stmt = null;

	/**
	* @param db 
	*			it is the database that have been created.
	* @param user
	*				 it is the username of the user in the pgAdmin
	* @param pass
	*				 it is the password of the user in the pgAmin
	*
	*
	* @todo 
	*			The constructor connect to the database that is the pgAmin( already existing).
	*			if the connection is successfull the constructor then create the table of Users with the name User
	*			The it close the database when it is done.
	*
	*/
	private Database(){

		
       try {
         	 Class.forName("org.postgresql.Driver");
         	c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "123");
         	//c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db,user, pass);

         	
	        stmt = c.createStatement();
	        String sql = "CREATE TABLE IF NOT EXISTS Users " +
	                      "(ID SERIAL ," +
	                      "Username        	CHAR(50)    NOT NULL, " +
	                      "Password			CHAR(50)	NOT NULL, "+
	                      "Fullname		CHAR(50)	NOT NULL, "+
	                      "Email			CHAR(50)	NOT NULL, "+
                              "Admin		BOOLEAN," +
	                      "Activated		BOOLEAN," +
	                      "ActivatedKey		CHAR(50)	, "+
	                      "ResetKey			CHAR(50)	, "+
	                      "Phonenumber		char(10)	, "+
	                      "ResetDate		CHAR(10),  PRIMARY KEY (ID)		) ";
	                      
	        stmt.executeUpdate(sql);
	        stmt.close();
	       // c.close();
	    } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	    }
	      
	   

	}

	/**
	*			the if statement check id the instance have already instatiated or not;
	*			if not it instatiate the instance then return it. this is to make sure that only one instance of database is created
	*
	*
	**/
	
		 public static Database getInstance(){
		 	if(instance==null)
		 		 instance= new Database();
		    return instance;

		   
		}
		public Connection getConnection(){
			return c;
		}

}
