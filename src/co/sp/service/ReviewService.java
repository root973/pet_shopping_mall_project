package co.sp.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.sp.beans.Page;
import co.sp.beans.Pet_review;
import co.sp.dao.ReviewDao;

@Service
public class ReviewService {
	
	//출력할 게시글갯수
	@Value("${review.page.listcount}")
	private int review_page_list_cnt;
				
	//출력할 이전, 다음사이 페이징갯수
	@Value("${review.page.pa}")
	private int review_page_pa;
	
	//출력할 게시글갯수
	@Value("${admin_review.page.listcount}")
	private int admin_review_page_list_cnt;
					
	//출력할 이전, 다음사이 페이징갯수
	@Value("${admin_review.page.pa}")
	private int admin_review_page_pa;
	
	@Autowired
	private ReviewDao reviewDao;
	
	public void insertReview(Pet_review reviewBean) {
		reviewDao.insertReview(reviewBean);
	}
	public List<Pet_review> getAllReviewByGoods(long goods_code, int page_r){
		int start = (page_r - 1) * review_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, review_page_list_cnt);
		return reviewDao.getAllReviewByGoods(goods_code, rowBounds);
	}
	public void updateReview(Pet_review reviewBean) {
		reviewDao.updateReview(reviewBean);
	}
	public List<Pet_review> clientReviewList(String member_id) {
		return reviewDao.clientReviewList(member_id);
	}
	public List<Pet_review> admin_allReview(int page) {
		int start = (page - 1) * admin_review_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, admin_review_page_list_cnt);
		return reviewDao.admin_allReview(rowBounds);
	}
	public void deleteReview(long r_num) {
		reviewDao.deleteReview(r_num);
	}
	public void withdrawalReview(String member_id) {
		reviewDao.withdrawalReview(member_id);
	}
	public Page getReviewCntBygoods(long goods_code, int current_page) {
		int review_cnt = reviewDao.getReviewCntBygoods(goods_code);
		Page pageBean = new Page(review_cnt, current_page, review_page_list_cnt, review_page_pa);
		return pageBean;
	}
	public Page getReviewCnt(int current_page) {
		int review_cnt = reviewDao.getReviewCnt();
		Page pageBean = new Page(review_cnt, current_page, admin_review_page_list_cnt, admin_review_page_pa);
		return pageBean;
	}
	public Pet_review getOneReview(long r_num) {
		return reviewDao.getOneReview(r_num);
	}
	public void updateReviewReply(String content_reply, long r_num) {
		reviewDao.updateReviewReply(content_reply, r_num);
	}
	public List<Pet_review> getReviewListByClient(String member_id) {
		return reviewDao.getReviewListByClient(member_id);
	}
	public List<Pet_review> getAdminMainReviewList() {
		return reviewDao.getAdminMainReviewList();
	}
	
	

}
