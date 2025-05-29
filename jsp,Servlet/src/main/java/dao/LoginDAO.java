package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import address.User;

public class LoginDAO extends DAO{

	public User login(String loginId, String password) throws Exception {
		List<User> list = new ArrayList<>();
		Connection con = this.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM person");
		ResultSet rs = st.executeQuery();
		User user = null;
		
		while (rs.next()) {
			if (loginId.equals(rs.getString("loginId")) && password.equals(rs.getString("password"))) {
				user =  new User(rs.getInt("id"), rs.getString("loginId"), rs.getString("password"),rs.getString("name"), rs.getInt("age"), "");
				break;
			}
		}
		st.close();
		con.close();
		return user;
	}
}
