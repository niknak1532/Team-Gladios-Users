public class Admin extends User{
	private boolean isAdmin;

	public Admin(String userID, String username, String fname, String lname, String em){
        id=userID;
        uname=username;
		fname=firstname;
		lname=lastname;
		em=email;
		isAdmin=true;
    }
}
