package com.imcs.JdbcEmployee;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyDataSourceFactory {
	public static BasicDataSource getMySqlDataSource() {
		Properties prop = new Properties();
		BasicDataSource mysqlDS = null;
		try (FileInputStream fis = new FileInputStream("db.properties")) {
			mysqlDS = new BasicDataSource();
			prop.load(fis);
			mysqlDS.setDriverClassName(prop.getProperty("DRIVER_CLASS"));
			mysqlDS.setUrl(prop.getProperty("URL"));
			mysqlDS.setUsername(prop.getProperty("USERNAME"));
			mysqlDS.setPassword(prop.getProperty("PASSWORD"));
			return mysqlDS;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
