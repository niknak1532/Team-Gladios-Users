package users;

/**
 *
 * @author BrianKamau
 */
public class User {
    protected long id;
    protected username, firstname, lastname, email;
    protected boolean activated;
//don't understand resetKey, resetDate, activatedKey
    protected boolean userExists;//mokVal

    public User(String userID, String username, String fname, String lname, String em, boolean active, String){
        id=userID;
        uname=username;
		fname=firstname;
		lname=lastname;
		em=email;
        active=activated;
    }

    protected void setUser(){
        //update all information to database user
    }

    public String getActivationKey(){

        
    }
	
    public String getresetKey(String userName)
    {
	    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
	    
        String saltStr = salt.toString();
	    
	    //SQL Put resetKey to Database
	    
         
	    
	    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    }
	

    public boolean checkresetKey(String rKey)
    {
	if(rKey == resetKey) 
	{
		if(resetDate == )
	}	
    }
	    
	    
	
    public boolean checkActivationKey(String key){
        activated=true;
    }

	public String getFirstname(){
		return firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public String getEmail(){
		return email;
	}
}
