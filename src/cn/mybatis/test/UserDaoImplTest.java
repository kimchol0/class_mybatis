package cn.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.mybatis.dao.UserDao;
import cn.mybatis.dao.UserDaoImpl;
import cn.mybatis.po.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlsessionFactory;
	
	@BeforeEach
	public void setup() throws Exception {
		
		String ConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream ConfigurationFileInputStream = Resources.getResourceAsStream(ConfigurationFileName);
		
		sqlsessionFactory = new SqlSessionFactoryBuilder().build(ConfigurationFileInputStream);	
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		UserDao testFindUserByIduserdao = new UserDaoImpl(sqlsessionFactory);
		
		User returnUser = testFindUserByIduserdao.findUserById(1);
		
		System.out.println(returnUser);
		
	}
	
}
