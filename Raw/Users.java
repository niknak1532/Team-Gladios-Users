/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import static users.Test2.encode;

public class Users
{
	private Connection db; //!< This is the database object 
	private Statement stmt; //!< This is the statement object used to execute the queries
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final long BASE = 36;
	/*
        
	* @param o Dabase object
	* @todo Assigns the passed object to the local databse object. Then creates the Statement object, which will be used to execute the SQL queries
	*
	*
	*/
	public Users(Connection o) throws SQLException
	{
		db=o;
		stmt=db.createStatement();
	}
        
	/**
	* @param username Username string
	* @param password Password string
	* @param firstname Firstname string
	* @param lastname Lastname string
	* @param email Email string
	*
	* @todo It first checks if the database has the user, if not it adds the user.
	*
	* @return Returns a boolean to state if the user was successfully registered 
	*/
	public boolean registerUser(String username,String password,String firstname,String lastname,String email, int admin) throws SQLException
	{
		String sql="SELECT * FROM "+"User" + "WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
                String activatedKey;
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			return false;
                activatedKey=setActivatedKey();
		sql="INSERT INTO ";
		sql += "User (Username,Password,Firstname,Lastname,Email,Activated,ActivatedKey)" ;
		sql +="VALUES ('";
		sql += username+"', '"+password+"', '"+firstname+"', '"+lastname+"', '"+email+"', false, '"+activatedKey+"'";
		sql+=");";
		stmt.executeUpdate(sql);
                
		return true;
	}
        
	/**
	* @param username Username string
	* @param password Password string
	*
	* @todo It checks if the user exists in the databse
	*
	* @return Returns -1 if the user does not exist on the database. It returns the user's ID if the user exists on the database
	*/
	public int login(String username,String password) throws SQLException
	{
		String sql="SELECT * FROM "+"User" + "WHERE Username=\'"+username+"\' AND Password=\'"+password+"\' ;";
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			return result.getInt("id");
		else
			return -1;
	}
	
	/**
	* @param username Username string
	* 
	* @todo Removes the user from the database
	*
	* @return Returns a boolean stating whether or not the user was successfully removed from the database.
	*/
	public boolean removeUser(String username) throws SQLException
	{
		String sql="DELETE FROM "+"User" + "WHERE Username=\'"+username+"';";
		stmt.executeUpdate(sql);
		db.commit();
		sql="SELECT * FROM "+"User" + "WHERE Username=\'"+username+"';";
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			return false;
		else
			return true;
	}
        
	/**
	* @param username Username string
	* 
	* @todo Retrieves the email of the user from the database
	*
	* @return Returns a the string with the email of the user, if found.If not found, it return null
	*/
	public String getEmail(String username) throws SQLException
	{
		String sql="SELECT * FROM "+"User" + "WHERE Username=\'"+username+"';";
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			return result.getString("email");
		else
			return null;
	}
        
        /**
	* @param username Username string
	* 
	* @todo Retrieves the email and activated key of the user from the database
	*
	* @return Returns a the string with the email and activated key of the user, if found.If not found, it return null
	*/
        public String getActivation(String username) throws SQLException{
        String activatedKey;
        String sql="SELECT * FROM "+"User" + "WHERE Username=\'"+username+"\' ;";
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			activatedKey=result.getString("activatedKey");
		else
			activatedKey="";
        return getEmail(username)+" "+activatedKey;
        }
        
        /**
	* @param null
	* 
	* @todo generates and returns an activated key the is 7 characters long
	*
	* @return Returns a string that is an activated key
	*/
        public static String setActivatedKey() {
		Date date = new Date();
                StringBuilder key = new StringBuilder();
                long num=date.getTime();
		for(int i=0;i<7;i++){
			key.append(ALPHABET.charAt((int) (num % BASE)));
			num /= BASE;
		}
		return key.reverse().toString();
	}
        
        /**
	* @param username Username string
        * @param key ActivatedKey string
	* 
	* @todo compares the given activated key with the specified user's activated key in the db
	*
	* @return Returns a boolean variable stating whether the activation key for the specified user was correct
	*/
        public boolean testActivatedKey(String username,String key) throws SQLException{
            String sql="SELECT * FROM "+"User" + "WHERE Username=\'"+username+"\' AND ActivatedKey=\'"+key+"\' ;";
            ResultSet result=stmt.executeQuery(sql);
            if(result.next())
                return true;
            else
                return false;
        }
    }
