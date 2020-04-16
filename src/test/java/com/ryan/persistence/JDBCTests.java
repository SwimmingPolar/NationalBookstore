package com.ryan.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConnection() {
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@nationalbookstore.cl0h4wfzfqxz.ap-northeast-2.rds.amazonaws.com:1521:ORCL","admin","rkskekfk1")){
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
	
}
