package co.sp.beans;

//������ ���̺� ��ü
public class Pet_admin {
	
	//������ id
	private String admin_id;
	//������ ���
	private String pass;
	//������ ���Ȯ��
	private String pass2;
	//������ �̸�
	private String name;
	//������ ��å
	private String position;
	
	//���̵��ߺ� Ȯ���� ���� ����
	private boolean idExist;
	//�α����� Ȯ���� ���� ����
	private boolean adminLogin;
	
	public Pet_admin() {
		
	}
	//�⺻����
	public Pet_admin(String admin_id, String pass, String name, String position) {
		this.admin_id = admin_id;
		this.pass = pass;
		this.name = name;
		this.position = position;
	}



	public boolean isIdExist() {
		return idExist;
	}


	public void setIdExist(boolean idExist) {
		this.idExist = idExist;
	}


	public boolean isAdminLogin() {
		return adminLogin;
	}


	public void setAdminLogin(boolean adminLogin) {
		this.adminLogin = adminLogin;
	}


	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	

}
