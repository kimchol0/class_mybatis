package cn.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import cn.mybatis.dao.UserDao;
import cn.mybatis.dao.UserDaoImpl;
import cn.mybatis.po.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory UserDaoImplTestsqlsessionFactory;
	
	@Before(value = "")
	public void setup() throws Exception {
		
		String setupConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream setupConfigurationFileInputStream = Resources.getResourceAsStream(setupConfigurationFileName);
		
		SqlSessionFactory setupSqlSessionFactory = new SqlSessionFactoryBuilder().build(setupConfigurationFileInputStream);	
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		UserDao testFindUserByIduserdao = new UserDaoImpl(UserDaoImplTestsqlsessionFactory);
		
		User returnUser = testFindUserByIduserdao.findUserById(1);
		
		System.out.println(returnUser);
		
	}
	
}
