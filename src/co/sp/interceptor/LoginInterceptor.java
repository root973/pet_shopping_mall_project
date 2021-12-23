package co.sp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import co.sp.beans.Pet_member;

//로그인 인터셉터
public class LoginInterceptor implements HandlerInterceptor{
		
	private Pet_member loginBean;
	
	public LoginInterceptor(Pet_member loginBean) {
		this.loginBean=loginBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(loginBean.isMemberLogin() == false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");
			return false;
		}
		return true;
	}
}
