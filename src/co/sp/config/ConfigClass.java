package co.sp.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@PropertySource("/WEB-INF/properties/path.properties")
public class ConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	   
		@Value("${basic.img.path}")
		private String basic_img_path;
	
	   protected String[] getServletMappings() {
	      // TODO Auto-generated method stub
	      return new String[] {"/"};
	   }
	   
	   
	   protected Class<?>[] getServletConfigClasses() {
	      // TODO Auto-generated method stub
	      return new Class[] {ServletContext.class};
	   }
	   
	   
	   protected Class<?>[] getRootConfigClasses() {
	      // TODO Auto-generated method stub
	      return new Class[] {RootContext.class};
	   }
	   
	   protected Filter[] getServletFilters() {
	      // TODO Auto-generated method stub
	      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
	      encodingFilter.setEncoding("UTF-8");
	      return new Filter[] {encodingFilter};
	   }
	   
	   //파일크기 20mb로 설정
	   private static int MAX_FILE_ZIZE = 20 * 1024 * 1024;
	   
	   @Override
		protected void customizeRegistration(Dynamic registration) {
			// TODO Auto-generated method stub
			super.customizeRegistration(registration);
			//임시저장경로, 파일당최대 크기, 총파일크기 설정
			MultipartConfigElement config1 = new MultipartConfigElement(basic_img_path, MAX_FILE_ZIZE, MAX_FILE_ZIZE, 0);
			registration.setMultipartConfig(config1);
		}
	   
	}

//public class SpringConfigClass implements WebApplicationInitializer{
//
// 
// public void onStartup(ServletContext servletContext) throws ServletException {
//    // TODO Auto-generated method stub
//    
//    AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
//    
//    servletContext.register(ServletContext.class);
//    
//    
//    DispatcherServlet dispatcherServlet = new DispatcherServlet(servletContext);
//    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//    
//    
//    servlet.setLoadOnStartup(1);
//    servlet.addMapping("/");
//    
//    
//    AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//    rootAppContext.register(RootContext.class);
//    
//    ContextLoaderListener listener = new ContextLoaderListener(rootContext);
//    servletContext.addListener(listener);
//    
//    
//    FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//    filter.setInitParameter("encoding", "UTF-8");
//    filter.addMappingForServletNames(null, false, "dispatcher");
// }
//}