package cn.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.mybatis.po.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory UserDaoImplSqlSessionFactory;

	public SqlSessionFactory getUserDaoImplSqlSessionFactory() {
		return UserDaoImplSqlSessionFactory;
	}

	public void setUserDaoImplSqlSessionFactory(SqlSessionFactory userDaoImplSqlSessionFactory) {
		UserDaoImplSqlSessionFactory = userDaoImplSqlSessionFactory;
	}

	public UserDaoImpl(SqlSessionFactory userDaoImplSqlSessionFactory) {
		super();
		this.UserDaoImplSqlSessionFactory = userDaoImplSqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		
		SqlSession findUserByIdSqlSession = UserDaoImplSqlSessionFactory.openSession();
		
		User returnUser = findUserByIdSqlSession.selectOne("test.findUserById",id);
		
		findUserByIdSqlSession.close();
		
		return returnUser;
		
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		
		SqlSession findUserByNameSqlSession = UserDaoImplSqlSessionFactory.openSession();
		
		List<User> returnUserList = findUserByNameSqlSession.selectList("test.findUserByName",name);
		
		System.out.println(returnUserList);
		
		findUserByNameSqlSession.close();
		
		return returnUserList;
	}

	@Override
	public void insertUser(UserDao user) throws Exception {
		
		SqlSession insertUserSqlSession = UserDaoImplSqlSessionFactory.openSession();
		
		insertUserSqlSession.insert("test.insertUser",user);
		
		insertUserSqlSession.close();

	}


}
