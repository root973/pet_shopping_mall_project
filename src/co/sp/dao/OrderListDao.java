package co.sp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Order_list;
import co.sp.mapper.OrderListMapper;

@Repository
public class OrderListDao {
	
	@Autowired
	private OrderListMapper orderListMapper;
	
	public void insertOrder(Order_list insertOrder) {
		orderListMapper.insertOrder(insertOrder);
	}
	public List<Order_list> nonCompleteOrderByDate(String order_date) {
		return orderListMapper.nonCompleteOrderByDate(order_date);
	}
	public void modifyStatus(String order_status, String order_num) {
		orderListMapper.modifyStatus(order_status, order_num);
	}
	public List<Order_list> admin_allOrderRecord(RowBounds rowBounds) {
		return orderListMapper.admin_allOrderRecord(rowBounds);
	}
	public List<Order_list> OrderListByClient(String member_id) {
		return orderListMapper.OrderListByClient(member_id);
	}
	public int cntOrderListByDate(String order_date) {
		return orderListMapper.cntOrderListByDate(order_date);
	}
	public void deleteListByNum(String order_num) {
		orderListMapper.deleteListByNum(order_num);
	}
	public void deleteListByClient(String member_id, String member_name) {
		orderListMapper.deleteListByClient(member_id, member_name);
	}
	public int getOrderCnt() {
		return orderListMapper.getOrderCnt();
	}
	public void updateOrder(String order_num, String order_status, String invoice_number) {
		orderListMapper.updateOrder(order_num, order_status, invoice_number);
	}
	public List<Order_list> getAdminMainOrderList() {
		return orderListMapper.getAdminMainOrderList();
	}
	
	
}










