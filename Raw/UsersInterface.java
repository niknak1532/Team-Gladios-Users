import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public final class UsersInterface
{

  /**
  *   @param
  *         c is used to create the connection between the database
  *  @param
  *         ot is the object of OptionTwo used to access the functions in the optiontwo class
  *   
  *
  */
  private static Connection c = null;
  private static User ot=null;

  /**
  *
  *
  * @todo 
  *     the connectToDatabase() connect to the database and creat connection of the database.
  *
  */

  private static void connectToDatabase()
  {
    if(c==null){
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
 * @param username Username string
 * @param password Password string
     * @param fullname
 * @param firstname Firstname string
     * @param pNum
 * @param lastname Lastname string
 * @param email Email string
 *
 * @todo it calls the registerUser() in OptionTwo class to add the user
 *
 * @return Returns a boolean to state if the user was successfully registered 
 */

  public static boolean registerUser(String username,String password,String fullname,String email,String pNum)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
     
      re=ot.registerUser(username,password,fullname,email,pNum);
    }
    catch(Exception e)
    {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param username Username string
 * @param password Password string
 *
 * @todo It calls login() in the optiontwo calls
 *
 *
 */
  public static int login(String username,String password)
  {
    connectToDatabase();
    int re=-1;
    try
    {
     
      re=ot.login(username,password);
    }
    catch(Exception e)
    {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param username Username string
 * @param password Password string
 *
 * @todo It calls login() in the optiontwo calls
 *
 *
 */

   public static int userLoginReset(String username,String key)
  {
    connectToDatabase();
    int re=-1;
    try
    {
     
      re=ot.userLoginReset(username,key);
    }
    catch(Exception e)
    {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

  /** 
 * @param username Username string
 * @param key
 * @param password Password string
 *
 * @todo It calls login() in the optiontwo calls
 *
 *
 */


   public static int emailLoginReset(String username,String key)
  {
    connectToDatabase();
    int re=-1;
    try
    {
      re=ot.emailLoginReset(username,key);
    }
    catch(Exception e)
    {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

    /**
     *
     * @param username
     * @param key
     * @return
     */
  public static boolean testActivatedKey(String username,String key)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
      re=ot.testActivatedKey(username,key);
    }
    catch(Exception e)
    {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

/**
 * @param username Username string
 * 
 * @todo it calls removeUser() in user class to remove user
 *
 * @return Returns a boolean stating whether or not the user was successfully removed from the database.
 */
  public static boolean removeUser(String username)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
      re=ot.removeUser(username);
    }
    catch(Exception e)
    {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

 /**
 * @param username Username string
 * 
 * @todo it calls getEmail() in optionTwo class to get email
 *
 * @return Returns a the string with the email of the user, if found.If not found, it return null
 */
  public static String getUserDetails(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      re=ot.getUserDetails(username);
    }
    catch(Exception e)
    {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }
  
/**
 * @param username Username string
 * 
 * @todo it calls getEmail() in optionTwo class to get email
 *
 * @return Returns a the string with the email of the user, if found.If not found, it return null
 */
  public static String getEmail(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      re=ot.getEmail(username);
    }
    catch(Exception e)
    {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }
    finally
    {
      return re;
    }
  }

   /**
 * @param username Username string
 * 
 * @todo it calls getPhoneNumber() in optionTwo class
 *
 * @return Returns a the string with the phone number of the user, if found.If not found, it return null
 */

  public static String getPhoneNumber(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      re=ot.getPhoneNumber(username);
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
