package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConnection {
	
	public static Connection provideConnection() {
		
		ApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ConnectionData cd = ctx.getBean("connectionData",ConnectionData.class);

		Connection con = null;
		
		try {
			Class.forName(cd.getDname());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(cd.getUrl(), cd.getUname(), cd.getPass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((AnnotationConfigApplicationContext)ctx).close();
		
		return con;
	}


}
