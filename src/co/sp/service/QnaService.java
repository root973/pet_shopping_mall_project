package co.sp.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.sp.beans.Page;
import co.sp.beans.Pet_qna;
import co.sp.dao.QnaDao;

@Service
public class QnaService {

	// ����� �Խñ۰���
	@Value("${qna.page.listcount}")
	private int qna_page_list_cnt;

	// ����� ����, �������� ����¡����
	@Value("${qna.page.pa}")
	private int qna_page_pa;

	// ����� �Խñ۰���
	@Value("${admin_qna.page.listcount}")
	private int admin_qna_page_list_cnt;

	// ����� ����, �������� ����¡����
	@Value("${admin_qna.page.pa}")
	private int admin_qna_page_pa;

	@Autowired
	private QnaDao qnaDao;

	// ���� �ø���
	public void insertQna(Pet_qna qnaBean) {
		qnaDao.insertQna(qnaBean);
	}

	// �ش� ��ǰ�� �ڵ��ȣ�� �Ű��� ���� ���� ��������
	public List<Pet_qna> getAllQnaBygoods(long goods_code, int page_q) {
		int start = (page_q - 1) * qna_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, qna_page_list_cnt);
		return qnaDao.getAllQnaByGoods(goods_code, rowBounds);
	}

	// ���� �����ϱ�
	public void updateQnaByClient(Pet_qna qnaBean) {
		qnaDao.updateQnaByClient(qnaBean);
	}

	public List<Pet_qna> clientQnaList(String member_id) {
		return qnaDao.clientQnaList(member_id);
	}

	public List<Pet_qna> admin_allQna(int page) {
		int start = (page - 1) * admin_qna_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, admin_qna_page_list_cnt);
		return qnaDao.admin_allQna(rowBounds);
	}

	// ���� �����ϱ�
	public void deleteQna(long q_num) {
		qnaDao.deleteQna(q_num);
	}

	public void withdrawalQna(String member_id) {
		qnaDao.withdrawalQna(member_id);
	}

	public Page getQnaCntBygoods(long goods_code, int current_page) {
		int qna_cnt = qnaDao.getQnaCntBygoods(goods_code);
		Page pageBean = new Page(qna_cnt, current_page, qna_page_list_cnt, qna_page_pa);
		return pageBean;
	}

	public Page getQnaCnt(int current_page) {
		int qna_cnt = qnaDao.getQnaCnt();
		Page pageBean = new Page(qna_cnt, current_page, admin_qna_page_list_cnt, admin_qna_page_pa);
		return pageBean;
	}

	public Pet_qna getOneQna(long q_num) {
		return qnaDao.getOneQna(q_num);
	}

	// ���� �亯�ϱ�(����)
	public void updateQnaByAdmin(String a_content, long q_num) {
		qnaDao.updateQnaByAdmin(a_content, q_num);
	}

	public List<Pet_qna> getQnaListByClient(String member_id) {
		return qnaDao.getQnaListByClient(member_id);
	}

	public List<Pet_qna> getAdminMainQnaList() {
		return qnaDao.getAdminMainQnaList();
	}
	

}
