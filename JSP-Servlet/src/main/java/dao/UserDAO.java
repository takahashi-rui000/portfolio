package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import address.User;

public class UserDAO extends DAO{
	
	public List<User> search(String keyword) throws Exception {
		List<User> list = new ArrayList<>();
		Connection con = this.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM person WHERE name LIKE ?;");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			User u = new User();
			u.setId(Integer.parseInt(rs.getString("id")));
			u.setLoginId(rs.getString("loginId"));
			u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setAge(Integer.parseInt(rs.getString("age")));
			u.setComment(rs.getString("comment"));
			list.add(u);
		}
		st.close();
		con.close();
		
		return list;
	}
	
	public User getUser(int id) throws Exception{
		Connection con = this.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM person WHERE id = ?;");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		User u = new User();
	    if (rs.next()) {
	        u = new User();
	        u.setId(rs.getInt("id"));
	        u.setLoginId(rs.getString("loginId"));
	        u.setPassword(rs.getString("password"));
	        u.setName(rs.getString("name"));
	        u.setAge(rs.getInt("age"));
	        u.setComment(rs.getString("comment"));
	    }
		
		st.close();
		con.close();
		return u;
	}
}
