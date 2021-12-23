package co.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import co.sp.beans.Pet_admin;

public interface AdminMapper {
	
	//�α��ν� ���������� ��������
	@Select("select * from pet_admin where admin_id=#{admin_id} and pass=#{pass}")
	Pet_admin getLoginUserInfo(Pet_admin tempLoginUserBean);
	
	//�������߰��� ���̵��ߺ�üũ
	@Select("select name from pet_admin where admin_id = #{admin_id}")
	String checkAdminIdExist(String admin_id);
	
	//�������߰�
	@Insert("insert into pet_admin (admin_id, pass, name, position) "+
			"values(#{admin_id}, #{pass}, #{name}, #{position})")
	void addAdminInfo(Pet_admin addAdminBean);
	
	//���̵�� ���������� ��������
	@Select("select * from pet_admin where admin_id=#{admin_id}")
	Pet_admin getAdminInfo(String admin_id);
	
	@Select("select * from pet_admin")
	List<Pet_admin> getAllAdminInfo();
	
	//������������ �����ڰ��� ������Ʈ
	@Update("update pet_admin set "+
			"pass = #{pass}, name = #{name}, "+
			"position = #{position}"+
			"where admin_id = #{admin_id}")
	void modifyAdminInfo(Pet_admin admin);
	
	//������������ �����ڰ��� ����
	@Delete("delete from pet_admin where admin_id = #{admin_id}")
	void deleteAdminInfo(String admin_id);
	
}
