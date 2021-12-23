package co.sp.beans;

public class Pet_review {

	private long r_num;
	private long goods_code;
	private String member_id;
	private String content;
	private String content_reply;
	private String reg_date;
	
	public String getContent_reply() {
		return content_reply;
	}
	public void setContent_reply(String content_reply) {
		this.content_reply = content_reply;
	}
	public long getR_num() {
		return r_num;
	}
	public void setR_num(long r_num) {
		this.r_num = r_num;
	}
	public long getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(long goods_code) {
		this.goods_code = goods_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
