package co.sp.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import co.sp.beans.Pet_admin;
import co.sp.beans.Pet_member;
import co.sp.interceptor.AdminInterceptor;
import co.sp.interceptor.AdminLoginInterceptor;
import co.sp.interceptor.CartInterceptor;
import co.sp.interceptor.ClientInterceptor;
import co.sp.interceptor.LoginInterceptor;
import co.sp.mapper.AdminMapper;
import co.sp.mapper.BoardMapper;
import co.sp.mapper.CartMapper;
import co.sp.mapper.GoodsMapper;
import co.sp.mapper.MemberMapper;
import co.sp.mapper.OrderListMapper;
import co.sp.mapper.QnaMapper;
import co.sp.mapper.ReviewMapper;
import co.sp.service.CartService;

@Configuration
@EnableWebMvc

@ComponentScan("co.sp.controller")
@ComponentScan("co.sp.dao")
@ComponentScan("co.sp.service")

@PropertySource("/WEB-INF/properties/db.properties")
public class ServletContext implements WebMvcConfigurer {

	// DB 접속 시 필요한 정보들 저장
	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	@Resource(name = "loginBean")
	private Pet_member loginBean;
	
	@Resource(name = "adminBean")
	private Pet_admin adminBean;
	
	@Autowired
	private CartService cartService;

	// Mapping경로단순화를 위한 viewResolvers
	@Override
	public void configureViewResolvers(ViewResolverRegistry re) {
		WebMvcConfigurer.super.configureViewResolvers(re);
		re.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적데이터 연동을 위한 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}

	// DB 접속 정보 관리
	@Bean
	public BasicDataSource dataSource() {

		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);

		return source;
	}

	// 쿼리문과 접속 관리하는 객체
	@Bean
	public SqlSessionFactory fac(BasicDataSource source) throws Exception {

		SqlSessionFactoryBean f = new SqlSessionFactoryBean();
		f.setDataSource(source);

		SqlSessionFactory fac = f.getObject();
		return fac;
	}

	// 쿼리문 등록
	@Bean
	public MapperFactoryBean<MemberMapper> getMemberMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<MemberMapper> f = new MapperFactoryBean<MemberMapper>(MemberMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	@Bean
	public MapperFactoryBean<GoodsMapper> getGoodsMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<GoodsMapper> f = new MapperFactoryBean<GoodsMapper>(GoodsMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	@Bean
	public MapperFactoryBean<OrderListMapper> getOrderMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<OrderListMapper> f = new MapperFactoryBean<OrderListMapper>(OrderListMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<BoardMapper> f = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	@Bean
	public MapperFactoryBean<CartMapper> getCartMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<CartMapper> f = new MapperFactoryBean<CartMapper>(CartMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	@Bean
	public MapperFactoryBean<ReviewMapper> getReviewMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<ReviewMapper> f = new MapperFactoryBean<ReviewMapper>(ReviewMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	@Bean
	public MapperFactoryBean<QnaMapper> getQnaMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<QnaMapper> f = new MapperFactoryBean<QnaMapper>(QnaMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}
	
	@Bean
	public MapperFactoryBean<AdminMapper> getAdminMapper(SqlSessionFactory fac) throws Exception {

		MapperFactoryBean<AdminMapper> f = new MapperFactoryBean<AdminMapper>(AdminMapper.class);
		f.setSqlSessionFactory(fac);
		return f;

	}

	// 인터셉터 생성 코드
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		AdminInterceptor adminInterceptor = new AdminInterceptor(adminBean);
		InterceptorRegistration admin_reg = registry.addInterceptor(adminInterceptor);
		admin_reg.addPathPatterns("/admin/**");
		
		AdminLoginInterceptor adminLoginInterceptor=new AdminLoginInterceptor(adminBean);
		InterceptorRegistration adLogin_reg=registry.addInterceptor(adminLoginInterceptor);
		adLogin_reg.addPathPatterns("/admin/**");
		adLogin_reg.excludePathPatterns("/admin/login", "/admin/login_pro","/admin/login_success",
				"/admin/login_fail", "/admin", "/admin/","/admin/logout");
		
		ClientInterceptor clientInterceptor = new ClientInterceptor(loginBean);
		InterceptorRegistration client_reg = registry.addInterceptor(clientInterceptor);
		client_reg.addPathPatterns("/**");
		client_reg.excludePathPatterns("/admin/**");

		LoginInterceptor loginInterceptor = new LoginInterceptor(loginBean);
		InterceptorRegistration login_reg = registry.addInterceptor(loginInterceptor);
		login_reg.addPathPatterns("/member/modify", "/member/logout");

		CartInterceptor cartInterceptor = new CartInterceptor(loginBean, cartService);
		InterceptorRegistration cart_reg = registry.addInterceptor(cartInterceptor);
		cart_reg.addPathPatterns("/cart/list");

	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// 에러메세지 프로퍼티 설정을 위한 객체생성
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message");
		return res;
	}

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
