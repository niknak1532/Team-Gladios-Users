class Guest{
	
	private String username;
	private String email;
	/**
	*Guest constructor
	*it is used to create new Guests object that will last until the guest leave the app or log off
	* @param name 
	* 		 	is the user name of the Guest or the name that will be displayed at the app 
	*@param email
	*			is the email of the guest
	 *
	*/
	Guest(String name, String em){
		
		
		username=name;
		email=em;
	}
	public String getName(){
		return username;
	}
	public String getEmail(){
		return email;
	}
}