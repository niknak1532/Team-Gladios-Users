import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.*;
import java.lang.Character;
//static int id=0; 
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
 public OptionTwo(Connection o) throws Exception
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
 
 public boolean registerUser(String username,String password,String firstname,String lastname,String email,String pNum) throws Exception
 {
  String sql="SELECT * FROM "+" Users" + " WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
  ResultSet result=stmt.executeQuery(sql);
  //System.out.println(setExpirationDate());
  if(result.next())
   return false;
 
  sql="INSERT INTO ";
  sql += "Users (Username,Password,Firstname,Lastname,Email,ActivatedKey,ResetKey,ResetDate,PhoneNumber,activated)" ;
  sql +="VALUES (\'";
  sql += username+"\',\'"+password+"\',\'"+firstname+"\',\'"+lastname+"\',\'"+email; /* please arrange  and on (don,t forget to comma separate) the parameters according to how the columns are set up */ ;
  sql+="\',\'"+createActivationKey();

  sql+="\',\'"+createActivationKey();
   
  sql+="\',\'"+setExpirationDate();
  sql+="\',\'"+pNum;
  sql+="\',false);";
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
  if(result.next()&&result.getBoolean("activated"))
   return result.getInt("id");
  else
   return -1;
 }

 public int userLoginReset(String username, String key) throws SQLException
        {
            String sql="SELECT * FROM "+"Users" + "WHERE Username=\'"+username+"\' AND ActivatedKey=\'"+key+"\' ;";
            ResultSet result=stmt.executeQuery(sql);
            if(result.next()&&checkDate(result.getString("ResetDate"))){
                    return result.getInt("id");
            }else
                    return -1;
        }
        
  public int emailLoginReset(String email, String key) throws SQLException
  {
      String sql="SELECT * FROM "+"Users" + "WHERE Email=\'"+email+"\' AND ActivatedKey=\'"+key+"\' ;";
      ResultSet result=stmt.executeQuery(sql);
      if(result.next()&&checkDate(result.getString("ResetDate"))){
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

 public String createActivationKey()
 {
   String symbols=new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
   String key="";
   Random random = new Random();
   for(int i=0;i<7;i++)
     key+=symbols.charAt(random.nextInt(symbols.length()));
   return key;
 }
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
 public String setExpirationDate()
 {
   Calendar c=new GregorianCalendar();
   c.add(GregorianCalendar.HOUR,24);
   String tmp="";
   tmp+=""+c.get(Calendar.DAY_OF_MONTH)+":"+c.get(Calendar.MONTH)+":"+c.get(Calendar.YEAR);
   return tmp;
 }

  public boolean testActivatedKey(String username,String key) throws SQLException{
      String sql="SELECT * FROM "+"Users" + "WHERE Username=\'"+username+"\' AND ActivatedKey=\'"+key+"\' ;";
      ResultSet result=stmt.executeQuery(sql);
      if(result.next())
          return true;
      else
          return false;
  }
}
