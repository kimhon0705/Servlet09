package crm09.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import crm09.config.MySQLConfig;
import crm09.entity.Roles;

public class RolesRepository {
	public List<Roles> findAll(){
		List<Roles> listRole = new ArrayList<Roles>();
		
		String query = "SELECT * FROM roles";
		
		Connection connection = MySQLConfig.getConnection()
;
		try {
			PreparedStatement statement =  connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				Roles roles = new Roles();
				roles.setId(resultSet.getInt("id"));
				roles.setName(resultSet.getString("name"));
				
				listRole.add(roles);
			}
		} catch (Exception e) {
			System.out.println("lỗi findAll" + e.getMessage());
		}
		return listRole;
	}
}
