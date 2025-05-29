package dao;

import java.sql.Connection;

import org.apache.tomcat.jdbc.pool.DataSource;



public class DAO {
	static DataSource ds;
	
	public Connection getConnection() throws Exception {
		if(ds == null) {
			ds = new DataSource();
			ds.setUrl("jdbc:mariadb://localhost:3306/book");
            ds.setDriverClassName("org.mariadb.jdbc.Driver");
            ds.setUsername("root");
            ds.setPassword("root");
		}
		return ds.getConnection();
	}
}
