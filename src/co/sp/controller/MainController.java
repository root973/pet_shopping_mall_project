package co.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.sp.beans.Pet_category;
import co.sp.beans.Pet_goods;
import co.sp.service.GoodsService;

@Controller
public class MainController {
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/main")
	public String main(Model model) {
		
		List<Pet_goods> list = goodsService.allGoodsList();
		
		List<Pet_category> big_ctg = goodsService.getBigCtgInfo();
		
		for(Pet_category ctg:big_ctg) {
			
			List<Pet_goods> goods = goodsService.getMainGoodsInfo(ctg.getCtg_big_eng());
			model.addAttribute(ctg.getCtg_big_eng()+"_list", goods);
			
		}
		
		model.addAttribute("list", list);
		return "main";
	}
}	
