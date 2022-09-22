package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.log4j.Log4j;


@Log4j
public class DataSourceTest {
	
	@Test
	public void testConnection() throws Exception{
		
		Class<?> clz = Class.forName("oracle.jdbc.OracleDriver");
		
		System.out.println(clz);
		
		Connection Pool = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe" ,"c##spring", "spring");
		
		log.info(Pool);
		
		Pool.close();
				
	}
	
	/*
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		SqlSessionFactory session = sqlSessionFactory.openSession();
		Connection con = session
	}
	*/
	
}
