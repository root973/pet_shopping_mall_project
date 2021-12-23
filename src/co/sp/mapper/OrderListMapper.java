package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Order_list;


//order_list table과 상호작용하는 쿼리문 모음
public interface OrderListMapper {
	//주문정보 저장
	@Insert("insert into order_list" +
	 " values(TO_CHAR(SYSDATE, 'YYYY-MM-DD'), #{order_num},#{member_id},#{goods_code},"
	 +" #{name}, #{goods_name}, #{goods_option1}, #{goods_option2}, #{total_price}, #{ea}, #{phone}, #{address}, #{memo}, null, '준비중')")
	void insertOrder(Order_list insertOrder);
	//특정 날짜의 처리하지 않은 주문들 확인
	@Select("select * from order_list"
			+ " where order_status='준비중' and order_num like %"+"#{order_date}"+"%")
	List<Order_list> nonCompleteOrderByDate(String order_date);
	//주문 상태 변경(관리자)
	@Update("update order_list set order_status=#{order_status} "+
			"where order_num=#{order_num}")
	void modifyStatus(String order_status, String order_num);
	//전체 주문기록 가져오기(관리자)
	@Select("select * from order_list order by order_date desc")
	List<Order_list> admin_allOrderRecord(RowBounds rowBounds);
	//특정 고객의 주문들 확인
	@Select("select * from order_list where member_id=#{member_id}")
	List<Order_list> OrderListByClient(String member_id);
	//해당 날짜 주문 전부 호출
	@Select("select count(*) from order_list where order_date=#{order_date}")
	int cntOrderListByDate(String order_date);
	//주문번호 조회로 주문기록 삭제
	@Delete("delete from order_list where order_num=#{order_num}")
	void deleteListByNum(String order_num);
	//고객정보로 주문기록 삭제
	@Delete("delete from order_list"+
			" where member_id=#{member_id} and member_name=#{member_name}")
	void deleteListByClient(String member_id, String member_name);
	//페이징을 위한 주문갯수가져오기
	@Select("select count(*) from order_list")
	int getOrderCnt();
	//주문상태 업데이트(관리자)
	@Update("update order_list set order_status=#{order_status}, invoice_number=#{invoice_number} where order_num=#{order_num}")
	void updateOrder(@Param("order_num")String order_num, @Param("order_status")String order_status, @Param("invoice_number")String invoice_number);
	//메인페이지 리스트(관리자)
	@Select("select * from order_list where rownum <=3 order by order_date desc")
	List<Order_list> getAdminMainOrderList();
	
	
	
	
	
	
}
