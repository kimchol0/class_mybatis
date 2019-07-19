package cn.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.mybatis.mapper.UserMapper;
import cn.mybatis.po.User;
import cn.mybatis.po.UserCustom;
import cn.mybatis.po.UserQueryVo;

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
	
	@Test
	public void testFindUserList() throws Exception {
		
		SqlSession testFindUserListsqlSession = UserMapperTestsqlsessionFactory.openSession();
		
		UserMapper returnUserListMapper = testFindUserListsqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张三");
		
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> returnUserList = returnUserListMapper.findUserList(userQueryVo);
		
		System.out.println(returnUserList);
		
		testFindUserListsqlSession.close();
		
	}
	
	
	
}
