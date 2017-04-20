import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public final class UsersInterface
{
  Connection c = null;
  private UsersInterface()
  {
    if(c!=null)
    {
      Database db=Database.getInstance();
      c=db.getConnection();
    }
  }

  public boolean registerUser(String username,String password,String firstname,String lastname,String email, int admin,String pNum)
  {
    boolean re=false;
    try
    {
      OptionTwo ot=new OptionTwo(c);
      re=ot.registerUser(username,password,firstname,lastname,email,admin,pNum);
    }
    catch(Exception e)
    {

    }
    finally
    {
      return re;
    }
  }

  public boolean removeUser(String username)
  {
    boolean re=false;
    try
    {
      OptionTwo ot=new OptionTwo(c);
      re=ot.removeUser(username);
    }
    catch(Exception e)
    {

    }
    finally
    {
      return re;
    }
  }
  public int login(String username,String password)
  {
    int re=-1;
    {
      OptionTwo ot=new OptionTwo(c);
      re=ot.login(username,password);
    }
    catch(Exception e)
    {

    }
    finally
    {
      return re;
    }
  }

  public String getEmail(String username)
  {
    String re="";
    {
      OptionTwo ot=new OptionTwo(c);
      re=ot.getEmail(username);
    }
    catch(Exception e)
    {

    }
    finally
    {
      return re;
    }
  }

  public String getPhoneNumber(String username)
  {
    String re="";
    {
      OptionTwo ot=new OptionTwo(c);
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
  public int userLoginReset(String username, String key)
  {
    int re=-1;
    {
      OptionTwo ot=new OptionTwo(c);
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
  public int emailLoginReset(String email, String key)
  {
    int re=-1;
    {
      OptionTwo ot=new OptionTwo(c);
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
