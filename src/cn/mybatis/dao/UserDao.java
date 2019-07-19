package cn.mybatis.dao;

import java.util.List;

import cn.mybatis.po.User;

public interface UserDao {
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public void insertUser(UserDao user) throws Exception;
	
}
