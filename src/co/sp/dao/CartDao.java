package co.sp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_cart;
import co.sp.mapper.CartMapper;

@Repository
public class CartDao {
	
	@Autowired
	private CartMapper cartMapper;
		
	public void insertGoodsIntoCart(Pet_cart goodsInCartBean) {
		cartMapper.insertGoodsIntoCart(goodsInCartBean);
	}
	public void updateEAintoCart(Pet_cart goodsInCartBean) {
		cartMapper.updateEaInCart(goodsInCartBean);
	}
	public List<Pet_cart> getAllGoodsintoCart(String member_id) {
		List<Pet_cart> cartBean=cartMapper.getAllGoodsintoCart(member_id);
		return cartBean;
	}
	public void deleteGoodsIntoCart(String member_id, long cart_idx) {
		cartMapper.deleteGoodsIntoCart(member_id, cart_idx);
	}
	public void resetCart(String member_id) {
		cartMapper.resetCart(member_id);
	}
	public void updateEaInCart(Pet_cart cart) {
		cartMapper.updateEaInCart(cart);
	}
	public Pet_cart getGoodsintoCart(String member_id, long cart_idx) {
		return cartMapper.getGoodsintoCart(member_id, cart_idx);
	}
	
}
