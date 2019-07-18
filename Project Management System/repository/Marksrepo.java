package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class Marksrepo implements IMarksrepo
{
	
	DatabaseConnection dbc;
	
	public Marksrepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Marks m)
	{
		String query = "INSERT INTO marks VALUES ('"+m.getstid()+"',"+m.getoopp()+","+m.getpa()+","+m.geteh()+","+m.getdd()+","+m.getfn()+","+m.getpr()+","+m.getto()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void deleteFromDB(String stid)
	{
		String query = "DELETE from marks WHERE stid='"+stid+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Marks m)
	{
		String query = "UPDATE marks SET stid='"+m.getstid()+"',oop principles= "+m.getoopp()+", package = "+m.getpa()+", exception handling = "+m.geteh()+", database design and operation= "+m.getdd()+",frame navigation = "+m.getfn()+", presentation = "+m.getpr()+",total ="+m.getto()+";";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public String[][] getAllMarks()
	{
		ArrayList<Marks> mr = new ArrayList<Marks>();
		String query = "SELECT * FROM marks;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String stid = dbc.result.getString("stid");
				double oopp = dbc.result.getDouble("oop principles");
				double pa = dbc.result.getDouble("package");
				double eh = dbc.result.getDouble("exception handling");
				double dd = dbc.result.getDouble("database design and operation");
				double fn = dbc.result.getDouble("frame navigation");
				double pr = dbc.result.getDouble("presentation");
				double to = (oopp + pa + eh + dd + fn + pr);
				
				Marks m = new Marks(stid,oopp,pa,eh,dd,fn,pr,to);
				mr.add(m);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = mr.toArray();
		String data[][] = new String [mr.size()][8];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Marks)obj[i]).getstid();
			data[i][1] = ((Marks)obj[i]).getoopp()+"";
			data[i][2] = ((Marks)obj[i]).getpa()+"";
			data[i][3] = ((Marks)obj[i]).geteh()+"";
			data[i][4] = ((Marks)obj[i]).getdd()+"";
			data[i][5] = ((Marks)obj[i]).getfn()+"";
			data[i][6] = ((Marks)obj[i]).getpr()+"";
			data[i][7] = ((Marks)obj[i]).getto()+"";
		}
		return data;
	}
	public Marks searchmarks(String stid)
	{
		Marks m = null;
		String query = "SELECT * FROM marks WHERE `stid`='"+stid+"';";     
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String sstid = dbc.result.getString("stid");
				double oopp = dbc.result.getDouble("oop principles");
				double pa = dbc.result.getDouble("package");
				double eh = dbc.result.getDouble("exception handling");
				double dd = dbc.result.getDouble("database design and operation");
				double fn = dbc.result.getDouble("frame navigation");
				double pr = dbc.result.getDouble("presentation");
				double to = dbc.result.getDouble("total");
				
				m = new Marks();
				m.setstid(sstid);
				m.setoopp(oopp);
				m.setpa(pa);
				m.seteh(eh);
				m.setdd(dd);
				m.setfn(fn);
				m.setpr(pr);
				m.setto(to);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return m;
	}
}