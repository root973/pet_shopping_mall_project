package co.sp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import co.sp.beans.Pet_member;

public class ClientInterceptor implements HandlerInterceptor {
	
	private Pet_member loginBean;
	
	//자동주입이 아닌 생성자로 직접 받아 세팅함
	public ClientInterceptor(Pet_member loginBean) {
		this.loginBean=loginBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("loginBean",loginBean);
		
		return true;
	}
}
