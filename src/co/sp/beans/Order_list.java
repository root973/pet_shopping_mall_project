package co.sp.beans;

import javax.validation.constraints.Pattern;

//주문리스트 테이블 빈객체
public class Order_list {
	//주문날짜
	private String order_date;
	//주문번호
	private String order_num;
	//고객 id
	private String member_id;
	//제품 코드
	private long goods_code;
	//고객 이름
	private String name;
	//제품이름
	private String goods_name;
	//옵션1
	private String goods_option1;
	//옵션2
	private String goods_option2;
	//가격
	@Pattern(regexp = "[0-9]*")
	private long total_price;
	//주문수량
	@Pattern(regexp = "[0-9]*")
	private long ea;
	//고객 전화번호
	private String phone;
	//고객주소
	private String address;
	//메모
	private String memo;
	//송장번호
	private String invoice_number;
	//상태
	private String order_status;
	
	
	public String getGoods_option1() {
		return goods_option1;
	}
	public void setGoods_option1(String goods_option1) {
		this.goods_option1 = goods_option1;
	}
	public String getGoods_option2() {
		return goods_option2;
	}
	public void setGoods_option2(String goods_option2) {
		this.goods_option2 = goods_option2;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public long getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(long goods_code) {
		this.goods_code = goods_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public long getTotal_price() {
		return total_price;
	}
	public void setTotal_price(long total_price) {
		this.total_price = total_price;
	}
	public long getEa() {
		return ea;
	}
	public void setEa(long ea) {
		this.ea = ea;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	


	
	
}
