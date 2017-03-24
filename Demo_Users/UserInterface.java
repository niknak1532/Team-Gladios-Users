package users;

/**
 *
 * @author BrianKamau
 */
public class UserInterface {

    public boolean addUser(String ID, String username, String password, String email){
        if(getUser(username))
			User user=new User(ID,username)
            sendNotification();
            return true;
        else
			return false;
    }

	public User getUser(String username){
        if(userExists){
            System.out.println("No Such User")
            return null;
        }else{
			//SQL query to find object and return the object
            return user;
        }
    }
	
    public boolean removeUser(String username){
        //SQL query to delete object
    }
    
    public void activateUser(String username){
		User user=getUser(username);
		user.setActivation();
    }
    
    public boolean login(String username, String password){
        if(user.username==username && user.password==password)
			//SQL compare will be done here
            return true;
        else
            return false;
    }
    
    public String getUsername(String username){
		User user=getUser(username);
        return user.username;
    }

    public boolean getActivation(String username){
		User user=getUser(username);
        return user.getActivated();
    }

	public boolean getEmail(String username){
		User user=getUser(username);
        return user.getEmail();
    }
	
    public boolean grantAdminRights(String adminUsername, String username){
		User user=getUser(username);
		User auser=getUser(adminUsername);
        if(checkAdminRights(auser)){
			user=new Admin(user.userID, user.username, user.fname, user.lname, user.em);
			user.setAdmin();
			return true;
		}
    }
    
    public boolean checkAdminRights(User aUser){
        if(auser instanceof Admin)
			return true;
		else
			return false;
    }
    
}
