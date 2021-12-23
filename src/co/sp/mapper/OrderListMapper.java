package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Order_list;


//order_list table�� ��ȣ�ۿ��ϴ� ������ ����
public interface OrderListMapper {
	//�ֹ����� ����
	@Insert("insert into order_list" +
	 " values(TO_CHAR(SYSDATE, 'YYYY-MM-DD'), #{order_num},#{member_id},#{goods_code},"
	 +" #{name}, #{goods_name}, #{goods_option1}, #{goods_option2}, #{total_price}, #{ea}, #{phone}, #{address}, #{memo}, null, '�غ���')")
	void insertOrder(Order_list insertOrder);
	//Ư�� ��¥�� ó������ ���� �ֹ��� Ȯ��
	@Select("select * from order_list"
			+ " where order_status='�غ���' and order_num like %"+"#{order_date}"+"%")
	List<Order_list> nonCompleteOrderByDate(String order_date);
	//�ֹ� ���� ����(������)
	@Update("update order_list set order_status=#{order_status} "+
			"where order_num=#{order_num}")
	void modifyStatus(String order_status, String order_num);
	//��ü �ֹ���� ��������(������)
	@Select("select * from order_list order by order_date desc")
	List<Order_list> admin_allOrderRecord(RowBounds rowBounds);
	//Ư�� ���� �ֹ��� Ȯ��
	@Select("select * from order_list where member_id=#{member_id}")
	List<Order_list> OrderListByClient(String member_id);
	//�ش� ��¥ �ֹ� ���� ȣ��
	@Select("select count(*) from order_list where order_date=#{order_date}")
	int cntOrderListByDate(String order_date);
	//�ֹ���ȣ ��ȸ�� �ֹ���� ����
	@Delete("delete from order_list where order_num=#{order_num}")
	void deleteListByNum(String order_num);
	//�������� �ֹ���� ����
	@Delete("delete from order_list"+
			" where member_id=#{member_id} and member_name=#{member_name}")
	void deleteListByClient(String member_id, String member_name);
	//����¡�� ���� �ֹ�������������
	@Select("select count(*) from order_list")
	int getOrderCnt();
	//�ֹ����� ������Ʈ(������)
	@Update("update order_list set order_status=#{order_status}, invoice_number=#{invoice_number} where order_num=#{order_num}")
	void updateOrder(@Param("order_num")String order_num, @Param("order_status")String order_status, @Param("invoice_number")String invoice_number);
	//���������� ����Ʈ(������)
	@Select("select * from order_list where rownum <=3 order by order_date desc")
	List<Order_list> getAdminMainOrderList();
	
	
	
	
	
	
}
