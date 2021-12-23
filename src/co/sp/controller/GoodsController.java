package co.sp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.sp.beans.Page;
import co.sp.beans.Pet_category;
import co.sp.beans.Pet_goods;
import co.sp.beans.Pet_qna;
import co.sp.beans.Pet_review;
import co.sp.service.GoodsService;
import co.sp.service.QnaService;
import co.sp.service.ReviewService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private QnaService qnaService;

	@GetMapping("/detail")
	public String goods_detail(@RequestParam("goods_code") long goods_code, 
								@RequestParam(value = "page_q", defaultValue = "1") int page_q,
								@RequestParam(value = "page_r", defaultValue = "1") int page_r,
								Model model) {

		Pet_goods goods = goodsService.getGoodsInfo(goods_code);

		String[] option_1 = goods.getOption_1().split("[|]");
		String[] option_2 = goods.getOption_2().split("[|]");
		String[] detail_img_url = goods.getDetail_img_url().split("[|]");

		//qna페이징
		List<Pet_qna> qnaList = qnaService.getAllQnaBygoods(goods_code, page_q);
		Page pageBean_q = qnaService.getQnaCntBygoods(goods_code, page_q);
		model.addAttribute("pageBean_q", pageBean_q);
		
		model.addAttribute("page_q", page_q);
		
		
		//review페이징
		List<Pet_review> reviewList = reviewService.getAllReviewByGoods(goods_code, page_r);
		Page pageBean_r = reviewService.getReviewCntBygoods(goods_code, page_r);
		model.addAttribute("pageBean_r", pageBean_r);
		
		model.addAttribute("page_r", page_r);
		
		
		model.addAttribute("goods", goods);
		model.addAttribute("option_1", option_1);
		model.addAttribute("option_2", option_2);
		model.addAttribute("detail_img_url", detail_img_url);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("reviewList", reviewList);

		return "goods/detail";
	}

	@GetMapping("/main_list")
	public String goods_main_list(@RequestParam("big_ctg") String big_ctg, Model model) {

		model.addAttribute("big_ctg", big_ctg);

		ArrayList<List<Pet_goods>> list = new ArrayList<List<Pet_goods>>();

		List<Pet_category> small_ctg = goodsService.getSmallCtgInfo(big_ctg);

		model.addAttribute("small_ctg", small_ctg);

		for (Pet_category ctg : small_ctg) {

			List<Pet_goods> goods = goodsService.getBigCtgGoodsInfo(ctg.getCtg_small_eng());
			list.add(goods);

		}

		model.addAttribute("list", list);

		return "goods/main_list";
	}

	@GetMapping("/sub_list")
	public String goods_sub_list(@RequestParam("big_ctg") String big_ctg,
			@RequestParam(value = "small_ctg", defaultValue = "") String small_ctg,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "option", defaultValue = "none") String option, Model model) {

		model.addAttribute("big_ctg", big_ctg);
		model.addAttribute("small_ctg", small_ctg);

		List<Pet_category> s_ctg = goodsService.getSmallCtgInfo(big_ctg);
		model.addAttribute("s_ctg", s_ctg);

		model.addAttribute("page", page);

		if (small_ctg.equals("all")) {

			model.addAttribute("s_ctg_ko", "전체");

			Page pageBean = goodsService.getAllSmallCtgGoodsCnt(page, big_ctg);
			model.addAttribute("pageBean", pageBean);

			if (option.equals("none")) {
				List<Pet_goods> goods_list = goodsService.getAllSmallCtgGoodsInfo(big_ctg, page);
				model.addAttribute("goods_list", goods_list);
				model.addAttribute("option", option);
			} else {
				List<Pet_goods> goods_list = goodsService.getAllSmallCtgGoodsInfoByOption(big_ctg, page, option);
				model.addAttribute("goods_list", goods_list);
				model.addAttribute("option", option);
			}
		} else {

			String s_ctg_ko = goodsService.getSmallCtgKoName(small_ctg);
			model.addAttribute("s_ctg_ko", s_ctg_ko);

			Page pageBean = goodsService.getSmallCtgGoodsCnt(page, big_ctg, small_ctg);
			model.addAttribute("pageBean", pageBean);

			if (option.equals("none")) {
				List<Pet_goods> goods_list = goodsService.getSmallCtgGoodsInfo(big_ctg, small_ctg, page);
				model.addAttribute("goods_list", goods_list);
				model.addAttribute("option", option);
			} else {
				List<Pet_goods> goods_list = goodsService.getSmallCtgGoodsInfoByOption(big_ctg, small_ctg, page,
						option);
				model.addAttribute("goods_list", goods_list);
				model.addAttribute("option", option);
			}

		}

		return "goods/sub_list";
	}

	// 이 아래는 리뷰, qna 불러오기
	@PostMapping("/reg_review")
	public String reg_review(@RequestParam("goods_code") long goods_code,
							@RequestParam("r_member_id") String r_member_id, 
							@RequestParam("r_content") String r_content, 
							@ModelAttribute("regReviewBean") Pet_review regReviewBean,
							Model model) {
		
		if(r_content.length()>300 || r_content.length()<1) {
			return "goods/re_fail";
		}
		
		regReviewBean.setGoods_code(goods_code);
		regReviewBean.setMember_id(r_member_id);
		regReviewBean.setContent(r_content);
		regReviewBean.setContent_reply("");

		model.addAttribute("goods_code", goods_code);
		reviewService.insertReview(regReviewBean);

		return "/goods/re_success";
	}

	@PostMapping("/reg_qna")
	public String reg_qna(@RequestParam("goods_code") long goods_code,
						@RequestParam("q_member_id") String q_member_id,
						@RequestParam("q_content") String q_content,
						@Valid @ModelAttribute("regQnaBean") Pet_qna regQnaBean,
						Model model) {
		
		if(q_content.length()>300 || q_content.length()<1) {
			return "goods/qna_fail";
		}
		
		regQnaBean.setGoods_code(goods_code);
		regQnaBean.setMember_id(q_member_id);
		regQnaBean.setQ_content(q_content);
		regQnaBean.setA_content("");

		model.addAttribute("goods_code", goods_code);
		qnaService.insertQna(regQnaBean);

		return "/goods/qna_success";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword")String keyword, Model model) {
		
		Pet_goods goods = goodsService.getGoodsByName(keyword);
		
		model.addAttribute("goods", goods);
		
		return "/goods/search";
	}

}
