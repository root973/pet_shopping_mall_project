package co.sp.beans;

//관리자 테이블 빈객체
public class Pet_admin {
	
	//관리자 id
	private String admin_id;
	//관리자 비번
	private String pass;
	//관리자 비번확인
	private String pass2;
	//관리자 이름
	private String name;
	//관리자 직책
	private String position;
	
	//아이디중복 확인을 위한 변수
	private boolean idExist;
	//로그인을 확인을 위한 변수
	private boolean adminLogin;
	
	public Pet_admin() {
		
	}
	//기본설정
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
