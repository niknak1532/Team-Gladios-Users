 java.util.Date

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
	    
         
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
LocalDateTime now = LocalDateTime.now();
//Send   dtf.format(now)  To DataBase in ResetDate column
    }
	

    public boolean checkresetKey(String rKey)
    {
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
  	    LocalDateTime now = LocalDateTime.now();
	    
	if(rKey == resetKey) 
	{
		if( dtf.format(now) - /*resetDate from Database*/  <= 0000/00/03 00:00:00  )
		{
			return true;
		}
		else
		{
			System.out.println("Your Key has been Expired!")
		}
	}
	else
	{
		System.out.println("There is something Wrong with your Link")	
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
