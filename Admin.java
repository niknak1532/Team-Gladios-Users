class Admin{
	
	private User user;
	
	Admin(User user){
		this.user=user;
	}
	public String getAdminName(){
		
		return user.getUsername();
	}
	public boolean setUsername(String name, String pass){
		/*reseting the user name
		* the user input the pass word and check if the password is correct
		*before updating the user name
		*else throw an exception*/
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
	
	public boolean updatePass(String name, String pass, String oldPass){
		
		/*updating  the password
		* the user input the input the currect password and the username
		*check if the username is correct and current password is correct
		*before updating the user name
		*else throw an exception*/
		
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