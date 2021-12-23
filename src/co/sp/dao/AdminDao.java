package co.sp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.sp.beans.Pet_admin;
import co.sp.mapper.AdminMapper;

@Repository
public class AdminDao {
	
	@Autowired
	AdminMapper adminMapper;
	
	public Pet_admin getLoginAdminInfo(Pet_admin tempLoginUserBean) {
		return adminMapper.getLoginUserInfo(tempLoginUserBean);
		
	}

	public String checkAdminIdExist(String admin_id) {
		return adminMapper.checkAdminIdExist(admin_id);
	}

	public void addAdminInfo(Pet_admin addAdminBean) {
		adminMapper.addAdminInfo(addAdminBean);
	}

	public Pet_admin getAdminInfo(String admin_id) {
		return adminMapper.getAdminInfo(admin_id);
	}

	public List<Pet_admin> getAllAdminInfo() {
		return adminMapper.getAllAdminInfo();
	}

	public void modifyAdminInfo(Pet_admin admin) {
		adminMapper.modifyAdminInfo(admin);
	}

	public void deleteAdminInfo(String admin_id) {
		adminMapper.deleteAdminInfo(admin_id);
	}

}
