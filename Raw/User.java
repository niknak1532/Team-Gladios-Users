import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.util.Random;
import java.util.*;
//static int id=0; 
public class User
{
 private Connection db; //!< This is the database object 
 private Statement stmt; //!< This is the statement object used to execute the queries
 
 /*
 * @param o Dabase object
 * @todo Assigns the passed object to the local databse object. Then creates the Statement object, which will be used to execute the SQL queries
 *
 *
 */
 public User(Connection o) throws Exception
 {
  db=o;
  stmt=db.createStatement();
 }
 /**
 * @param username Username string
 * @param password Password string
 * @param firstname Firstname string
 * @param lastname Lastname string
 * @param email Email string
 *
 * @todo It first checks if the database has the user, if not it adds the user.
 *
 * @return Returns a boolean to state if the user was successfully registered 
 */
 
 public boolean registerUser(String username,String password,String fullname,String email,String pNum) throws Exception
 {
  String sql="SELECT * FROM "+" Users" + " WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  //System.out.println(setExpirationDate());
  if(result.next())
   return false;
 
  sql="INSERT INTO ";
  sql += "Users (Username,Password,Fullname,Email,ActivatedKey,ResetKey,ResetDate,PhoneNumber,Activated,Admin)" ;
  sql +="VALUES (\'";
  sql += username+"\',\'"+password+"\',\'"+fullname+"\',\'"+email; /* please arrange  and on (don,t forget to comma separate) the parameters according to how the columns are set up */ ;
  sql+="\',\'"+createActivationKey();

  sql+="\',\'"+createActivationKey();
   
  sql+="\',\'"+setExpirationDate();
  sql+="\',\'"+pNum;
  sql+="\',false,false);";
  stmt.executeUpdate(sql);

  //System.out.println("here");
  return true;
 }
 
 /** 
 * @param username Username string
 * @param password Password string
 *
 * @todo It checks if the user exists in the databse
 *
 * @return Returns -1 if the user does not exist on the database. It returns the user's ID if the user exists on the database
 */
 
 public int login(String username,String password) throws Exception
 {
  String sql="SELECT * FROM "+"Users" + " WHERE Username=\'"+username+"\' AND Password=\'"+password+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next()&&result.getBoolean("Activated"))
   return result.getInt("id");
  else
   return -1;
 }

/**
*
* @param username
* @param key
* @return
* @throws SQLException
*/
public int userLoginReset(String username, String key) throws SQLException
{
   String sql="SELECT * FROM users WHERE Username=\'"+username+"\' AND ActivatedKey=\'"+key+"\' ;";
   ResultSet result=stmt.executeQuery(sql);
   if(result.next()&&checkDate(result.getString("ResetDate"))){
           sql="UPDATE User SET ResetDate=NULL WHERE Username=\'"+username+"\' ;";
            stmt.executeQuery(sql);
           return result.getInt("id");
   }else
           return -1;
}

/**
*
* @param email
* @param key
* @return
* @throws SQLException
*/
public int emailLoginReset(String email, String key) throws SQLException
{
   String sql="SELECT * FROM users WHERE Email=\'"+email+"\' AND ActivatedKey=\'"+key+"\' ;";
   ResultSet result=stmt.executeQuery(sql);
   if(result.next()&&checkDate(result.getString("ResetDate"))){
            sql="UPDATE User SET ResetDate=NULL WHERE Email=\'"+email+"\' ;";
            stmt.executeQuery(sql);
           return result.getInt("id");
   }else
           return -1;
}
 
 /**
 * @param username Username string
 * 
 * @todo Removes the user from the database
 *
 * @return Returns a boolean stating whether or not the user was successfully removed from the database.
 */
 public boolean removeUser(String username) throws Exception
 {
  String sql="DELETE FROM "+"Users" + " WHERE Username=\'"+username+"\' ;";
  stmt.executeUpdate(sql);
  //stmt.close();
  //db.commit();
   sql="SELECT * FROM "+"Users" + " WHERE Username=\'"+username+"\';";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next())
   return false;
  else
   return true;
 }

    /**
     *
     * @param username
     * @return Returns the user fullname, email, phone number
     * @throws Exception
     */
 public String getUserDetails(String username) throws Exception
 {
  String sql="SELECT * FROM "+"Users" + " WHERE Username=\'"+username+"\';";

  ResultSet result=stmt.executeQuery(sql);

  if(result.next())
  {
    //System.out.println(result.getString("email"));
   return result.getString("Fullname")+";"+result.getString("Email")+";"+result.getString("Phonenumber");
  }
  else
   return null;
 }
 /**
 * @param username Username string
 * 
 * @todo Retrieves the email of the user from the database
 *
 * @return Returns a the string with the email of the user, if found.If not found, it return null
 */
 public String getEmail(String username) throws Exception
 {

  String sql="SELECT * FROM "+"Users" + " WHERE Username=\'"+username+"\';";

  ResultSet result=stmt.executeQuery(sql);

  if(result.next())
  {
    //System.out.println(result.getString("email"));
   return result.getString("email").trim();
  }
  else
   return null;
 }
 
 /**
 * @param username Username string
 * 
 * @todo Retrieves the phone number of the user from the database
 *
 * @return Returns a the string with the phone number of the user, if found.If not found, it return null
 */
 public String getPhoneNumber(String username) throws Exception
 {
  String sql="SELECT * FROM "+"Users" + " WHERE Username=\'"+username+"\';";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next())
   return result.getString("PhoneNumber").trim();
  else
   return null;
 }

/**
 *
 * @param username
 * @return Returns boolean value stating whether a specified user is an admin
 * @throws SQLException
 */
public boolean isAdmin(String username) throws SQLException
 {
    String sql="SELECT * FROM users WHERE Username=\'"+username+"\' AND Admin=true ;";
    ResultSet result=stmt.executeQuery(sql);
    if(result.next()){
            System.out.println(username+" is Admin");
            return true;
    }else
            return false;
}

    /**
     *
     * @param username
     * @return Returns boolean value stating whether a user was successfully made an admin
     * @throws SQLException
     */
    public boolean makeAdmin(String username) throws SQLException{
    String sql="SELECT * FROM users WHERE Username=\'"+username+"\' ;";
    ResultSet result=stmt.executeQuery(sql);
    if(result.next()){
        sql="UPDATE UserTable SET Admin=true WHERE Username=\'"+username+"\' ;";
        stmt.execute(sql);
        System.out.println("You have been successfully activated!");
        return true;
    }else
        return false;
}
 
    /**
     *
     * @return Returns the activation key
     */
    public String createActivationKey()
 {
   String symbols=new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
   String key="";
   Random random = new Random();
   for(int i=0;i<7;i++)
     key+=symbols.charAt(random.nextInt(symbols.length()));
   return key;
 }

/**
 *
 * @param date
 * @return Returns a boolean value stating whether the reset key date has expired.
 */
public boolean checkDate(String date)
 {
   String ap[]=date.split(":");
   if(ap.length!=3)
     return false;
   int d=Character.getNumericValue(ap[0].charAt(0)),m=Character.getNumericValue(ap[1].charAt(0)),y=0;
   if(ap[0].length()==2)
     d=(d*10)+Character.getNumericValue(ap[0].charAt(1));
   
   if(ap[1].length()==0)
     m=(m*10)+Character.getNumericValue(ap[1].charAt(1));
   for(int i=0;i<4;i++)
     y=(y*10)+Character.getNumericValue(ap[2].charAt(i));
   
   Calendar today=new GregorianCalendar();
   Calendar exp=new GregorianCalendar(d,m,y);
   if(today.compareTo(exp)<0)
     return false;
   return true;
 }
    
    /**
     *
     * @return Returns expiration date which will be used to state the expiration of the reset key. 
     */
    public String setExpirationDate()
 {
   Calendar c=new GregorianCalendar();
   c.add(GregorianCalendar.HOUR,24);
   String tmp="";
   tmp+=""+c.get(Calendar.DAY_OF_MONTH)+":"+c.get(Calendar.MONTH)+":"+c.get(Calendar.YEAR);
   return tmp;
 }

 /**
* @param username Username string
* @throws java.sql.SQLException
* 
* @todo Retrieves the email and activated key of the user from the database
*
* @return Returns a the string with the email and activated key of the user, if found.If not found, it return null
*/
public String getActivation(String username) throws Exception{
    String sql="SELECT * FROM "+"Users" + " WHERE Username=\'"+username+"\';";

  ResultSet result=stmt.executeQuery(sql);

  if(result.next())
  {
    //System.out.println(result.getString("email"));
   return result.getString("ActivatedKey").trim();
  }
  else
   return null;
}

/**
 *
 * @param username
 * @param key
 * @return Returns a boolean value stating whether the activation key for the specified user was correct
 * @throws Exception
 */
public boolean testActivatedKey(String username,String key) throws Exception
{
  String sql="SELECT * FROM users WHERE Username=\'"+username+"\' AND ActivatedKey=\'"+key+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next()){
      sql="UPDATE users SET Activated=true WHERE Username=\'"+username+"\' ;";
      stmt.execute(sql);
      //System.out.println("You have been successfully activated!");
      return true;
  } else
      return false;
}
 
/**
 *
 * @param username
 * @return Returns the reset key of a specified user as a string
 * @throws Exception
 */
public String getResetKey(String username) throws Exception
{
    String sql="SELECT * FROM users WHERE Username=\'"+username+"';";
    ResultSet result=stmt.executeQuery(sql);
    if(result.next()){
        //System.out.println(result.getString("ResetKey"));
        return result.getString("ResetKey").trim();
    }else
        return null;
}


}
