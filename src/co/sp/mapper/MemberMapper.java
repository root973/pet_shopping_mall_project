package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_member;
//pet_member table과 상호작용하는 쿼리문모음
public interface MemberMapper {
	
	//서버에 고객정보 추가
	@Insert("insert into pet_member " +
			"values(#{member_id}, #{pass}, #{name}, #{birth}, 'm', #{phone}, #{email}, #{zip_code}, #{address}, #{address_detail}, 500)")
	void insertMemberInfo(Pet_member insertMember);
	//id 중복검사
	@Select("select name " +
			"from pet_member " +
			"where member_id = #{member_id}")
	String checkUserIdExist(String member_id);
	
	//로그인시 고객정보 가져오기
	@Select("select * from pet_member where member_id=#{member_id} and pass=#{pass}")
	Pet_member getLoginUserInfo(Pet_member tempLoginUserBean);
	
	//비번인증
	@Select("select pass from pet_member where member_id=#{member_id} and name=#{name}")
	String certify(Pet_member certifyUserBean);
	
	//고객 개인정보 수정시 정보 가져오기
	@Select("select * from Pet_member where member_id=#{member_id}")
	Pet_member getModifyUserInfo(String member_id);
	
	//id찾기
	@Select("select member_id from pet_member where name=#{name} and email=#{email}")
	String searchId(Pet_member srcMemberBean);
	
	//비번찾기
	@Select("select pass from pet_member where member_id=#{member_id} and name=#{name} and email=#{email}")
	String searchPass(Pet_member srcMemberBean);
	
	//고객 개인정보 수정(비밀번호, 이메일, 주소)
	@Update("update pet_member set pass=#{pass}, email=#{email}, address=#{address} where member_id=#{member_id} and name=#{name}")
	void modifyUserInfo(Pet_member modifyUserBean);
	
	//물건구매시 고객 보유포인트 변동사항 적용
	@Update("update pet_member set point = point + #{point} where member_id=#{member_id}")
	void client_modifyPoint(@Param("point")int point, @Param("member_id")String member_id);
	
	//고객 회원탈퇴
	@Delete("delete from pet_member where member_id=#{member_id}")
	void deleteMember(String member_id);
	
	//관리자페이지에서 전체고객정보 가져오기(RowBounds가 적용되어있다)
	@Select("select * from pet_member")
	List<Pet_member> admin_getAllMemberList(RowBounds rowBounds);
		
	//관리자페이지 고객정보페이지 페이징을 위한 고객정보갯수 반환
	@Select("select count(*) from pet_member")
	int getMemberCnt();
	
	//관리자페이지 고객 보유포인트 변동사항 적용
	@Update("update pet_member set point=#{point} where member_id=#{member_id}")
	void updatePoint(@Param("member_id")String member_id, @Param("point")int point);
		
	//관리자페이지 보유포인트 변동사항 적용
	@Update("update pet_member set point='0' where member_id=#{member_id}")
	void resetPoint(String member_id);
	
	//관리자페이지에서 고객검색을 위한 쿼리
	@Select("select member_id from pet_member")
	String[] admin_getAllMemberAjax();
	
	//고객 개인정보 전체 가져오기
	@Select("select * from Pet_member where member_id=#{member_id}")
	Pet_member getMemberInfo(String member_id);
	
}
