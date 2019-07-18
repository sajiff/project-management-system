package interfaces;


import java.lang.*;
import entity.*;

public interface IMarksrepo
{
	public void insertInDB(Marks m);
	public void deleteFromDB(String stid);
	public void updateInDB(Marks m);
	public Marks searchmarks(String stid);
	public String[][] getAllMarks();
}