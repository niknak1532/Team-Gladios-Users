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
