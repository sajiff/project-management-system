package interfaces;

import entity.*;
import java.lang.*;

public interface IStudentRep
{
	void insertStudent(Student st);
	void updateStudent(Student st);
	void deleteStudent(String stid);
	public String[][] getallstudent();
	public Student searchstudent(String stid);
}