package co.sp.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//ȸ�� ���̺� ��ü
public class Pet_member {
	
	@Pattern(regexp = "[a-zA-Z0-9]*")
	@Size(min=4, max=15)
	private String member_id;
	
	//  8~16�ڸ� ����  ���� ����   ������ ����      Ư������ ����
	@Pattern(regexp="^.*(?=^.{8,16}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
	private String pass;
	@Pattern(regexp="^.*(?=^.{8,16}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
	private String pass2;
	
	@Size(min=2, max=4)
	@Pattern(regexp = "[��-�R]*")
	private String name;
	
	private String birth;

	private String gender;
	
	private String phone;
	
	@Email
	private String email;
	
	private String zip_code;
	
	private String address;
	
	private String address_detail;
	
	private int point;
	
	//���̵��ߺ� Ȯ���� ���� ����
	private boolean idExist;
	//�α����� Ȯ���� ���� ����
	private boolean memberLogin;
	
	//�⺻����
	public Pet_member() {
		this.idExist = false;
		this.memberLogin = false;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isIdExist() {
		return idExist;
	}

	public void setIdExist(boolean idExist) {
		this.idExist = idExist;
	}

	public boolean isMemberLogin() {
		return memberLogin;
	}

	public void setMemberLogin(boolean memberLogin) {
		this.memberLogin = memberLogin;
	}

	
}
