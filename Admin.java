class Admin{
	
	private User user;
	
	Admin(User user){
		this.user=user;
	}
	public String getAdminName(){
		
		return user.getUsername();
	}
	/**
	*reset the username of the user
	* @param name 
	* 		 	is the new username that will over write the existing one
	*@param pass
	*			is the password of the user will be user to validate if it is the correct user who want to change the username
	 *
	 *return false if the password dont match 
	*else return true
	*/
	public boolean setUsername(String name, String pass){
		
		if(!pass.equals(getPassword())){
			System.out.println("Password is incorrect");
			return false;
		}
		else{
			System.out.println("Username is updated");
			user.setUsername(name);
			return true;
		}
	}
	
	public long getID(){
		return user.getID();
	}
	/**
	*update password
	* @param name 
	* 		 	is the username of the admin to check if this is the correct user who does the changes
	*@param pass
	*			is the new password that will overwite the existing password
	*@param oldPass 
	*		is the currecnt password that will be useed to check if the user knows the password and it is the correct user who does the changes
	 *
	 *return false if the password or username do not match 
	*else return true
	*/
	public boolean updatePass(String name, String pass, String oldPass){
	
		
		if(!name.equals(getAdminName())){
			System.out.println("The user name is incorrect");
			return false;
		}
		else if(!oldPass.equals(user.getPassword())){
			System.out.println("The old pass word does not match");
			return false;
		}
		else{
			System.out.println("Password is updated");
			setUsername(name);
			return true;
		}
	}
	public String getPassword(){
		return user.getPassword();
	}
}