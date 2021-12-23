package co.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import co.sp.beans.Pet_admin;
import co.sp.beans.Pet_member;

@Configuration
public class RootContext {

	// ���ǿ� ������ Pet_member �ڵ����� ��ü
	@Bean("loginBean")
	@SessionScope
	public Pet_member loginBean() {
		return new Pet_member();
	}

	@Bean("adminBean")
	@SessionScope
	public Pet_admin adminBean() {
		return new Pet_admin();
	}

}
