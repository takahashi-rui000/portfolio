package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import address.User;

public class InsertDAO extends DAO{

	public void insert(User user) throws Exception {
		Connection con = this.getConnection();
		PreparedStatement st = con.prepareStatement("INSERT INTO person (loginId, password, name, age, comment) VALUES (?, ?, ?, ?, ?)");
		st.setString(1, user.getLoginId());
		st.setString(2, user.getPassword());
		st.setString(3, user.getName());
		st.setInt(4, user.getAge());
		st.setString(5, user.getComment());
		System.out.println(st.executeUpdate());
		st.close();
		con.close();
	}
}
