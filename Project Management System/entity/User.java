package entity;

import java.lang.*;

public class User
{
	private String userid;
	private String password;
	private int status;
	
	public User(){}
	public User(String userid, String password, int status)
	{
		this.userid = userid;
		this.password = password;
		this.status = status;
	}
	
	public void setuserid(String userid){this.userid = userid;}
	public void setpassword(String password){this.password = password;}
	public void setstatus(int status){this.status = status;}
	
	public String getuserid(){return userid;}
	public String getpassword(){return password;}
	public int getstatus(){return status;}
}