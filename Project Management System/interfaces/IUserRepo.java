package interfaces;

import java.lang.*;
import entity.*;

public interface IUserRepo
{
	User getuser(String userid, String password);
	void insertuser(User u);
	void updateuser(User u);
	void deleteuser(String userid);
}