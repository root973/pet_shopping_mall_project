package co.sp.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.sp.beans.Order_list;
import co.sp.beans.Page;
import co.sp.dao.OrderListDao;

@Service
public class OrderListService {
	
	//출력할 게시글갯수
	@Value("${order.page.listcount}")
	private int order_list_cnt;
					
	//출력할 이전, 다음사이 페이징갯수
	@Value("${order.page.pa}")
	private int order_page_pa;
	
	@Autowired
	private OrderListDao orderListDao;
	
	public void insertOrder(Order_list insertOrder) {
		orderListDao.insertOrder(insertOrder);
	}
	public List<Order_list> nonCompleteOrderByDate(String order_date) {
		return orderListDao.nonCompleteOrderByDate(order_date);
	}
	public void modifyStatus(String order_status, String order_num) {
		orderListDao.modifyStatus(order_status, order_num);
	}
	
	public List<Order_list> OrderListByClient(String member_id) {
		return orderListDao.OrderListByClient(member_id);
	}
	public int cntOrderListByDate(String order_date) {
		return  orderListDao.cntOrderListByDate(order_date);
	}
	public void deleteListByNum(String order_num) {
		orderListDao.deleteListByNum(order_num);
	}
	public void deleteListByClient(String member_id, String member_name) {
		orderListDao.deleteListByClient(member_id, member_name);
	}
	public List<Order_list> admin_allOrderRecord(int page) {
		int start = (page-1) * order_list_cnt;
		RowBounds rowBounds = new RowBounds(start, order_list_cnt);
		return orderListDao.admin_allOrderRecord(rowBounds);
	}
	public Page getOrderCnt(int current_page) {
		int cnt = orderListDao.getOrderCnt();
		Page pageBean = new Page(cnt, current_page, order_list_cnt, order_page_pa);
		return pageBean;
	}
	public void updateOrder(String order_num, String order_status, String invoice_number) {
		orderListDao.updateOrder(order_num, order_status, invoice_number);
	}
	public List<Order_list> getAdminMainOrderList() {
		return orderListDao.getAdminMainOrderList();
	}
}
