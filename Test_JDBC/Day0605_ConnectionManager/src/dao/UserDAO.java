package dao;

import java.util.List;

import vo.User;

public interface UserDAO {
	public int insert(User user);
	public List<User> selectAll();

}
