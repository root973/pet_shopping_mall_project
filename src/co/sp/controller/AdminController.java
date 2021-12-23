package co.sp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.sp.beans.Order_list;
import co.sp.beans.Page;
import co.sp.beans.Pet_admin;
import co.sp.beans.Pet_event;
import co.sp.beans.Pet_goods;
import co.sp.beans.Pet_member;
import co.sp.beans.Pet_qna;
import co.sp.beans.Pet_review;
import co.sp.service.AdminService;
import co.sp.service.BoardService;
import co.sp.service.CartService;
import co.sp.service.GoodsService;
import co.sp.service.MemberService;
import co.sp.service.OrderListService;
import co.sp.service.QnaService;
import co.sp.service.ReviewService;

@Controller
@PropertySource("/WEB-INF/properties/path.properties")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private OrderListService orderListService;

	@Autowired
	private QnaService qnaService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private BoardService boardService;

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CartService cartService;

	@Value("${goods.img.path}")
	private String goods_img_path;

	@Value("${event.img.path}")
	private String event_img_path;

	@Resource(name = "adminBean")
	private Pet_admin adminBean;

	// admin url占쏙옙 占싱듸옙占싹몌옙 占쏙옙占쏙옙占쏙옙 占싸깍옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String str(HttpServletRequest request) {

		return "redirect:/admin/login";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") Pet_admin tempLoginUserBean,
			@RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {

		model.addAttribute("fail", fail);

		return "admin/login";
	}

	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") Pet_admin tempLoginUserBean,
			BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "admin/login";
		}

		adminService.getLoginAdminInfo(tempLoginUserBean);

		if (adminBean.isAdminLogin() == true) {
			return "admin/login_success";
		} else {
			return "admin/login_fail";
		}
	}

	@GetMapping("/logout")
	public String logout() {

		adminBean.setAdminLogin(false);

		return "admin/logout";
	}

	@GetMapping("/not_login")
	public String not_login() {

		return "admin/not_login";
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싱듸옙
	@GetMapping("/main")
	public String main(Model model) {
		
		List<Pet_review> reviewList = reviewService.getAdminMainReviewList();
		List<Pet_qna> qnaList = qnaService.getAdminMainQnaList();
		List<Order_list> orderList = orderListService.getAdminMainOrderList();
		List<Pet_goods> goodsList = goodsService.getAdminMainGoodsList();
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("orderList", orderList);
		model.addAttribute("goodsList", goodsList);
		
		
		return "admin/main";
	}

	// 占쏙옙占쏙옙占쌘듸옙占쏙옙占쏙옙占쏙옙占�
	@GetMapping("/admin_mem/add")
	public String admin_add(@ModelAttribute("addAdminBean") Pet_admin addAdminBean) {

		return "admin/admin_mem/add";
	}

	// 占쏙옙占쏙옙占쌘듸옙占�
	@PostMapping("/admin_mem/add_pro")
	public String admin_add_pro(@Valid @ModelAttribute("addAdminBean") Pet_admin addAdminBean, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "admin/admin_mem/add";
		}

		adminService.addAdminInfo(addAdminBean);

		return "admin/admin_mem/add_success";
	}

	// 占쏙옙占쏙옙占쌘쇽옙占쏙옙,占쏙옙占쏙옙 占쌉쏙옙占쏙옙
	@GetMapping("/admin_mem/list")
	public String admin_list(Model model) {

		List<Pet_admin> admin_list = adminService.getAllAdminInfo();

		model.addAttribute("admin_list", admin_list);

		return "admin/admin_mem/list";
	}

	// 占쏙옙占쏙옙占쌘쇽옙占쏙옙, 占쏙옙占쏙옙占쏙옙
	@GetMapping("/admin_mem/modify")
	public String admin_modify(@RequestParam("admin_id") String admin_id, Model model) {

		Pet_admin admin = adminService.getAdminInfo(admin_id);

		model.addAttribute("admin", admin);

		return "admin/admin_mem/modify";
	}

	@PostMapping("/admin_mem/modify_pro")
	public String admin_modify_pro(@RequestParam("admin_id") String admin_id, @RequestParam("pass") String pass,
			@RequestParam("name") String name, @RequestParam("position") String position) {

		Pet_admin admin = new Pet_admin(admin_id, pass, name, position);

		adminService.modifyAdminInfo(admin);

		return "admin/admin_mem/modify_success";

	}

	@GetMapping("/admin_mem/delete_pro")
	public String admin_delete_pro(@RequestParam("admin_id") String admin_id) {

		if (admin_id.equals("root")) {
			return "admin/admin_mem/list";
		}

		adminService.deleteAdminInfo(admin_id);

		return "admin/admin_mem/delete_success";
	}

	// 占쏙옙 탈占쏙옙占쏙옙 占쌉쏙옙占쏙옙
	@GetMapping("/client_mem/list_del")
	public String client_list_del(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Pet_member> memberList = memberService.admin_allMemberList(page);
		model.addAttribute("memberList", memberList);

		Page pageBean = memberService.getMemberCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/client_mem/list_del";
	}

	@GetMapping("/client_mem/delete_pro")
	public String client_delete_pro(@RequestParam("member_id") String member_id) {

		cartService.resetCart(member_id);
		qnaService.withdrawalQna(member_id);
		reviewService.withdrawalReview(member_id);
		memberService.deleteMember(member_id);
		return "admin/client_mem/delete_success";
	}

	// 占쏙옙 占쏙옙占쏙옙트占쏙옙占쏙옙占쌉쏙옙占쏙옙
	@GetMapping("/client_mem/list_point")
	public String client_list_point(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Pet_member> memberList = memberService.admin_allMemberList(page);
		model.addAttribute("memberList", memberList);

		Page pageBean = memberService.getMemberCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/client_mem/list_point";
	}

	@GetMapping("/client_mem/modify_point")
	public String client_modify_point(@RequestParam("member_id") String member_id,
			@RequestParam("point") String point) {
		
		int p = 0;
		
		if (!point.isEmpty()) {
			p = Integer.parseInt(point);
			memberService.updatePoint(member_id, p);
		}
			
			

		return "redirect:/admin/client_mem/list_point";
	}

	@GetMapping("/client_mem/reset_point")
	public String client_reset_point(@RequestParam("member_id") String member_id) {

		memberService.resetPoint(member_id);

		return "redirect:/admin/client_mem/list_point?page=1";
	}

	@GetMapping("/client_mem/src_point")
	public String client_search_point(@RequestParam("keyword") String member_id, Model model) {

		Pet_member member = memberService.getMemberInfo(member_id);

		model.addAttribute("member", member);

		return "admin/client_mem/src_point";
	}

	@GetMapping("/client_mem/src_del")
	public String client_search_delete(@RequestParam("keyword") String member_id, Model model) {

		Pet_member member = memberService.getMemberInfo(member_id);

		model.addAttribute("member", member);

		return "admin/client_mem/src_del";
	}

	// 占쏙옙 占쌍뱄옙占쌉쏙옙占쏙옙
	@GetMapping("/order/list")
	public String order_list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Order_list> orderlist = orderListService.admin_allOrderRecord(page);
		model.addAttribute("orderlist", orderlist);

		Page pageBean = orderListService.getOrderCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/order/list";
	}

	// 占쏙옙占쌍뱄옙占쏙옙占쏙옙
	@GetMapping("/order/modify_pro")
	public String order_modify_pro(@RequestParam("order_num") String order_num,
			@RequestParam("order_status") String order_status, @RequestParam("invoice_number") String invoice_number) {
		orderListService.updateOrder(order_num, order_status, invoice_number);

		return "redirect:/admin/order/list";
	}

	// 占쏙옙占쌍뱄옙占싯삼옙
	@GetMapping("/order/search")
	public String order_search(@RequestParam("keyword") String member_id, Model model) {

		List<Order_list> orderlist = orderListService.OrderListByClient(member_id);
		model.addAttribute("orderlist", orderlist);
		return "admin/order/search";
	}

	// 占쏙옙占쏙옙占쏙옙督占쏙옙占�
	@GetMapping("review/list")
	public String review_list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Pet_review> reviewlist = reviewService.admin_allReview(page);
		model.addAttribute("reviewlist", reviewlist);

		Page pageBean = reviewService.getReviewCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/review/list";
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	@GetMapping("review/answer")
	public String review_answer(@RequestParam("r_num") long r_num, Model model) {

		Pet_review review = reviewService.getOneReview(r_num);

		model.addAttribute("review", review);
		return "admin/review/answer";
	}

	@GetMapping("review/search")
	public String review_search(@RequestParam("keyword") String member_id, Model model) {

		List<Pet_review> reviewlist = reviewService.getReviewListByClient(member_id);
		model.addAttribute("reviewlist", reviewlist);

		return "admin/review/search";
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쌜쇽옙
	@PostMapping("review/answer_pro")
	public String review_answer_pro(@RequestParam("r_num") long r_num,
			@RequestParam("content_reply") String content_reply) {

		reviewService.updateReviewReply(content_reply, r_num);

		return "admin/review/answer_success";
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占�
	@GetMapping("review/delete_pro")
	public String review_delete_pro(@RequestParam("r_num") long r_num) {

		reviewService.deleteReview(r_num);

		return "admin/review/delete_success";
	}

	// 占쏙옙占쏙옙占실게쏙옙占쏙옙
	@GetMapping("qna/list")
	public String qna_list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Pet_qna> qnalist = qnaService.admin_allQna(page);
		model.addAttribute("qnalist", qnalist);

		Page pageBean = qnaService.getQnaCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/qna/list";
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	@GetMapping("qna/answer")
	public String qna_answer(@RequestParam("q_num") long q_num, Model model) {

		Pet_qna qna = qnaService.getOneQna(q_num);
		model.addAttribute("qna", qna);
		return "admin/qna/answer";
	}

	@GetMapping("qna/search")
	public String qna_search(@RequestParam("keyword") String member_id, Model model) {

		List<Pet_qna> qnalist = qnaService.getQnaListByClient(member_id);
		model.addAttribute("qnalist", qnalist);
		return "admin/qna/search";
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쌜쇽옙
	@PostMapping("qna/answer_pro")
	public String qna_answer_pro(@RequestParam("q_num") long q_num, @RequestParam("a_content") String a_content) {

		qnaService.updateQnaByAdmin(a_content, q_num);

		return "admin/qna/answer_success";
	}

	@GetMapping("qna/delete_pro")
	public String qna_delete_pro(@RequestParam("q_num") long q_num) {

		qnaService.deleteQna(q_num);

		return "admin/qna/delete_success";
	}

	// 占쏙옙품占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占� 占싱듸옙
	@GetMapping("/goods/add")
	public String add_goods() {
		return "admin/goods/add";
	}

	// 占쏙옙품占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占� 占쏙옙품占쏙옙占�
	@PostMapping("/goods/add_pro")
	public String add_goods_pro(@RequestParam("category_big") String category_big,
			@RequestParam("category_small") String category_small, @RequestParam("goods_name") String goods_name,
			@RequestParam("price") long price, @RequestParam("option_1") String option_1,
			@RequestParam("option_2") String option_2, @RequestParam("info") String info,
			@RequestParam("thumbnail_img_url") MultipartFile thumbnail_file,
			@RequestParam("detail_img_url") MultipartFile[] detail_files, Model model)
			throws IllegalStateException, IOException {

		String thumbnail_url = "";
		String detail_url = "";

		// 占쏙옙표占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙湄占�
		if (!thumbnail_file.getOriginalFilename().isEmpty()) {
			// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙 value占쏙옙 占쏙옙占실되억옙占쏙옙占쏙옙)+占쏙옙占쏙옙占쏙옙占쏙옙占싱몌옙
			thumbnail_file.transferTo(new File(goods_img_path + thumbnail_file.getOriginalFilename()));

			// DB占쏙옙 占쏙옙占쏙옙 url 占쏙옙占쏙옙
			thumbnail_url = "goods_img/" + thumbnail_file.getOriginalFilename();
		} else {
			model.addAttribute("msg", "Please select at least one mediaFile..");
			return "redirect:/admin/goods/add";
		}
		
		int idx=0;
		// 占쏙옙占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙湄占�
		// MultipartFile占썼열占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占싹놂옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		for (MultipartFile file : detail_files) {
			if (!file.getOriginalFilename().isEmpty()) {
				// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙 value占쏙옙 占쏙옙占실되억옙占쏙옙占쏙옙)+占쏙옙占쏙옙占쏙옙占쏙옙占싱몌옙
				file.transferTo(new File(goods_img_path + file.getOriginalFilename()));

				// DB占쏙옙 占쏙옙占쏙옙 url 占쏙옙占쏙옙
				if (idx == 0) {
					detail_url += "goods_img/" + file.getOriginalFilename();
					idx++;
				} else {
					detail_url += "|goods_img/" + file.getOriginalFilename();
					idx++;
				}

			} else {
				model.addAttribute("msg", "Please select at least one mediaFile..");
				return "redirect:/admin/goods/add";
			}
		}

		

		Pet_goods pg = new Pet_goods(category_big, category_small, 0, goods_name, price, option_1, option_2, info,
				thumbnail_url, detail_url, 0, 0, 0);
		goodsService.InsertGoodsInfo(pg);

		model.addAttribute("msg", "Multiple files uploaded successfully.");
		return "redirect:/admin/goods/list";

	}

	// 占쏙옙품占쏙옙占쏙옙,占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙트占쏙옙占쏙옙占쏙옙
	@GetMapping("/goods/list")
	public String goods_list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Pet_goods> goodsList = goodsService.admin_allGoodsList(page);
		model.addAttribute("goodsList", goodsList);

		Page pageBean = goodsService.getGoodsCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/goods/list";
	}

	// 占쏙옙품 占쏙옙占쏙옙, 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	@GetMapping("/goods/modify")
	public String modify_goods(@RequestParam("goods_code") long goods_code, @RequestParam("page") int page,
			Model model) {

		Pet_goods goods = goodsService.getGoodsInfo(goods_code);
		model.addAttribute("goods", goods);
		model.addAttribute("page", page);

		return "admin/goods/modify";
	}

	// 占쏙옙품占쏙옙占쏙옙占쌘듸옙
	@PostMapping("goods/modify_pro")
	public String modify_pro(@RequestParam("goods_code") long goods_code,
			@RequestParam("category_big") String category_big, @RequestParam("category_small") String category_small,
			@RequestParam("goods_name") String goods_name, @RequestParam("price") long price,
			@RequestParam("option_1") String option_1, @RequestParam("option_2") String option_2,
			@RequestParam("info") String info, @RequestParam("thumbnail_img_url") MultipartFile thumbnail_file,
			@RequestParam("detail_img_url") MultipartFile[] detail_files, Model model)
			throws IllegalStateException, IOException {

		Pet_goods goods = goodsService.getGoodsInfo(goods_code);

		String thumbnail_url = "";
		String detail_url = "";

		// 占쏙옙표占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙湄占�
		if (!thumbnail_file.getOriginalFilename().isEmpty()) {
			// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙 value占쏙옙 占쏙옙占실되억옙占쏙옙占쏙옙)+占쏙옙占쏙옙占쏙옙占쏙옙占싱몌옙
			thumbnail_file.transferTo(new File(goods_img_path + thumbnail_file.getOriginalFilename()));

			// DB占쏙옙 占쏙옙占쏙옙 url 占쏙옙占쏙옙
			thumbnail_url = "goods_img/" + thumbnail_file.getOriginalFilename();
		} else {
			thumbnail_url = goods.getThumbnail_img_url();
		}
		
		int idx=0;
		// 占쏙옙占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙湄占�
		// MultipartFile占썼열占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占싹놂옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		for (MultipartFile file : detail_files) {
			if (!file.getOriginalFilename().isEmpty()) {
				// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙 value占쏙옙 占쏙옙占실되억옙占쏙옙占쏙옙)+占쏙옙占쏙옙占쏙옙占쏙옙占싱몌옙
				file.transferTo(new File(goods_img_path + file.getOriginalFilename()));

				if (idx == 0) {
					detail_url += "goods_img/" + file.getOriginalFilename();
					idx++;
				} else {
					detail_url += "|goods_img/" + file.getOriginalFilename();
					idx++;
				}
			} else {
				detail_url = goods.getDetail_img_url();
			}
		}

		Pet_goods pg = new Pet_goods(category_big, category_small, goods_code, goods_name, price, option_1, option_2,
				info, thumbnail_url, detail_url, 0, 0, 0);
		goodsService.modifyGoodsInfo(pg);

		return "admin/goods/modify_success";
	}

	// 占쏙옙품占쏙옙占쏙옙占쌘듸옙
	@GetMapping("goods/delete_pro")
	public String delete(@RequestParam("goods_code") long goods_code) {

		goodsService.deleteGoodsInfo(goods_code);
		return "admin/goods/delete_success";
	}

	// 占쏙옙품占싯삼옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占�
	@GetMapping("goods/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {

		Pet_goods goods = goodsService.getGoodsByName(keyword);

		model.addAttribute("goods", goods);

		return "admin/goods/search";
	}

	// 占싱븝옙트 占쏙옙占쏙옙占쏙옙占쌓듸옙占�

	// 占싱븝옙트占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占� 占싱듸옙
	@GetMapping("/event/add")
	public String add_event() {
		return "admin/event/add";
	}

	// 占싱븝옙트占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占� 占싱븝옙트占쏙옙占�
	@PostMapping("/event/add_pro")
	public String add_event_pro(@RequestParam("title") String title, @RequestParam("board_type") String board_type,
			@RequestParam("content") String content, @RequestParam("event_img_url") MultipartFile[] detail_files,
			Model model) throws IllegalStateException, IOException {

		String detail_url = "";

		// 占쏙옙占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙湄占�
		// MultipartFile占썼열占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占싹놂옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		for (MultipartFile file : detail_files) {
			if (!file.getOriginalFilename().isEmpty()) {
				// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙 value占쏙옙 占쏙옙占실되억옙占쏙옙占쏙옙)+占쏙옙占쏙옙占쏙옙占쏙옙占싱몌옙
				file.transferTo(new File(event_img_path + file.getOriginalFilename()));

				// DB占쏙옙 占쏙옙占쏙옙 url 占쏙옙占쏙옙
				detail_url += "|event_img/" + file.getOriginalFilename();
			}
		}
		detail_url = detail_url.replaceFirst("[|]", "");
		System.out.println(adminBean.getAdmin_id());
		System.out.println(adminBean.getPosition());
		//관리자 id, 관리자 위치 -> adminBean.getAdmin_id(), adminBean.getPosition()
		Pet_event event = new Pet_event(0, board_type, adminBean.getAdmin_id(), adminBean.getPosition(), title, content, detail_url, "2021/12/31", 0);
		boardService.insertEventInfo(event);

		model.addAttribute("msg", "Multiple files uploaded successfully.");
		return "redirect:/admin/event/list";

	}

	// 占쏙옙품占쏙옙占쏙옙,占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙트占쏙옙占쏙옙占쏙옙
	@GetMapping("/event/list")
	public String event_list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<Pet_event> eventList = boardService.allEventList(page);
		model.addAttribute("eventList", eventList);

		Page pageBean = boardService.getEventCnt(page);
		model.addAttribute("pageBean", pageBean);

		model.addAttribute("page", page);

		return "admin/event/list";
	}

	// 占쏙옙품 占쏙옙占쏙옙, 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	@GetMapping("/event/modify")
	public String modify_event(@RequestParam("board_index") long board_index, @RequestParam("page") int page,
			Model model) {

		Pet_event event = boardService.getEventInfo(board_index);
		model.addAttribute("event", event);
		model.addAttribute("page", page);

		return "admin/event/modify";
	}

	// 占쏙옙품占쏙옙占쏙옙占쌘듸옙
	@PostMapping("event/modify_pro")
	public String event_modify_pro(@RequestParam("board_index") long board_index, @RequestParam("title") String title,
			@RequestParam("board_type") String board_type, @RequestParam("content") String content,
			@RequestParam("event_img_url") MultipartFile[] detail_files, Model model)
			throws IllegalStateException, IOException {

		Pet_event event = boardService.getEventInfo(board_index);

		String detail_url = "";
		// 占쏙옙占싱뱄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙湄占�
		// MultipartFile占썼열占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 占싹놂옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		for (MultipartFile file : detail_files) {
			if (!file.getOriginalFilename().isEmpty()) {
				// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙 value占쏙옙 占쏙옙占실되억옙占쏙옙占쏙옙)+占쏙옙占쏙옙占쏙옙占쏙옙占싱몌옙
				file.transferTo(new File(event_img_path + file.getOriginalFilename()));

				// DB占쏙옙 占쏙옙占쏙옙 url 占쏙옙占쏙옙
				detail_url += "|event_img/" + file.getOriginalFilename();
			} else {
				detail_url = event.getEvent_img_url();
			}
		}
		if (detail_url != null) {
			detail_url = detail_url.replaceFirst("[|]", "");
		} else {
			detail_url = "";
		}

		Pet_event ev = new Pet_event(board_index, board_type, event.getAdmin_id(), adminBean.getPosition(), title, content, detail_url,
				event.getReg_date(), event.getBoard_hits());

		boardService.modifyEventInfo(ev);

		return "admin/event/modify_success";
	}

	// 占쏙옙품占쏙옙占쏙옙占쌘듸옙
	@GetMapping("event/delete_pro")
	public String delete_event(@RequestParam("board_index") long board_index) {

		boardService.deleteEventInfo(board_index);
		return "admin/event/delete_success";
	}

}
