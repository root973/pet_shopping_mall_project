package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import co.sp.beans.Pet_member;
//pet_member table�� ��ȣ�ۿ��ϴ� ����������
public interface MemberMapper {
	
	//������ ������ �߰�
	@Insert("insert into pet_member " +
			"values(#{member_id}, #{pass}, #{name}, #{birth}, 'm', #{phone}, #{email}, #{zip_code}, #{address}, #{address_detail}, 500)")
	void insertMemberInfo(Pet_member insertMember);
	//id �ߺ��˻�
	@Select("select name " +
			"from pet_member " +
			"where member_id = #{member_id}")
	String checkUserIdExist(String member_id);
	
	//�α��ν� ������ ��������
	@Select("select * from pet_member where member_id=#{member_id} and pass=#{pass}")
	Pet_member getLoginUserInfo(Pet_member tempLoginUserBean);
	
	//�������
	@Select("select pass from pet_member where member_id=#{member_id} and name=#{name}")
	String certify(Pet_member certifyUserBean);
	
	//�� �������� ������ ���� ��������
	@Select("select * from Pet_member where member_id=#{member_id}")
	Pet_member getModifyUserInfo(String member_id);
	
	//idã��
	@Select("select member_id from pet_member where name=#{name} and email=#{email}")
	String searchId(Pet_member srcMemberBean);
	
	//���ã��
	@Select("select pass from pet_member where member_id=#{member_id} and name=#{name} and email=#{email}")
	String searchPass(Pet_member srcMemberBean);
	
	//�� �������� ����(��й�ȣ, �̸���, �ּ�)
	@Update("update pet_member set pass=#{pass}, email=#{email}, address=#{address} where member_id=#{member_id} and name=#{name}")
	void modifyUserInfo(Pet_member modifyUserBean);
	
	//���Ǳ��Ž� �� ��������Ʈ �������� ����
	@Update("update pet_member set point = point + #{point} where member_id=#{member_id}")
	void client_modifyPoint(@Param("point")int point, @Param("member_id")String member_id);
	
	//�� ȸ��Ż��
	@Delete("delete from pet_member where member_id=#{member_id}")
	void deleteMember(String member_id);
	
	//���������������� ��ü������ ��������(RowBounds�� ����Ǿ��ִ�)
	@Select("select * from pet_member")
	List<Pet_member> admin_getAllMemberList(RowBounds rowBounds);
		
	//������������ ������������ ����¡�� ���� ���������� ��ȯ
	@Select("select count(*) from pet_member")
	int getMemberCnt();
	
	//������������ �� ��������Ʈ �������� ����
	@Update("update pet_member set point=#{point} where member_id=#{member_id}")
	void updatePoint(@Param("member_id")String member_id, @Param("point")int point);
		
	//������������ ��������Ʈ �������� ����
	@Update("update pet_member set point='0' where member_id=#{member_id}")
	void resetPoint(String member_id);
	
	//���������������� ���˻��� ���� ����
	@Select("select member_id from pet_member")
	String[] admin_getAllMemberAjax();
	
	//�� �������� ��ü ��������
	@Select("select * from Pet_member where member_id=#{member_id}")
	Pet_member getMemberInfo(String member_id);
	
}
