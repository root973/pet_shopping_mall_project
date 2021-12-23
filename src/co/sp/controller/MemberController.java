package co.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.sp.beans.Order_list;
import co.sp.beans.Pet_member;
import co.sp.beans.Pet_qna;
import co.sp.beans.Pet_review;
import co.sp.service.CartService;
import co.sp.service.GoodsService;
import co.sp.service.MemberService;
import co.sp.service.OrderListService;
import co.sp.service.QnaService;
import co.sp.service.ReviewService;
import co.sp.validator.MemberValid;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired 
	private CartService cartService;
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Resource(name = "loginBean")
	private Pet_member loginBean;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") Pet_member tempLoginUserBean,
						@RequestParam(value = "fail", defaultValue = "false") boolean fail,
						Model model) {
		
		model.addAttribute("fail", fail);
	
		return "member/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@ModelAttribute("tempLoginUserBean") Pet_member tempLoginUserBean, 
							BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "member/login";
		}
		
		memberService.getLoginUserInfo(tempLoginUserBean);
		
		if(loginBean.isMemberLogin() == true) {
			return "member/login_success";
		}else {
			return "member/login_fail";
		}
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") Pet_member joinUserBean) {
		return "member/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") Pet_member joinUserBean,
							BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "member/join";
		}
		memberService.addMemberInfo(joinUserBean);
		return "member/join_success";
	}
	//개인정보 수정 전 비번확인
	@GetMapping("/modify_cer")
	public String modify_cer() {
		
		if(loginBean.isMemberLogin()==false) {
			return "member/not_login";
		}
				
		return "member/modify_cer";
	}
	
	@PostMapping("/modify_cer_pro")
	public String modify_cer_pro(@ModelAttribute("certifyUserBean") Pet_member certifyUserBean,
								@RequestParam("cli_pass") String cli_pass) {	
		
		String BeanPass=memberService.certify(certifyUserBean);
		
		if(!BeanPass.equals(cli_pass)) {
			return "member/modify_cer_fail";
		}
		
		return "redirect:/member/modify";
	}
	
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserBean") Pet_member modifyUserBean) {
		
		memberService.getModifyUserInfo(modifyUserBean);
		
		return "member/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyUserBean") Pet_member modifyUserBean, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "member/modify";
		}
		memberService.modifyUserInfo(modifyUserBean);
		
		return "member/modify_success";
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model) {
		HashMap<Pet_review, String> myreviewmap=new HashMap<Pet_review, String>();
		HashMap<Pet_qna, String> myqnamap=new HashMap<Pet_qna, String>();
		
		List<Order_list> myorderlist=orderListService.OrderListByClient(loginBean.getMember_id());
		
		List<Pet_review> myreviewlist=reviewService.clientReviewList(loginBean.getMember_id());
		for(Pet_review list:myreviewlist) {
			long code=list.getGoods_code();
			String name=goodsService.getGoodsByCode(code).getGoods_name();
			myreviewmap.put(list,name);
		}
		
		List<Pet_qna> myqnalist=qnaService.clientQnaList(loginBean.getMember_id());
		for(Pet_qna list:myqnalist) {
			long code=list.getGoods_code();
			String name=goodsService.getGoodsByCode(code).getGoods_name();
			myqnamap.put(list,name);
		}
		
		model.addAttribute("myorderlist", myorderlist);
		model.addAttribute("myreviewmap", myreviewmap);
		model.addAttribute("myqnamap", myqnamap);
		
		return "member/mypage";
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		return "member/delete";
	}
	@PostMapping("/delete_pro")
	public String delete_pro() {
		
			cartService.resetCart(loginBean.getMember_id());
			qnaService.withdrawalQna(loginBean.getMember_id());
			reviewService.withdrawalReview(loginBean.getMember_id());
			memberService.deleteMember(loginBean.getMember_id());
			loginBean.setMemberLogin(false);

			return "member/delete_success";

	}
	
	//이 아래는 아이디찾기/비밀번호찾기
	@GetMapping("/srcId")
	public String srcId() {
		
		return "member/srcId";
	}
	
	@PostMapping("/srcId_pro")
	public String srcId_pro(@RequestParam String cli_name,
						@RequestParam String cli_email,
						Model model) {
		
		Pet_member srcMemberBean=new Pet_member();
		
		srcMemberBean.setName(cli_name);
		srcMemberBean.setEmail(cli_email);
		
		String cli_id=memberService.searchId(srcMemberBean);
		
		if(cli_id==null) {
			return "member/srcId_fail";
		}
		model.addAttribute("cli_id", cli_id);
		
		return "member/srcId_success";
	}
	
	@GetMapping("/srcPass")
	public String srcPass() {
		return "member/srcPass";
	}
	
	@PostMapping("/srcPass_pro")
	public String srcPass_pro(@RequestParam String cli_id,
						@RequestParam String cli_name,
						@RequestParam String cli_email,
						Model model) {
		
		Pet_member srcMemberBean=new Pet_member();
		
		srcMemberBean.setMember_id(cli_id);
		srcMemberBean.setName(cli_name);
		srcMemberBean.setEmail(cli_email);

		String cli_pass=memberService.searchPass(srcMemberBean);
		
		if(cli_pass==null) {
			return "member/srcPass_fail";
		}
		model.addAttribute("cli_pass", cli_pass);
		return "member/srcPass_success";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		loginBean.setMemberLogin(false);
		
		return "member/logout";
	}
	
	@GetMapping("/not_login")
	public String not_login() {
		return "member/not_login";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		MemberValid validator1 = new MemberValid();
		binder.addValidators(validator1);
	}
	

	
}
