protected class Database //!< This is the mock database
{
	private boolean admin; //!< An abbitrary variable to be checked when mocking the database. 
	
	/*
	*@param No parameter
	*@brief assigns admin to false
	*@return Nothing is returned 
	*/
	public Database()
	{
		admin=false;
	}
	
	/*
	*@param a this is variable to determine the admin privileges (only to be used during mock demo).
	*@brief Assigns the a variable to admin.
	*@return Nothing. 
	*/
	public Database(boolean a)
	{
		admin=a;
	}
	
	/*
	*@param admin this is the Admin object.
	*@param userN this is the username of the user to be deleted. 
	*@todo Checks if the current admin is logged in and has the right to remove the user. 
	*@return Returns a boolean variable of whether or not the user was deleted.
	*/
	public boolean removeUser(Admin admin,String userN)
	{
		if(!admin)
			System.out.println("User was not removed");
		else
			System.out.println("User was removed");
		return admin;
	}
	
	/*
	*@param g this is the guest object to be added.
	*@todo Adds the guest user to the database.
	*@return Nothing is returned.
	*/
	public void addGuest(Guest g)
	{
		System.out.println("Guest user was added");
	}
	
	/*
	*@param userO This is the user objct to be added.
	*@todo Adds the user to the database.
	*@return Returns a boolean variable of whether or not the guest was added.
	*/
	public boolean registerUser(user userO)
	{
		System.out.println("User was registered");
		return true;
	}
	
	/*
	*@param admin is the Admin object needed to grant rights.
	*@param user is the User object to be granted rights.
	*@todo Checks if the Admin object is in the database and has the appropriate rights, then gives the user the admin rights.     
	*@return Returns a boolean variable of whether or not the user was given the admin rights.
	*/
	public boolean grantAdminRight(Admin admin,User user)
	{
		if(admin)  
			System.out.println("No admin rights. Cannot grant rights to other users");
		else
			System.out.println("Rights successfully granted");
		return admin;
	}
	
	/*
	*@param admin is the Admin object needed to strip rights.
	*@param user is the User object to be stripped of rights.
	*@todo Checks if the Admin object is in the database and has the appropriate rights, then strips the user of admin rights.     
	*@return Returns a boolean of whether or not the user was stripped of the admin rights.
	*/
	public boolean removeAdminRight(Admin admin,User user)
	{
		if(admin)
			System.out.println("No admin rights. Cannot strip rights of other users");
		else
			System.out.println("Rights successfully stripped");
		return admin;
	}
}