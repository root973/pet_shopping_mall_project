package co.sp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sp.beans.Pet_cart;
import co.sp.beans.Pet_member;
import co.sp.dao.CartDao;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	@Resource(name="loginBean")
	private Pet_member loginBean;
	

	public void getAllInfo(List<Pet_cart> cartBean) {
		
	}

	public void insertGoodsIntoCart(Pet_cart cart) {
		cartDao.insertGoodsIntoCart(cart);
		
	}

	public List<Pet_cart> getAllGoodsintoCart(String member_id) {
		return cartDao.getAllGoodsintoCart(member_id);
	}

	public void deleteGoodsIntoCart(String member_id, long cart_idx) {
		cartDao.deleteGoodsIntoCart(member_id, cart_idx);
	}

	public void resetCart(String member_id) {
		cartDao.resetCart(member_id);
	}

	public void updateEaInCart(Pet_cart cart) {
		cartDao.updateEaInCart(cart);
		
	}

	public Pet_cart getGoodsintoCart(String member_id, long cart_idx) {
		return cartDao.getGoodsintoCart(member_id, cart_idx);
	}
}
