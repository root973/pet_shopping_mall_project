package co.sp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.sp.beans.Order_list;
import co.sp.beans.Pet_cart;
import co.sp.beans.Pet_member;
import co.sp.service.CartService;
import co.sp.service.MemberService;
import co.sp.service.OrderListService;

@Controller
@RequestMapping("/order")
public class OrderListController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private MemberService memberService;
	
	@Resource(name = "loginBean")
	private Pet_member loginBean;
	
	@GetMapping("order_form")
	public String order_form(@RequestParam("member_id") String member_id,
							@RequestParam("cart_list") String cart_list,
							Model model) {
	
		List<Pet_cart> pet_cart = new ArrayList<Pet_cart>();
		
		String [] idx_list = cart_list.split(",");
		
		for(String i:idx_list) {
			long cart_idx = Long.parseLong(i);
			pet_cart.add(cartService.getGoodsintoCart(member_id, cart_idx));
		}
		
		model.addAttribute("cart_list", cart_list);
		model.addAttribute("pet_cart", pet_cart);
		
		return "order/order_form";
	}
	
	@PostMapping("order_ver")
	public String order_ver(@RequestParam("cart_list")String cart_list,
							@RequestParam("member_id") String member_id,
							@RequestParam("name") String name,
							@RequestParam("zip_code") String zip_code,
							@RequestParam("address") String address,
							@RequestParam("address_detail") String address_detail,
							@RequestParam("memo") String memo,
							@ModelAttribute("insertOrderBean") Order_list insertOrderBean,
							Model model) {
		
		List<Pet_cart> pet_cart = new ArrayList<Pet_cart>();
		
		String [] idx_list = cart_list.split(",");
		
		for(String i:idx_list) {
			long cart_idx = Long.parseLong(i);
			pet_cart.add(cartService.getGoodsintoCart(member_id, cart_idx));
		}
		
		Date date=new Date();
		SimpleDateFormat checkDate=new SimpleDateFormat("yyyy-MM-dd");
		String checkD=checkDate.format(date);
		
		
		
		for(Pet_cart cart : pet_cart) {
			SimpleDateFormat numHead=new SimpleDateFormat("yyyyMMdd");
			String numH = numHead.format(date);
			String numB = Integer.toString(orderListService.cntOrderListByDate(checkD)+1);
			String numT = Long.toString(cart.getGoods_code());
			
			String order_num=numH+"-"+numB+"-"+numT;
			
			insertOrderBean.setOrder_num(order_num);
			insertOrderBean.setMember_id(loginBean.getMember_id());
			insertOrderBean.setGoods_code(cart.getGoods_code());
			insertOrderBean.setName(name);
			insertOrderBean.setGoods_name(cart.getGoods_name());
			insertOrderBean.setGoods_option1(cart.getOption1());
			insertOrderBean.setGoods_option2(cart.getOption2());
			insertOrderBean.setEa(cart.getEa());
			insertOrderBean.setTotal_price(cart.getEa()*cart.getPrice());
			insertOrderBean.setPhone(loginBean.getPhone());
			insertOrderBean.setAddress(zip_code+"/"+address+" "+address_detail);
			insertOrderBean.setMemo(memo);
			
			orderListService.insertOrder(insertOrderBean);
			cartService.deleteGoodsIntoCart(member_id, cart.getCart_idx());
			
			int point = (int) ((cart.getEa()*cart.getPrice())*0.03);
			System.out.println(point);
			//구매시 포인트 추가
			memberService.client_modifyPoint(point, member_id);
			
		}
		return "order/order_complete";
	}
	
}
