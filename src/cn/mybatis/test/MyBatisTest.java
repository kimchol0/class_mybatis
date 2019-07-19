package cn.mybatis.test;

import org.junit.jupiter.api.Test;

import cn.mybatis.po.User;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {
	
	@Test
	public void findUserByIdTest() throws Exception{
		
		String mybatisConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream mybatisConfigurationFileInputStream = Resources.getResourceAsStream(mybatisConfigurationFileName);
		
		SqlSessionFactory mybatisSqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigurationFileInputStream);	
		
		SqlSession mybatisSqlSession = mybatisSqlSessionFactory.openSession();
		
		User returnUser = mybatisSqlSession.selectOne("test.findUserById",1);
		
		System.out.println(returnUser);
		
		mybatisSqlSession.close();
	}
	
	@Test
	public void findUserByNameTest()throws Exception{
		
		String mybatisConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream mybatisConfigurationFileInputStream = Resources.getResourceAsStream(mybatisConfigurationFileName);
		
		SqlSessionFactory mybatisSqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigurationFileInputStream);	
		
		SqlSession mybatisSqlSession = mybatisSqlSessionFactory.openSession();
		
		List<User> returnUserList = mybatisSqlSession.selectList("test.findUserByName","张");
		
		System.out.println(returnUserList);
		
		mybatisSqlSession.close();
	}
	
	@Test
	public void insertUserTest()throws Exception{
		
		String mybatisConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream mybatisConfigurationFileInputStream = Resources.getResourceAsStream(mybatisConfigurationFileName);
		
		SqlSessionFactory mybatisSqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigurationFileInputStream);	
		
		SqlSession mybatisSqlSession = mybatisSqlSessionFactory.openSession();
		
		User user = new User();
		
		user.setId(40);
		user.setUsername("jack");
		user.setSex("1");
		
		mybatisSqlSession.insert("test.insertUser",user);
		
		mybatisSqlSession.commit();
		
		mybatisSqlSession.close();
		
	}
	
	@Test
	public void deleteUserTest()throws Exception{
		
		String mybatisConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream mybatisConfigurationFileInputStream = Resources.getResourceAsStream(mybatisConfigurationFileName);
		
		SqlSessionFactory mybatisSqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigurationFileInputStream);	
		
		SqlSession mybatisSqlSession = mybatisSqlSessionFactory.openSession();
		
		mybatisSqlSession.delete("test.deleteUser", 40);
		
		mybatisSqlSession.commit();
		
		mybatisSqlSession.close();
		
	}
	
	@Test
	public void updateUserTest()throws Exception{
		
		String mybatisConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream mybatisConfigurationFileInputStream = Resources.getResourceAsStream(mybatisConfigurationFileName);
		
		SqlSessionFactory mybatisSqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigurationFileInputStream);	
		
		SqlSession mybatisSqlSession = mybatisSqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("jack40");
		user.setSex("1");
		user.setId(40);
		
		mybatisSqlSession.update("test.updateUser",user);
		
		mybatisSqlSession.commit();
		
		mybatisSqlSession.close();
		
	}

}
