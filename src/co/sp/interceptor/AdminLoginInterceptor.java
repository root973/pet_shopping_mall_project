package co.sp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import co.sp.beans.Pet_admin;

public class AdminLoginInterceptor implements HandlerInterceptor{
	
	private Pet_admin adminBean;
	
	public AdminLoginInterceptor(Pet_admin adminBean) {
		this.adminBean = adminBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(adminBean.isAdminLogin()==false) {
			String contextPath=request.getContextPath();
			response.sendRedirect(contextPath+"/admin/not_login");
			return false;
		}
		
		return true;
	}

}
