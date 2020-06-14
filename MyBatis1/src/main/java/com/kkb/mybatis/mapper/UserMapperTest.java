package com.kkb.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.kkb.mybatis.po.User;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		//ָ��ȫ�������ļ�·��
		String resource = "SqlMapConfig.xml";
		//������Դ�ļ���ȫ�������ļ���ӳ���ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//���й�����ģʽ��ȥ����SqlSessionFactory����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );
	}
	
	//��Spring����֮����Ҫ��IoC������ȥ������������
	//SqlSessionFactory����/MapperFactoryBean/MapperScannerConfigurer
	@Test
	public void testFindUserById() throws Exception {
		//����UserMapper����sqlSession��
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//��Ҫ���Ĳ������Ǳ������Mapper�ӿ�
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//����UserMapper�����findUserById
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

/*	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}*/

}
