package entity;

import java.lang.*;

public class Student
{	
	private String stname;
	private String stid;
	private String section;
	private String grpid;
	private String prname;
	private double fmarks;
	
	public Student(){}
	public Student(String stname, String stid,String section, String grpid, String prname, double fmarks)
	{
		this.stname = stname;
		this.stid = stid;
		this.fmarks = fmarks;
		this.grpid= grpid;
		this.prname = prname;
		this.section = section;
	}
	
	public void setstname(String stname)
	{
		this.stname = stname;
	}
	public void setstid(String stid)
	{
		this.stid = stid;
	}
	public void setmarks(double fmarks)
	{
		this.fmarks = fmarks;
	}
	public void setsection(String section)
	{
		this.section = section;
	}
	public void setgrpid(String grpid)
	{
		this.grpid = grpid;
	}
	public void setprname(String prname)
	{
		this.prname = prname;
	}
	
	public String getstname()
	{
		return stname;
	}
	public String getstid()
	{
		return stid;
	}
	public double getmarks()
	{
		return fmarks;
	}
	public String getsection()
	{
		return section;
	}
	public String getgrpid()
	{
		return grpid;
	}
	public String getprname()
	{
		return prname;
	}
}