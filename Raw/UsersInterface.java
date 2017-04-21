import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public final class UsersInterface
{

  /**
  *   @param c is the object with the connection to the database.
  *         
  *  @param ot is the object that is used to access the database services.
  *         
  *   
  *
  */
  private static Connection c = null;
  private static User ot=null;
  
  /**
  *
  * @param Accepts nothing
  *
  * @todo Makes sure that UsersInterface objects are never created.
  *
  * @return Returns nothing.
  */
  private UsersInterface()
  {
  }
  /**
  * @param Accepts nothing.
  *
  * @todo It establishes a connection to the database.
  *     
  * @return Returns nothing.
  * 
  */

  private static void connectToDatabase()
  {
    if(ot==null){
    try
      {
        Database db=null;
        db=Database.getInstance();
        ot=new User(db.getConnection());
      }
      catch(Exception e)
      {}
    }
  }

/**
 * @param username Username as a string.
 * @param password Password as a string.
 * @param fullname User's full name as a string.
 * @param email User's email address as a string.
 * @param pNum User's phone number as a string.
 *
 * @todo Registers the user to the database using the given information.
 *
 * @return Returns a boolean to state if the user was successful or not in registering themselves. 
 */

  public static boolean registerUser(String username,String password,String fullname,String email,String pNum)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
     
      re=ot.registerUser(username.trim(),password.trim(),fullname.trim(),email.trim(),pNum.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param username Username as a string
 * @param password Password as a string
 *
 * @todo It checks if the user is registered in the database and that his/her account has been activated.
 *
 * @return Returns the user's ID if the user exists on the database and their account is activated. Otherwise, it returns -1.
 */
  public static int login(String username,String password)
  {
    connectToDatabase();
    int re=-1;
    try
    {
     
      re=ot.login(username.trim(),password.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param username Username as a string
 * @param password Password as a string
 *
 * @todo Activates the user's account using the user's username and the activation key they were sent.
 *
 * @return Returns the user's ID if the user exists on the database and their account is activated. Otherwise, it returns -1.
 */

   public static int userLoginReset(String username,String key)
  {
    connectToDatabase();
    int re=-1;
    try
    {
     
      re=ot.userLoginReset(username.trim(),key.trim());
    }
    catch(Exception e)
    {
      
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param email Email as a string
 * @param password Password as a string
 *
 * @todo Activates the user's account using the user's registered email and the activation key they were sent.
 *
 * @return Returns the user's ID if the user exists on the database and their account is activated. Otherwise, it returns -1.
 */

   public static int emailLoginReset(String email ,String key)
  {
    connectToDatabase();
    int re=-1;
    try
    {
      re=ot.emailLoginReset(username.trim(),key.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param username Username as a string
 * @param key Key as a string
 *
 * @todo Checks if the user has the correct activation as the one assigned to them.
 *
 * @return Returns true or false to whether or not the activation key matched the one linked to the user.
 */  */
  public static boolean testActivatedKey(String username,String key)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
      re=ot.testActivatedKey(username.trim(),key.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }

/**
 * @param username Username string
 * 
 * @todo It removes the given user's account
 *
 * @return Returns a boolean stating whether or not the user was successfully removed from the database.
 */
  public static boolean removeUser(String username)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
      re=ot.removeUser(username.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }

 /**
 * @param username Username as a string
 * 
 * @todo It checks if the user exists on the database
 *
 * @return Returns a semi-colon separated string of the user's information [full name ; email ; phone number], or null if the user does not exist.
 */
  public static String getUserDetails(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      re=ot.getUserDetails(username.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }
  
/**
 * @param username Username as a string
 * 
 * @todo It checks if the username exists in the database.
 *
 * @return Returns a string with the email of the user, if found.If not found, it will return null.
 */
  public static String getEmail(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      re=ot.getEmail(username.trim());
    }
    catch(Exception e)
    {
    }
    finally
    {
      return re;
    }
  }

  /**
 * @param username Username as a string
 * 
 * @todo It checks if the username exists in the database.
 *
 * @return Returns a string with the phone number of the user, if found.If not found, it will return null.
 */
  public static String getPhoneNumber(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      re=ot.getPhoneNumber(username.trim());
    }
    catch(Exception e)
    {

    }
    finally
    {
      return re;
    }
  }
}
