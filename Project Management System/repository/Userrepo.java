package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class Userrepo implements IUserRepo
{
	DatabaseConnection dbc;
	
	public Userrepo()
	{
		dbc = new DatabaseConnection();
	}
	public User getuser(String userid, String password)
	{
		User user = null;
		String query = "SELECT userid, password, status FROM login WHERE userid='"+userid+"' AND password='"+password+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			while(dbc.result.next())
			{
				user = new User();
				user.setuserid(dbc.result.getString("userid"));
				user.setpassword(dbc.result.getString("password"));
				user.setstatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	public void insertuser(User u)
	{
		String query = "INSERT INTO login VALUES ('"+u.getuserid()+"','"+u.getpassword()+"','"+u.getstatus()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateuser(User u){}
	
	public void deleteuser(String userid)
	{
		String query = "DELETE from login  WHERE userid='"+userid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
}