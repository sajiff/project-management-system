package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class Facultyrepo implements IFacultyRep
{
	DatabaseConnection dbc;
	
	public Facultyrepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertInDB(Faculty f)
	{
		String query = "INSERT INTO faculty VALUES ('"+f.getfid()+"','"+f.getfname()+"','"+f.getsubject()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String fid)
	{
		String query = "DELETE from faculty WHERE fid='"+fid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Faculty f)
	{
		String query = "UPDATE faculty SET fid='"+f.getfid()+"', fname = '"+f.getfname()+"', subject = '"+f.getsubject()+"';";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public String[][] getAllStudent()
	{
		ArrayList<Faculty> fr = new ArrayList<Faculty>();
		String query = "SELECT * FROM faculty;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String fid = dbc.result.getString("fid");
				String fname = dbc.result.getString("fname");
				String subject = dbc.result.getString("subject");
				
				Faculty f = new Faculty(fid,fname,subject);
				fr.add(f);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = fr.toArray();
		String data[][] = new String [fr.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Faculty)obj[i]).getfid();
			data[i][1] = ((Faculty)obj[i]).getfname();
			data[i][2] = ((Faculty)obj[i]).getsubject();
		}
		return data;
	}
	
}