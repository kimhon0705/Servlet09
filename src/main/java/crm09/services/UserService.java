package crm09.services;

import java.util.List;

import crm09.entity.Roles;
import crm09.repository.RolesRepository;
import crm09.repository.UsersRepository;

public class UserService {
	
	private RolesRepository rolesRepository = new RolesRepository();
	private UsersRepository usersRepository = new UsersRepository();
	
	public List<Roles>getAllRole(){
		return rolesRepository.findAll();
	}
	
	public boolean insertUser(String email, String password, int roleId, String fullname, String phone) {
		return usersRepository.save(email, password, roleId, fullname, phone)>0;
	}
}
