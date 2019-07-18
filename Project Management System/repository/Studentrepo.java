package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class Studentrepo implements IStudentRep
{
	DatabaseConnection dbc;
	
	public Studentrepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertStudent(Student st)
	{
		String query = "INSERT INTO student VALUES ('"+st.getstid()+"','"+st.getstname()+"','"+st.getsection()+"','"+st.getgrpid()+"','"+st.getprname()+"',"+st.getmarks()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateStudent(Student st)
	{
		String query = "UPDATE student SET stid = '"+st.getstid()+"',stname='"+st.getstname()+"', section = '"+st.getsection()+"', grpid = '"+st.getgrpid()+"', prname = '"+st.getprname()+"', fmarks = "+st.getmarks()+" WHERE stid='"+st.getstid()+"'";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteStudent(String stid)
	{
		String query = "DELETE from student WHERE stid='"+stid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	
	public String[][] getallstudent()
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		String query = "SELECT * FROM student;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String stid = dbc.result.getString("stid");
				String stname = dbc.result.getString("stname");
				String section = dbc.result.getString("section");
				String grpid = dbc.result.getString("grpid");
				String prname = dbc.result.getString("prname");
				double fmarks = dbc.result.getDouble("fmarks");
				
				Student st = new Student(stname, stid, section, grpid, prname, fmarks);
				ar.add(st);
			}
		}
		
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Student)obj[i]).getstid();
			data[i][1] = ((Student)obj[i]).getstname();
			data[i][2] = ((Student)obj[i]).getsection();
			data[i][3] = ((Student)obj[i]).getgrpid();
			data[i][4] = ((Student)obj[i]).getprname();
			data[i][5] = ((Student)obj[i]).getmarks()+"";
		}
		return data;
	}
	public Student searchstudent(String stid)
	{
		
		Student st = null;
		String query = "SELECT * FROM student WHERE `stid`='"+stid+"';";     // AND `grpid`='"+grpid+"'//
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String sstid = dbc.result.getString("stid");
				String stname = dbc.result.getString("stname");
				String section = dbc.result.getString("section");
				String grpid = dbc.result.getString("grpid");
				String prname = dbc.result.getString("prname");
				int fmarks = dbc.result.getInt("fmarks");
				
				st = new Student();
				st.setstid(sstid);
				st.setstname(stname);
				st.setsection(section);
				st.setgrpid(grpid);
				st.setprname(prname);
				st.setmarks(fmarks);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return st;
	}
	
}