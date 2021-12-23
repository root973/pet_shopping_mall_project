package co.sp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_member;
import co.sp.mapper.MemberMapper;


@Repository
public class MemberDao {
		
	@Autowired
	private MemberMapper memberMapper;
	
	public String checkUserIdExist(String member_id) {
		return memberMapper.checkUserIdExist(member_id);
	}
	public void insertMemberInfo(Pet_member insertMember) {
		memberMapper.insertMemberInfo(insertMember);
	}
	public Pet_member getLoginUserInfo(Pet_member tempLoginUserBean) {
		return memberMapper.getLoginUserInfo(tempLoginUserBean);
	}
	public String certify(Pet_member certifyUserBean) {
		return memberMapper.certify(certifyUserBean);
	}
	public Pet_member getModifyUserInfo(String member_id) {
		return memberMapper.getModifyUserInfo(member_id);
	}
	public String searchId(Pet_member srcMemberBean) {
		return memberMapper.searchId(srcMemberBean);
	}
	public String searchPass(Pet_member srcMemberBean) {
		return  memberMapper.searchPass(srcMemberBean);
	}
	public void modifyUserInfo(Pet_member modifyUserBean) {
		memberMapper.modifyUserInfo(modifyUserBean);
	}
	public void client_modifyPoint(int point, String member_id) {
		memberMapper.client_modifyPoint(point, member_id);
	}
	public void deleteMember(String member_id) {
		memberMapper.deleteMember(member_id);
	}
	public List<Pet_member> admin_getAllMemberList(RowBounds rowBounds) {
		return memberMapper.admin_getAllMemberList(rowBounds);
	}
	public int getMemberCnt() {
		return memberMapper.getMemberCnt();
	}
	public void updatePoint(String member_id, int point) {
		memberMapper.updatePoint(member_id, point);
	}
	public void resetPoint(String member_id) {
		memberMapper.resetPoint(member_id);
	}
	public String[] admin_getAllMemberAjax() {
		return memberMapper.admin_getAllMemberAjax();
	}
	public Pet_member getMemberInfo(String member_id) {
		return memberMapper.getMemberInfo(member_id);
	}
	

}








