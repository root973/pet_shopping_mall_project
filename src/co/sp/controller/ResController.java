package co.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.sp.beans.Pet_cart;
import co.sp.service.AdminService;
import co.sp.service.CartService;
import co.sp.service.GoodsService;
import co.sp.service.MemberService;

@RestController
public class ResController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsService goodsService;
	
	//�Ϲݰ� ���̵��ߺ�üũ
	@GetMapping("/member/checkUserIdExist/{member_id}")
	public String checkUserIdExist(@PathVariable String member_id) {
		
		boolean chk = memberService.checkuserIdExist(member_id);
		
		return chk + "";
	}
	
	//������ ���̵��ߺ�üũ
	@GetMapping("/admin/checkAdminIdExist/{admin_id}")
	public String checkAdminIdExist(@PathVariable String admin_id) {
		
		boolean chk = adminService.checkAdminIdExist(admin_id);
		
		return chk + "";
	}
	
	//cart/list���� ����� ����������Ʈ�ڵ�
	@PostMapping("/cart/updateCartEa")
	public String update_ea(@RequestParam("idx_list") String idx_list,
			@RequestParam("ea_list") String ea_list,
			@RequestParam("total_list") String total_list) {
		
		String idx[] = idx_list.split(",");
		String ea[] = ea_list.split(",");
		String total[] = total_list.split(",");
		
		for(int i=0; i<idx.length; i++) {
			long idx_n = Long.parseLong(idx[i]);
			int ea_n = Integer.parseInt(ea[i]);
			long total_n = Long.parseLong(total[i]);
			
			Pet_cart cart = new Pet_cart(idx_n, "", 0, "", "", 0, ea_n, "", "", total_n);
			
			cartService.updateEaInCart(cart);
			
		}

		return "";
	}
	
	//client������ ���İ˻��� ���� ��ǰ�� ���ڿ�������
	@GetMapping(value="/goods/keyword", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String goods_keyword() {
		
		String[] key_arr = goodsService.allGoodsKeyword();
		
		Gson gson = new Gson();
		return gson.toJson(key_arr);
	}
	
	
	//������ ȸ���˻��� ���� �ڵ�
	@GetMapping(value="admin/member/keyword", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String member_keyword() {
		
		String[] key_arr = memberService.admin_getAllMemberAjax();
		
		Gson gson = new Gson();

		return gson.toJson(key_arr);
	}
	
}












