package th.ac.hcu.service;

import th.ac.hcu.bean.UserBean;
import th.ac.hcu.entity.User;

public interface UserService {

	public String userToString(String userName);
	
	public User stringToUsers(String usersString);
	
	public User getUser(String userName);
	
	public void addUser(UserBean userBean);
}
