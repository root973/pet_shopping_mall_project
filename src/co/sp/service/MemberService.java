package co.sp.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import co.sp.beans.Page;
import co.sp.beans.Pet_member;
import co.sp.dao.MemberDao;
import co.sp.validator.MemberValid;

@Service
public class MemberService {
	
	//출력할 게시글갯수
	@Value("${member.page.listcount}")
	private int member_page_list_cnt;
		
	//출력할 이전, 다음사이 페이징갯수
	@Value("${member.page.pa}")
	private int member_page_pa;
	
	@Autowired
	private MemberDao memberDao;
	
	@Resource(name="loginBean")
	private Pet_member loginBean;
	
	
	public boolean checkuserIdExist(String user_id) {
		
		String user_name = memberDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//로그인 시 사용하는 
	public void getLoginUserInfo(Pet_member tempLoginUserBean) {
		Pet_member tempLoginUserBean2 = memberDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginBean.setMember_id(tempLoginUserBean2.getMember_id());
			loginBean.setName(tempLoginUserBean2.getName());
			loginBean.setBirth(tempLoginUserBean2.getBirth());
			loginBean.setGender(tempLoginUserBean2.getGender());
			loginBean.setPhone(tempLoginUserBean2.getPhone());
			loginBean.setEmail(tempLoginUserBean2.getEmail());
			loginBean.setZip_code(tempLoginUserBean2.getZip_code());
			loginBean.setAddress(tempLoginUserBean2.getAddress());
			loginBean.setAddress_detail(tempLoginUserBean2.getAddress_detail());
			loginBean.setPoint(tempLoginUserBean2.getPoint());
			loginBean.setMemberLogin(true);
		}
		
		
	}
	
	
	public String certify(Pet_member certifyUserBean) {		
		
		certifyUserBean.setMember_id(loginBean.getMember_id());
		certifyUserBean.setName(loginBean.getName());
		
		return memberDao.certify(certifyUserBean);
	}
	
	//개인정보 수정 시 사용하는
	public void getModifyUserInfo(Pet_member modifyUserBean) {
		Pet_member tempModifyUserBean = memberDao.getModifyUserInfo(loginBean.getMember_id());
		
		modifyUserBean.setMember_id(tempModifyUserBean.getMember_id());
		modifyUserBean.setName(tempModifyUserBean.getName());
		modifyUserBean.setBirth(tempModifyUserBean.getBirth());
		modifyUserBean.setGender(tempModifyUserBean.getGender());
		modifyUserBean.setPhone(tempModifyUserBean.getPhone());
		modifyUserBean.setEmail(tempModifyUserBean.getEmail());
		modifyUserBean.setZip_code(tempModifyUserBean.getZip_code());
		modifyUserBean.setAddress(tempModifyUserBean.getAddress());
		modifyUserBean.setAddress_detail(tempModifyUserBean.getAddress_detail());
		modifyUserBean.setPoint(tempModifyUserBean.getPoint());
	}
		
	public void addMemberInfo(Pet_member joinUserBean) {
		memberDao.insertMemberInfo(joinUserBean);
	}
	
	public String searchId(Pet_member srcMemberBean) {
		return memberDao.searchId(srcMemberBean);
	}
	
	public String searchPass(Pet_member srcMemberBean) {
		return memberDao.searchPass(srcMemberBean);
	}
	
	public void modifyUserInfo(Pet_member modifyUserBean) {
		memberDao.modifyUserInfo(modifyUserBean);
	}
	
	public void deleteMember(String member_id) {
		memberDao.deleteMember(member_id);
	}


	public List<Pet_member> admin_allMemberList(int page) {
		int start = (page - 1) * member_page_list_cnt;
		RowBounds rowBounds = new RowBounds(start, member_page_list_cnt);
		return memberDao.admin_getAllMemberList(rowBounds);
	}


	public Page getMemberCnt(int current_page) {
		int member_cnt = memberDao.getMemberCnt();
		Page pageBean = new Page(member_cnt, current_page, member_page_list_cnt, member_page_pa);
		return pageBean;
	}


	public void updatePoint(String member_id, int point) {
		memberDao.updatePoint(member_id, point);
	}


	public void resetPoint(String member_id) {
		memberDao.resetPoint(member_id);
	}


	public String[] admin_getAllMemberAjax() {
		return memberDao.admin_getAllMemberAjax();
	}


	public Pet_member getMemberInfo(String member_id) {
		return memberDao.getMemberInfo(member_id);
	}


	public void client_modifyPoint(int point, String member_id) {
		memberDao.client_modifyPoint(point, member_id);
	}
	
}
