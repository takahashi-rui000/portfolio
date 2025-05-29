package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO extends DAO{

	public void update(int id, String loginId, String password, String name, int age, String comment) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = this.getConnection();
		pstmt = con.prepareStatement("UPDATE `book`.`person` SET `loginId`=?, `password`=?, `name`=?, `age`=?, `comment`=? WHERE  `id`=?;");
		pstmt.setString(1, loginId);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, comment);
		pstmt.setInt(6, id);
		System.out.println("更新件数：" + pstmt.executeUpdate());
        if (pstmt != null) pstmt.close();
        if (con != null) con.close();
	}
}
