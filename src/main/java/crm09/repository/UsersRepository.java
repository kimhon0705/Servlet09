package crm09.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import crm09.config.MySQLConfig;
import crm09.utils.Md5Helper;

public class UsersRepository {
	public int save(String email, String password, int roleId, String fullname, String phone){
		
		int count = 0;
		String query = "INSERT INTO users(email, password, id_role, fullname, phone)\r\n"
				+ "VALUES (?,?,?,?,?)";
		
		Connection connection = MySQLConfig.getConnection()
;
		try {
			PreparedStatement statement =  connection.prepareStatement(query);
			statement.setString(1, email);
		    statement.setString(2, Md5Helper.getMd5(password));
		    statement.setInt(3, roleId);
		    statement.setString(4, fullname);
		    statement.setString(5, phone);
		    
			count = statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("lỗi save" + e.getMessage());
		}
		return count;
	}
}
