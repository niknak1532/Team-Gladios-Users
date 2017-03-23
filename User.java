class User{
	
	private long id;
	private String username;
	private String password;
	private String firstname;
	private String email;
	private String lastname;
	private boolean activated;
	private String activatedKey;
	private String resetKey;
	private Datetime resetDate;

	public User(String username, String password,String firstname,String email,String lastname, boolean activated,String activatedKey String resetKey, Datetime resetDate){
		this.id=idGenerator();
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.email=email;
		this.lastname=lastname;
		this.activated=true;
		this.activatedKey=activatedKey;
		this.resetKey=resetKey;
		this.resetDate=resetDate;
	}
	
	private long idGenerator(){
		/* creating the unique id for the user*/
		Random ran = new Random()
		return ran(4294967295)+1;
	}
	public long getID(){
		return id;
	}

	 public String getUsername(){
		
	 	return username;
	 }
	/**
	*reset the username of the user
	* @param username 
	* 		 	is the new username that will over write the existing one
	*@param pass
	*			is the password of the user will be user to validate if it is the correct user who want to change the username
	 *
	 *throw an exception  if the password is incorrect
	*/
	 public boolean setUsername(String username,String pass){

		
	 	if(this.password.equals(pass)){
			 System.out.println("username was reset");
	 		this.username=username;
			return true;
		}
		else{
			
			 System.out.println("password is incorrect");
			return false;
		}
	 }

	 public String getPassword(){
		 
	 	return password;
	 }
	/**
	 *update the password
	* @param password 
	* 		 	is the new password that will over write the current password 
	*@param currP
	*			is the current password of the user will be user to validate if it is the correct user who does the changes
	 *
	 *throw an exception  if the password is incorrect
	*/
	 public boolean setPassword(String password,String currP){
		
		  
	 	if(this.password.equals(currP)){
			System.out.println("Password was reset");
	 		this.password=password;
			return true;
		}else{
			 System.out.println("current password is incorrect");
			return false;
		}
	 }

	 public String firstname(){
	 	return firstname;
	 }
	/**
	 *reset the fisrtname of the user
	* @param fisrtname 
	* 		 	is the new firstname that will overwrite the current firstname 
	*@param pass
	*			is the current password of the user will be user to validate if it is the correct user who does the changes
	 *
	 *throw an exception  if the password is incorrect
	*/
	 public boolean setFirstname(String firstname,String pass){
		
	 	if(this.password.equals(pass)){
	 		this.firstname=firstname;
			 System.out.println("first was reset");
			return true;
		}
		else{
			 System.out.println("password is incorrect");
			return false;
		}
	 }

	 public String email(){
	 	return email;
	 }
	 /**
	 *reset the username of the user
	* @param email 
	* 		 	is the new email that will overwrite the current email 
	*@param pass
	*			is the current password of the user will be user to validate if it is the correct user who does the changes
	 *
	 *throw an exception  if the password is incorrect
	*/
	 public boolean setEmail(String email,String pass){
		 
	 	if(this.password.equals(pass)){
			System.out.println("email was reset");
	 		this.email=email;
			return true;
		}else{
			 System.out.println("password is incorrect");
			return false;
		}
	 }
	
}