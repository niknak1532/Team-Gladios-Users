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

    public User(String userID, String username, String fname, String lname, String em){
        id=userID;
        uname=username;
		fname=firstname;
		lname=lastname;
		em=email;
    }

    protected void setUser(){
        //update all information to database user
    }

    public void setActivation(){
        activated=true;
    }

	public String firstname(){
		return firstname;
	}
	
	public String lastname(){
		return lastname;
	}
	
	public String email(){
		return email;
	}
}
