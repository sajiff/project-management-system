package interfaces;

import java.lang.*;
import entity.*;

public interface IFacultyRep
{
	public void insertInDB(Faculty f);
	public void deleteFromDB(String fid);
	public void updateInDB(Faculty f);
	public String[][] getAllStudent();
}