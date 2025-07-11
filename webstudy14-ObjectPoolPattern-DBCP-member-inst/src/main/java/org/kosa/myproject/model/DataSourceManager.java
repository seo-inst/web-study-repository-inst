package org.kosa.myproject.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource dataSource;// dbcp 구현체의 인터페이스 
	private DataSourceManager() {
		// apache tomcat 에 내장된 Database Connection Pool 객체 
		// getConnection() => 기존의 컨넥션 생성이 아니라 빌려주는 방식 
		// connection.close() => 기존에는 컨넥션 소멸인데 여기서는 반납하는 방식 
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName(DbConfig.DRIVER);
		dbcp.setUrl(DbConfig.URL);
		dbcp.setUsername(DbConfig.USER);
		dbcp.setPassword(DbConfig.PASS);
		// 추가 설정이 가능 
		dbcp.setInitialSize(20);
		dbcp.setMaxTotal(30);// 만약 설정하지 않으면 default 8 
		this.dataSource = dbcp; // BasicDataSource 는 DataSource Interface 의 하위 클래스이기 때문에 가능 
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
}






