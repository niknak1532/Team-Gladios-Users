package Users;
package Admin;

/**
 *
 * @author BrianKamau
 */
public class UserInterface {


    private boolean isAdmin; //!< An abbitrary variable to be checked when mocking the database. 
    public boolean registerUser(String username,String password,String firstname,String lastname,String email, int admin);
   /*
	* @param username Username string
	* @param password Password string
	* @param firstname Firstname string
	* @param lastname Surname string
	* @param email Email string
	*
	* @todo It checks if the user exists in the databse
	*
	* @return Returns -1 if the user does not exist on the database. It returns the user's ID if the user exists on the database
	*/
    public User getUser(String username);
    public boolean removeUser(String username);
    public void activateUser(String username);
    public boolean login(String username, String password);
    public String getUsername(String username);
    public boolean getActivation(String username);
    public boolean getEmail(String username);
    public boolean checkAdminRights(User aUser);
    protected void setUser(String username);
    public String getActivationKey();
    public String getresetKey(String userName);
    public boolean checkresetKey(String rKey);
    public boolean checkActivationKey(String key);
    public String getFirstname(String username);
    public String getLastname(String username)  ;  
    public String getEmail(String username);
    
    /*
    *@param No parameter
    *@brief assigns admin to false
    *@return Nothing is returned 
    */
    public Database();
    /*
    *@param a this is variable to determine the admin privileges (only to be used during mock demo).
    *@brief Assigns the a variable to admin.
    *@return Nothing. 
    */
    public Database(boolean a);
    
    /*
    *@param admin this is the Admin object.
    *@param userN this is the username of the user to be deleted. 
    *@todo Checks if the current admin is logged in and has the right to remove the user. 
    *@return Returns a boolean variable of whether or not the user was deleted.
    */
    public boolean removeUser(Admin admin,String userN);    
    /*
    *@param g this is the guest object to be added.
    *@todo Adds the guest user to the database.
    *@return Nothing is returned.
    */
    public void addGuest(Guest g);
    
    /*
    *@param userO This is the user objct to be added.
    *@todo Adds the user to the database.
    *@return Returns a boolean variable of whether or not the guest was added.
    */
    public boolean registerUser(user userO);

    /*
    *@param admin is the Admin object needed to grant rights.
    *@param user is the User object to be granted rights.
    *@todo Checks if the Admin object is in the database and has the appropriate rights, then gives the user the admin rights.     
    *@return Returns a boolean variable of whether or not the user was given the admin rights.
    */
    public boolean grantAdminRight(Admin admin,User user);    
    /*
    *@param admin is the Admin object needed to strip rights.
    *@param user is the User object to be stripped of rights.
    *@todo Checks if the Admin object is in the database and has the appropriate rights, then strips the user of admin rights.     
    *@return Returns a boolean of whether or not the user was stripped of the admin rights.
    */
    public boolean removeAdminRight(Admin admin,User user);
}
