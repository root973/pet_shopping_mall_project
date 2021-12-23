package co.sp.beans;

//상품테이블 빈객체
public class Pet_goods {
	
	//대카테고리
	private String category_big;
	//소카테고리
	private String category_small;
	//상품코드
	private long goods_code;
	//상품이름
	private String goods_name;
	//가격
	private long price;
	//옵션1
	private String option_1;
	//옵션2
	private String option_2;
	//상품정보
	private String info;
	//대표이미지 경로
	private String thumbnail_img_url;
	//상세이미지 경로
	//경로들은 '|'로 나뉘어져 있다.
	//불러온 데이터는 .split("|")을 이용하여 배열에 담아 사용해야한다.
	private String detail_img_url;
	//누적구매횟수
	private long purchase_number;
	//좋아요횟수
	private long like_number;
	//누적조회횟수
	private long goods_hits;
	
	
	public Pet_goods(String category_big, String category_small, long goods_code, String goods_name, long price,
			String option_1, String option_2, String info, String thumbnail_img_url, String detail_img_url,
			long purchase_number, long like_number, long goods_hits) {
		this.category_big = category_big;
		this.category_small = category_small;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.price = price;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.info = info;
		this.thumbnail_img_url = thumbnail_img_url;
		this.detail_img_url = detail_img_url;
		this.purchase_number = purchase_number;
		this.like_number = like_number;
		this.goods_hits = goods_hits;
	}


	public String getCategory_big() {
		return category_big;
	}


	public void setCategory_big(String category_big) {
		this.category_big = category_big;
	}


	public String getCategory_small() {
		return category_small;
	}


	public void setCategory_small(String category_small) {
		this.category_small = category_small;
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


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public String getOption_1() {
		return option_1;
	}


	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}


	public String getOption_2() {
		return option_2;
	}


	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getThumbnail_img_url() {
		return thumbnail_img_url;
	}


	public void setThumbnail_img_url(String thumbnail_img_url) {
		this.thumbnail_img_url = thumbnail_img_url;
	}


	public String getDetail_img_url() {
		return detail_img_url;
	}


	public void setDetail_img_url(String detail_img_url) {
		this.detail_img_url = detail_img_url;
	}


	public long getPurchase_number() {
		return purchase_number;
	}


	public void setPurchase_number(long purchase_number) {
		this.purchase_number = purchase_number;
	}


	public long getLike_number() {
		return like_number;
	}


	public void setLike_number(long like_number) {
		this.like_number = like_number;
	}


	public long getGoods_hits() {
		return goods_hits;
	}


	public void setGoods_hits(long goods_hits) {
		this.goods_hits = goods_hits;
	}

	
}
