package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import dto.UserDTO;

public class UserDAO {
	public boolean register(UserDTO userDTO) throws SQLException, NamingException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int recordCount = 0;
		try {
			con = ConnectionUtils.getConnection();
			pstmt = con.prepareStatement("insert into user(userid, password, email, phone, regcode) values(?,?,?,?,?)");
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			pstmt.setString(3, userDTO.getEmail());
			pstmt.setString(4, userDTO.getPhone());
			pstmt.setString(5, userDTO.getRegcode());
			recordCount = pstmt.executeUpdate();
		}
		finally {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return recordCount>0;
	}
}
