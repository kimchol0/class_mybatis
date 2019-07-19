package cn.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.mybatis.mapper.UserMapper;
import cn.mybatis.po.User;

public class UserMapperTest {
	
	private SqlSessionFactory UserMapperTestsqlsessionFactory;

	@BeforeEach
	public void setup() throws Exception {
		
		String UserMapperTestConfigurationFileName = "SqlMapConfig.xml";
		
		InputStream UserMapperTestConfigurationFileInputStream = Resources.getResourceAsStream(UserMapperTestConfigurationFileName);
		
		UserMapperTestsqlsessionFactory = new SqlSessionFactoryBuilder().build(UserMapperTestConfigurationFileInputStream);	
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		SqlSession testFindUserByIdsqlSession = UserMapperTestsqlsessionFactory.openSession();
		
		UserMapper returnuserMapper = testFindUserByIdsqlSession.getMapper(UserMapper.class);
		
		User returnUser = returnuserMapper.findUserById(10);
		
		System.out.println(returnUser);
		
		testFindUserByIdsqlSession.close();
		
	}
	
}
