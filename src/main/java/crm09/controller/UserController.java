package crm09.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm09.entity.Roles;
import crm09.services.UserService;

@WebServlet(name="usercontroller", urlPatterns = "/user-add")
public class UserController extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Roles> listRole = userService.getAllRole();
		req.setAttribute("listRoles", listRole);
		
		
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		int roleId = Integer.parseInt(req.getParameter("roleId"));
		
		boolean isSuccess = userService.insertUser(email, password, roleId, fullname, phone);
		

		List<Roles> listRole = userService.getAllRole();
		req.setAttribute("listRoles", listRole);
		
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}
}
