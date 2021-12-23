package co.sp.beans;

//��ǰ���̺� ��ü
public class Pet_goods {
	
	//��ī�װ�
	private String category_big;
	//��ī�װ�
	private String category_small;
	//��ǰ�ڵ�
	private long goods_code;
	//��ǰ�̸�
	private String goods_name;
	//����
	private long price;
	//�ɼ�1
	private String option_1;
	//�ɼ�2
	private String option_2;
	//��ǰ����
	private String info;
	//��ǥ�̹��� ���
	private String thumbnail_img_url;
	//���̹��� ���
	//��ε��� '|'�� �������� �ִ�.
	//�ҷ��� �����ʹ� .split("|")�� �̿��Ͽ� �迭�� ��� ����ؾ��Ѵ�.
	private String detail_img_url;
	//��������Ƚ��
	private long purchase_number;
	//���ƿ�Ƚ��
	private long like_number;
	//������ȸȽ��
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
