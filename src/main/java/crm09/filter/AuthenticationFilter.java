package crm09.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
										//urlPatterns: Filter sẽ kích hoạt khi người dùng gọi đường dẫn
@WebFilter(filterName="authentication", urlPatterns = {"/user-add","/user"})
public class AuthenticationFilter extends HttpFilter{
	
	/**
	 * Bài tập về nhà:
	 * - /user-add: Phải có quyền ADMIN mới truy cập được
	 * - /user: chỉ cần đăng nhập là truy cập được
	 * 
	 * - Phải xài filter
	 */
	
	
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//code chạy ở đây
		boolean signIn = false;
		Cookie[] cookie = req.getCookies();
		String role = "";
		
		for(Cookie cookie2 : cookie){
			String name = cookie2.getName();
			String value = cookie2.getValue();
			if(name.equals("role")) {
				role = value;
			}
		}
		
		if (signIn) {
            if (role.equals("ADMIN")) {
                System.out.println("Bạn là admin và có quyền truy cập của admin");
                chain.doFilter(req, res);
            } else {
            	System.out.println("Bạn không có quyền truy cập của Admin");
            	res.sendRedirect("login");
            }
        } else {
            res.sendRedirect("login");
        }
		
		
	}
}
