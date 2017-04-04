

public class Users {

public boolean addUser(String username, String password, String email,String firstname
    ,String lastName, boolean activated, String activatedKey, String resetKey){
        if(getUser(username))
			User user=new User(iD,username)
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

    protected long id;
    protected username, firstname, lastname, email;
    protected boolean activated;
    Public String resetKey, resetDate, activatedKey
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

    public String getFirstname(String username){
        return firstname;
    }
    
    public String getLastname(String username){
        return lastname;
    }
    
    public String getEmail(String username){
        return email;
    }


}