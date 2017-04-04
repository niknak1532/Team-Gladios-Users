
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gladiator
 */
public interface UserInterface {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
	/*
        
	* @param o Dabase object
	* @todo Assigns the passed object to the local databse object. Then creates the Statement object, which will be used to execute the SQL queries
	*
	*
	*/

	public boolean registerUser(String username,String password,String firstname,String lastname,String email, int admin);
	
        
	/**
	* @param username Username string
	* @param password Password string
     * @throws java.sql.SQLException
	*
	* @todo It checks if the user exists in the databse
	*
	* @return Returns -1 if the user does not exist on the database. It returns the user's ID if the user exists on the database
	*/
	public int login(String username,String password) throws SQLException;
	
	/**
	* @param username Username string
     * @throws java.sql.SQLException
	* 
	* @todo Removes the user from the database
	*
	* @return Returns a boolean stating whether or not the user was successfully removed from the database.
	*/
	public boolean removeUser(String username) throws SQLException;
        
	/**
	* @param username Username string
     * @throws java.sql.SQLException
	* 
	* @todo Retrieves the email of the user from the database
	*
	* @return Returns a the string with the email of the user, if found.If not found, it return null
	*/
	public String getEmail(String username) throws SQLException;
        
        /**
	* @param username Username string
     * @throws java.sql.SQLException
	* 
	* @todo Retrieves the email and activated key of the user from the database
	*
	* @return Returns a the string with the email and activated key of the user, if found.If not found, it return null
	*/
        public String getActivation(String username) throws SQLException;
        
        /**
	* @param null
	* 
	* @todo generates and returns an activated key the is 7 characters long
	*
	* @return Returns a string that is an activated key
	*/
        //public static String setActivatedKey();
        
        /**
	* @param username Username string
        * @param key ActivatedKey string
     * @throws java.sql.SQLException
	* 
	* @todo compares the given activated key with the specified user's activated key in the db
	*
	* @return Returns a boolean variable stating whether the activation key for the specified user was correct
	*/
        public boolean testActivatedKey(String username,String key) throws SQLException;
    }

