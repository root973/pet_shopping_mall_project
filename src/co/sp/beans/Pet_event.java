package co.sp.beans;

//��������/�̺�Ʈ ���̺� ��ü
public class Pet_event {
	//�Խ��� ��ȣ
	private long board_index;
	//��������, �̺�Ʈ ���л���
	private String board_type;
	//������ ���̵�
	private String admin_id;
	//������ ��å
	private String position;
	//����
	private String title;
	//�Խù� ����
	private String content;
	//�̺�Ʈ �������
	private String event_img_url;
	//�Խù� ��ϳ�¥
	private String reg_date;
	//�Խñ� ��ȸ��
	private long board_hits;
	
	
	


	public Pet_event(long board_index, String board_type, String admin_id, String position, String title,
			String content, String event_img_url, String reg_date, long board_hits) {
		this.board_index = board_index;
		this.board_type = board_type;
		this.admin_id = admin_id;
		this.position = position;
		this.title = title;
		this.content = content;
		this.event_img_url = event_img_url;
		this.reg_date = reg_date;
		this.board_hits = board_hits;
	}


	public long getBoard_index() {
		return board_index;
	}


	public void setBoard_index(long board_index) {
		this.board_index = board_index;
	}
	
	
	public String getBoard_type() {
		return board_type;
	}


	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}


	public String getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	
	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getEvent_img_url() {
		return event_img_url;
	}


	public void setEvent_img_url(String event_img_url) {
		this.event_img_url = event_img_url;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}


	public long getBoard_hits() {
		return board_hits;
	}


	public void setBoard_hits(long board_hits) {
		this.board_hits = board_hits;
	}
	

}
