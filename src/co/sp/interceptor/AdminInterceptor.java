package co.sp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import co.sp.beans.Pet_admin;

public class AdminInterceptor  implements HandlerInterceptor {
	
	private Pet_admin adminBean;
	
	public AdminInterceptor(Pet_admin adminBean) {
		this.adminBean = adminBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		request.setAttribute("adminBean",adminBean);
		
		return true;
	}
	
}
