/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersimplementation;

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
    public Connection con = null;
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
        Statement stmt = null;
        String db="UserDB",user="test",pass="test";
        try {
             Class.forName("org.postgresql.Driver");
     //	c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UserDb","postgres", "joseph");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+db,user, pass);


            stmt = con.createStatement();
            String sql = "CREATE TABLE User " +
                          "(ID INT PRIMARY KEY     NOT NULL," +
                          "Username        	CHAR(50)    NOT NULL, " +
                          "Password			CHAR(50)	NOT NULL, "+
                          "Firstname		CHAR(50)	NOT NULL, "+
                          "Lastname			CHAR(50)	NOT NULL, "+
                          "Email			CHAR(50)	NOT NULL, "+
                          "Activated		BOOLEAN," +
                          "ActivatedKey		CHAR(50)	, "+
                          "ResetKey			CHAR(50)	, "+
                          "ResetDate		DATE 		) ";

            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        } catch ( Exception e ) {
             System.err.println( e.getClass().getName()+": "+ e.getMessage() );
             System.exit(0);
        }
    }

    /**
    *			the if statement check id the instance have already instantiated or not;
    *			if not it instantiate the instance then return it. this is to make sure that only one instance of database is created
    *
    *
    **/
	
    public static Database getInstance(){
           if(instance==null)
                    instance= new Database();
       return instance;
    }

}
