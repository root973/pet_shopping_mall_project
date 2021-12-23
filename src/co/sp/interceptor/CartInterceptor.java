package co.sp.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import co.sp.beans.Pet_cart;
import co.sp.beans.Pet_member;
import co.sp.service.CartService;

public class CartInterceptor implements HandlerInterceptor{
	
	private Pet_member loginBean;
	private CartService cartService;
	
	public CartInterceptor(Pet_member loginBean, CartService cartService) {
		this.loginBean=loginBean;
		this.cartService=cartService;
	}
	
	//구현해야 하는 것
	//장바구니 가져오기
	//장바구니에 상품 없으면 경고창
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(loginBean.isMemberLogin()==false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/member/not_login");
			return false;
		}
		List<Pet_cart> cartBean=cartService.getAllGoodsintoCart(loginBean.getMember_id());
		
		if(cartBean.isEmpty()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/cart/empty_cart");
			return false;
		}
		return true;
	}

}
