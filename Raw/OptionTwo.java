import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.*;

public class OptionTwo
{
 private Connection db; //!< This is the database object 
 private Statement stmt; //!< This is the statement object used to execute the queries
 
 /*
 * @param o Dabase object
 * @todo Assigns the passed object to the local databse object. Then creates the Statement object, which will be used to execute the SQL queries
 *
 *
 */
 public OptionTwo(Connection o)
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
 
 public boolean registerUser(String username,String password,String firstname,String lastname,String email, int admin)
 {
  String sql="SELECT * FROM "+" User" + " WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next())
   return false;
  sql="INSERT INTO ";
  sql += "User (Username,Password,Firstname,Lastname,Email,ActvatedKey,ResetKey,ResetDate)" ;
  sql +="VALUES (";
  sql += username+","+password+","+firstname+","+lastname+","+email; /* please arrange  and on (don,t forget to comma separate) the parameters according to how the columns are set up */ ;
  sql+=","+createActivationKey();
  sql+=","+createActivationKey();
  sql+=","+setExpirationDate();
  sql+=");";
  stmt.executeUpdate(sql);
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
 
 public int login(String username,String password)
 {
  String sql="SELECT * FROM "+"User" + " WHERE Username=\'"+username+"\' AND Password=\'"+password+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next())
   return result.getInt("id");
  else
   return -1;
 }
 
 /**
 * @param username Username string
 * 
 * @todo Removes the user from the database
 *
 * @return Returns a boolean stating whether or not the user was successfully removed from the database.
 */
 public boolean removeUser(String username)
 {
  String sql="DELETE FROM "+"User" + " WHERE Username=\'"+username+"\' AND Password=\'"+password+"\' ;";
  ResultSet result=stmt.executeUpdate(sql);
  db.commit();
  String sql="SELECT * FROM "+"User" + " WHERE Username=\'"+username+"\' AND Password=\'"+password+"\' ;";
  result=stmt.executeQuery(sql);
  if(result.next())
   return false;
  else
   return true;
 }
 /**
 * @param username Username string
 * 
 * @todo Retrieves the email of the user from the database
 *
 * @return Returns a the string with the email of the user, if found.If not found, it return null
 */
 public String getEmail(String username)
 {
  String sql="SELECT * FROM "+"User" + " WHERE Username=\'"+username+"\' AND Password=\'"+password+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  if(result.next())
   return result.getString("email");
  else
   return null;
 }
 
 public String createActivationKey()
 {
   String symbols=new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
   String key="";
   Random random = new Random();
   for(int i=0;i<7;i++)
     key.append(symbols.charAt(random.nextInt(symbols.length)));
   return key;
 }
 
 public String setExpirationDate()
 {
   Calendar c=new GregorianCalendar();
   c.add(2,1);
   String tmp="";
   tmp+=""+c.get(Calendar.DAY_OF_MONTH)+":"+c.get(Calendar.MONTH)+":"c.get(Calendar.YEAR);
   return tmp;
 }
}
