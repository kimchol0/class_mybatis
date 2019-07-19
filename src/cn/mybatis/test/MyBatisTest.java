package cn.mybatis.test;

import cn.mybatis.po.User;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

public class MyBatisTest {
	
	@Test
	public void findUserByIdTest() throws Exception{
		
		String findUserByIdTestConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream findUserByIdTestConfigurationFileInputStream = Resources.getResourceAsStream(findUserByIdTestConfigurationFileName);
		
		SqlSessionFactory findUserByIdTestSqlSessionFactory = new SqlSessionFactoryBuilder().build(findUserByIdTestConfigurationFileInputStream);	
		
		SqlSession findUserByIdTestSqlSession = findUserByIdTestSqlSessionFactory.openSession();
		
		User returnUser = findUserByIdTestSqlSession.selectOne("test.findUserById",1);
		
		System.out.println(returnUser);
		
		findUserByIdTestSqlSession.close();

		
	}
	
	
	@Test
	public void findUserByNameTest()throws Exception{
		
		String findUserByNameTestConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream findUserByNameTestConfigurationFileInputStream = Resources.getResourceAsStream(findUserByNameTestConfigurationFileName);
		
		SqlSessionFactory findUserByNameTestSqlSessionFactory = new SqlSessionFactoryBuilder().build(findUserByNameTestConfigurationFileInputStream);	
		
		SqlSession findUserByNameTestSqlSession = findUserByNameTestSqlSessionFactory.openSession();
		
		List<User> returnUserList = findUserByNameTestSqlSession.selectList("test.findUserByName","张");
		
		System.out.println(returnUserList);
		
		findUserByNameTestSqlSession.close();
	}
	
	@Test
	public void insertUserTest()throws Exception{
		
		String insertUserTestConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream insertUserTestConfigurationFileInputStream = Resources.getResourceAsStream(insertUserTestConfigurationFileName);
		
		SqlSessionFactory insertUserTestSqlSessionFactory = new SqlSessionFactoryBuilder().build(insertUserTestConfigurationFileInputStream);	
		
		SqlSession insertUserTestSqlSession = insertUserTestSqlSessionFactory.openSession();
		
		User user = new User();
		
		user.setId(40);
		user.setUsername("jack");
		user.setSex("1");
		
		insertUserTestSqlSession.insert("test.insertUser",user);
		
		insertUserTestSqlSession.commit();
		
		insertUserTestSqlSession.close();
		
	}
	
	@Test
	public void deleteUserTest()throws Exception{
		
		String deleteUserTestConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream deleteUserTestConfigurationFileInputStream = Resources.getResourceAsStream(deleteUserTestConfigurationFileName);
		
		SqlSessionFactory deleteUserTestSqlSessionFactory = new SqlSessionFactoryBuilder().build(deleteUserTestConfigurationFileInputStream);	
		
		SqlSession deleteUserTestSqlSession = deleteUserTestSqlSessionFactory.openSession();
		
		deleteUserTestSqlSession.delete("test.deleteUser", 40);
		
		deleteUserTestSqlSession.commit();
		
		deleteUserTestSqlSession.close();
		
	}
	
	@Test
	public void updateUserTest()throws Exception{
		
		String updateUserTestConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream updateUserTestConfigurationFileInputStream = Resources.getResourceAsStream(updateUserTestConfigurationFileName);
		
		SqlSessionFactory updateUserTestSqlSessionFactory = new SqlSessionFactoryBuilder().build(updateUserTestConfigurationFileInputStream);	
		
		SqlSession updateUserTestSqlSession = updateUserTestSqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("jack40");
		user.setSex("1");
		user.setId(40);
		
		updateUserTestSqlSession.update("test.updateUser",user);
		
		updateUserTestSqlSession.commit();
		
		updateUserTestSqlSession.close();
		
	}

}
