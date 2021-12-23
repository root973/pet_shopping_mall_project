package co.sp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sp.beans.Pet_admin;
import co.sp.dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Resource(name="adminBean")
	private Pet_admin adminBean;

	public void getLoginAdminInfo(Pet_admin tempLoginUserBean) {
		Pet_admin tempLoginUserBean2 = adminDao.getLoginAdminInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			adminBean.setAdmin_id(tempLoginUserBean2.getAdmin_id());
			adminBean.setName(tempLoginUserBean2.getName());
			adminBean.setPosition(tempLoginUserBean2.getPosition());
			adminBean.setAdminLogin(true);
		}
	}

	public boolean checkAdminIdExist(String admin_id) {
		String admin_name = adminDao.checkAdminIdExist(admin_id);
		
		if(admin_name == null) {
			return true;
		}else {
			return false;
		}
	}

	public void addAdminInfo(Pet_admin addAdminBean) {
		adminDao.addAdminInfo(addAdminBean);	
	}

	public Pet_admin getAdminInfo(String admin_id) {
		return adminDao.getAdminInfo(admin_id);
	}

	public List<Pet_admin> getAllAdminInfo() {
		return adminDao.getAllAdminInfo();
	}

	public void modifyAdminInfo(Pet_admin admin) {
		adminDao.modifyAdminInfo(admin);
	}

	public void deleteAdminInfo(String admin_id) {
		adminDao.deleteAdminInfo(admin_id);
	}
	
	
	
}
