package com.cloud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	@Test
	public void testConnection() throws Exception {
		Class<?> clz = Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println(clz);// 드라이버 이름
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://@localhost:3306","jweb","54321");
		
		log.info(con);
		con.close();
	}
}
