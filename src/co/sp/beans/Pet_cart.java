package co.sp.beans;

public class Pet_cart {

	private long cart_idx;
	
	private String member_id;
	
	private long goods_code;
	
	private String goods_name;
	
	private String img_url;
	
	private long price;
	
	private int ea;
	
	private String option1;
	
	private String option2;
	
	private long total;
	
	
	
	public Pet_cart(long cart_idx, String member_id, long goods_code, String goods_name, String img_url, long price,
			int ea, String option1, String option2, long total) {
		this.cart_idx = cart_idx;
		this.member_id = member_id;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.img_url = img_url;
		this.price = price;
		this.ea = ea;
		this.option1 = option1;
		this.option2 = option2;
		this.total = total;
	}

	public long getCart_idx() {
		return cart_idx;
	}

	public void setCart_idx(long cart_idx) {
		this.cart_idx = cart_idx;
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

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	
	
	
}
