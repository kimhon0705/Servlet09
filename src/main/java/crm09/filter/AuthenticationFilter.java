package crm09.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
										//urlPatterns: Filter sẽ kích hoạt khi người dùng gọi đường dẫn
@WebFilter(filterName="authentication", urlPatterns = {"/user-add"})
public class AuthenticationFilter extends HttpFilter{
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("loi");
		
		//Cho phép đi tiếp
		chain.doFilter(req, res);
	}
}
