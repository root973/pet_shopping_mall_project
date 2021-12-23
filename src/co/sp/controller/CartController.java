package co.sp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.sp.beans.Pet_cart;
import co.sp.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	// cart url로 이동하면 무조건 리스트페이지로 맵핑
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String str(HttpServletRequest request) {

		return "redirect:/list";
	}
	
	//장바구니담기
	@PostMapping("/add_pro")
	public String cart_add(@RequestParam("member_id") String member_id,
			@RequestParam("goods_code") long goods_code,
			@RequestParam("goods_name") String goods_name,
			@RequestParam("img_url") String img_url,
			@RequestParam("price") long price,
			@RequestParam("option_1") String option_1,
			@RequestParam("option_2") String option_2,
			@RequestParam("ea") int ea) {
		
		long total = price*ea;
		
		Pet_cart cart = new Pet_cart(0, member_id, goods_code, goods_name, img_url, price, ea, option_1, option_2, total);
		
		cartService.insertGoodsIntoCart(cart);
		
		return "cart/add_success";
	}
	
	//구매하기
	@PostMapping("/add_pro_cart")
	public String cart_add_go(@RequestParam("member_id") String member_id,
			@RequestParam("goods_code") long goods_code,
			@RequestParam("goods_name") String goods_name,
			@RequestParam("img_url") String img_url,
			@RequestParam("price") long price,
			@RequestParam("option_1") String option_1,
			@RequestParam("option_2") String option_2,
			@RequestParam("ea") int ea) {
		
		long total = price*ea;
		
		Pet_cart cart = new Pet_cart(0, member_id, goods_code, goods_name, img_url, price, ea, option_1, option_2, total);
		
		cartService.insertGoodsIntoCart(cart);
		
		
		return "cart/go_cart";
	}
	
	@GetMapping("/list")
	public String cart_list(@RequestParam("member_id") String member_id, 
							Model model) {
		
		List<Pet_cart> cart_list = cartService.getAllGoodsintoCart(member_id);
		
		
		long total_price = 0;
		int total_cnt = 0;
		for(Pet_cart cart:cart_list) {
			total_price += cart.getTotal();
			total_cnt += cart.getEa();
		}
		
		model.addAttribute("cart_list", cart_list);
		model.addAttribute("total_price", total_price);
		model.addAttribute("total_cnt", total_cnt);
		return "cart/list";
	}
	
	@PostMapping("/delete_checked")
	public String cart_delete_checked(@RequestParam("member_id") String member_id,
					@RequestParam("idx_check") String idx_check) {
		
	
		String[] idx_list = idx_check.split(",");
		for(String i:idx_list) {
			cartService.deleteGoodsIntoCart(member_id, Long.parseLong(i));
		}
		
		
		return "cart/delete_success";
	}
	
	@PostMapping("/delete_all")
	public String cart_delete_all(@RequestParam("member_id") String member_id) {
		
		cartService.resetCart(member_id);
		
		return "cart/delete_all_success";
	}
	
	@GetMapping("/empty_cart")
	public String empty_cart() {
		return "cart/empty_cart";
	}
	
	
	
	
}
