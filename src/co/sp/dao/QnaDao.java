package co.sp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_qna;
import co.sp.mapper.QnaMapper;

@Repository
public class QnaDao {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public void insertQna(Pet_qna qnaBean) {
		qnaMapper.insertQna(qnaBean);
	}
	public List<Pet_qna> getAllQnaByGoods(long goods_code, RowBounds rowBounds) {
		return qnaMapper.getAllQnaByGoods(goods_code, rowBounds);
	}
	public void updateQnaByClient(Pet_qna qnaBean) {
		qnaMapper.updateQnaByClient(qnaBean);
	}
	public List<Pet_qna> clientQnaList(String member_id) {
		return qnaMapper.clientQnaList(member_id);
	}
	public List<Pet_qna> admin_allQna(RowBounds rowBounds) {
		return qnaMapper.admin_allQna(rowBounds);
	}
	public void deleteQna(long q_num) {
		qnaMapper.deleteQna(q_num);
	}
	public void withdrawalQna(String member_id) {
		qnaMapper.withdrawalQna(member_id);
	}
	public int getQnaCntBygoods(long goods_code) {
		return qnaMapper.getQnaCntBygoods(goods_code);
	}
	public int getQnaCnt() {
		return qnaMapper.getQnaCnt();
	}
	public Pet_qna getOneQna(long q_num) {
		return qnaMapper.getOneQna(q_num);
	}
	public void updateQnaByAdmin(String a_content, long q_num) {
		qnaMapper.updateQnaByAdmin(a_content, q_num);
	}
	public List<Pet_qna> getQnaListByClient(String member_id) {
		return qnaMapper.getQnaListByClient(member_id);
	}
	public List<Pet_qna> getAdminMainQnaList() {
		return qnaMapper.getAdminMainQnaList();
	}
	
}
