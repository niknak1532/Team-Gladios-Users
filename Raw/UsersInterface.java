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
  private static OptionTwo ot=null;

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
        ot=new OptionTwo(db.getConnection());
      }
      catch(Exception e)
      {}
    }
  }

/**
 * @param username Username string
 * @param password Password string
 * @param firstname Firstname string
 * @param lastname Lastname string
 * @param email Email string
 *
 * @todo it calls the registerUser() in OptionTwo class to add the user
 *
 * @return Returns a boolean to state if the user was successfully registered 
 */

  public static boolean registerUser(String username,String password,String firstname,String lastname,String email,String pNum)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
     
      re=ot.registerUser(username,password,firstname,lastname,email,pNum);
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
    boolean re=false;
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
    boolean re=false;
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
 * @param password Password string
 *
 * @todo It calls login() in the optiontwo calls
 *
 *
 */


   public static int emailLoginReset(String username,String key)
  {
    connectToDatabase();
    boolean re=false;
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
 * @todo it calls removeUser() in optiontwo class to remove user
 *
 * @return Returns a boolean stating whether or not the user was successfully removed from the database.
 */
  public static boolean removeUser(String username)
  {
    connectToDatabase();
    boolean re=false;
    try
    {
      //OptionTwo ot=new OptionTwo(c);
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
  public static String getEmail(String username)
  {
    connectToDatabase();
    String re="";
    try
    {
      if(c==null)
        System.out.println("her");
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
      //OptionTwo ot=new OptionTwo(c);
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
  public static int userLoginReset(String username, String key)
  {
    connectToDatabase();
    int re=-1;
    try
    {
      //OptionTwo ot=new OptionTwo(c);
      re=ot.userLoginReset(username,key);
    }
    catch(Exception e)
    {

    }
    finally
    {
      return re;
    }
  }
  public static int emailLoginReset(String email, String key)
  {
    connectToDatabase();
    int re=-1;
    try
    {
      //OptionTwo ot=new OptionTwo(c);
      re=ot.emailLoginReset(email,key);
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
