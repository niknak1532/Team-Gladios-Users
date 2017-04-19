import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public final class Usersinterface
{
	private Database db;
	private Usersinterface()
	{
		db = Database.getInstance();  
	}
	public int login(String username,String password)
	{
		OptionTwo objTwo = new OptionTwo(db);
		return objTwo.login(username,password);
	}
	public boolean removeUser(String username)
	{
		OptionTwo objTwo = new OptionTwo(db);
		return objTwo.removeUser(username);
	}
	public String getEmail(String username)
	{
		OptionTwo objTwo = new OptionTwo(db);
		return objTwo.getEmail(username);
	}
	public boolean registerUser(String username,String password,String firstname,String lastname,String email, int admin)
	{

		OptionTwo objTwo = new OptionTwo(db);
		return objTwo.registerUser(username,password,firstname,lastname,email,admin); 
	}
	public String getPhoneNumber(String username)
	{
		OptionTwo objTwo = new OptionTwo(db);
		return objTwo.getPhoneNumber(username);	
	}

	public String getActivation(String username)
	{
		Users _users = new Users(db);
		return _users.getPhoneNumber(username);
	} 

} 