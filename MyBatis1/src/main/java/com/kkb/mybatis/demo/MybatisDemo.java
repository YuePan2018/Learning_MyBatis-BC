package com.kkb.mybatis.demo;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.kkb.mybatis.po.User;

public class MybatisDemo {
	
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * @Beforeע��ķ�������@Testע��ķ���֮ǰִ��
	 * 
	 * @throws Exception
	 */
	@Before
	public void init() throws Exception {
		//ָ��ȫ�������ļ�·��
		String resource = "SqlMapConfig.xml";
		//������Դ�ļ���ȫ�������ļ���ӳ���ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//���й�����ģʽ��ȥ����SqlSessionFactory����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream );
		
		//���ģʽ������23�֣������ͣ�5�����ṹ�ͣ�7������Ϊ�ͣ�11��
	}
	
	// Test: select by user id
	@Test
	public void testSelect() {
		//��SqlSessionFactory����ȥ����SqlSession���Ự��
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����sqlsession�ӿڣ�ȥʵ�����ݿ����ɾ�Ĳ�������ڶ���parameter����id
		User user = sqlSession.selectOne("test.findUserById", 10);
		
		System.out.println(user);
		//�ͷ���Դ
		sqlSession.close();
	}
}
