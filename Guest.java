class Guest{
	
	private String username;
	private String email;
	
	Guest(String name, String em){
		/* the guest user name and the email are set in the constructor
		*and they will never be updated since this is not the register
		*user and no need to update them*/
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