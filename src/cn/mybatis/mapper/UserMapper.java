package cn.mybatis.mapper;

import java.util.List;

import cn.mybatis.dao.UserDao;
import cn.mybatis.po.User;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByUserName(String name) throws Exception;
	
	public void insertUser(UserDao user) throws Exception;
	

}
