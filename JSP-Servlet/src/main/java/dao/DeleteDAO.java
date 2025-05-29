package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO extends DAO{
	
	public boolean delete(String id) throws Exception {
		boolean isDelete = false;
		Connection con = this.getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM `book`.`person` WHERE  `id`=?;");
		st.setString(1, id);
		if(st.executeUpdate() >= 1) {
			isDelete = true;
		}
		st.close();
		con.close();
		return isDelete;
	}
}
