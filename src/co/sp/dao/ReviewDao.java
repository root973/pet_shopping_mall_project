package co.sp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_review;
import co.sp.mapper.ReviewMapper;

@Repository
public class ReviewDao {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	public void insertReview(Pet_review reviewBean) {
		reviewMapper.insertReview(reviewBean);
	}
	public List<Pet_review> getAllReviewByGoods(long goods_code, RowBounds rowBounds){
		return reviewMapper.getAllReviewByGoods(goods_code, rowBounds);
	}
	public void updateReview(Pet_review reviewBean) {
		reviewMapper.updateReview(reviewBean);
	}
	public List<Pet_review> clientReviewList(String member_id) {
		return reviewMapper.clientReviewList(member_id);
	}
	public List<Pet_review> admin_allReview(RowBounds rowBounds) {
		return reviewMapper.admin_allReview(rowBounds);
	}
	public void deleteReview(long r_num) {
		reviewMapper.deleteReview(r_num);
	}
	public void withdrawalReview(String member_id) {
		reviewMapper.withdrawalReview(member_id);
	}
	public int getReviewCntBygoods(long goods_code) {
		return reviewMapper.getReviewCntBygoods(goods_code);
	}
	public int getReviewCnt() {
		return reviewMapper.getReviewCnt();
	}
	public Pet_review getOneReview(long r_num) {
		return reviewMapper.getOneReview(r_num);
	}
	public void updateReviewReply(String content_reply, long r_num) {
		reviewMapper.updateReviewReply(content_reply, r_num);
	}
	public List<Pet_review> getReviewListByClient(String member_id) {
		return reviewMapper.getReviewListByClient(member_id);
	}
	public List<Pet_review> getAdminMainReviewList() {
		return reviewMapper.getAdminMainReviewList();
	}
	
}
