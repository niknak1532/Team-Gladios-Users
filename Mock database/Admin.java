import java.util.*;

public class Admin
{
	ArrayList<user> adminList;
	//private boolean grant_admin_right;
	public Admin()
	{
		grant_admin_right=false;
	}
	public Admin(boolean adminRight)
	{
		grant_admin_right=adminRight;
	}
	public void addUser(user obj)
	{
		if(adminList.indexOf(obj)==-1)
			adminList.add(obj);
	}
	public void removeUser(user obj)
	{
		adminList.remove(obj);
	}
	public void grantAdminRight(user obj)
	{
		if(adminList.indexOf(obj)!=-1)
			adminList.get(adminList.indexOf(obj)).grant_admin_right=true;
	}
}
