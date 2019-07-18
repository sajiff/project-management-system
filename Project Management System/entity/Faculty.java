package entity;

import java.lang.*;

public class Faculty
{
	private String fname;
	private String fid;
	private String subject;
	
	public Faculty(){}
	public Faculty(String fname, String fid, String subject)
	{
		this.fname = fname;
		this.fid = fid;
		this.subject = subject;
	}
	public void setfname(String fname)
	{
		this.fname = fname;
	}
	public void setfid(String fid)
	{
		this.fid = fid;
	}
	public void setsubject(String subject)
	{
		this.subject = subject;
	}
	
	public String getfname()
	{
		return fname;
	}
	public String getfid()
	{
		return fid;
	}
	public String getsubject()
	{
		return subject;
	}
}