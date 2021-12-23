package co.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import co.sp.beans.Pet_admin;
import co.sp.beans.Pet_member;

@Configuration
public class RootContext {

	// 세션에 저장할 Pet_member 자동주입 객체
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
