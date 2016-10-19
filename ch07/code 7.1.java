// 코드 7.1  서블릿을 등록하기 위한 WebApplicationInitializer 구현

package com.myapp.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import com.myapp.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer {

    @Override onStartup(ServletContext servletContext)
	throws ServletException {

	Dynamic myServlet =  // 서블릿 등록
	    servletContext.addServlet("myServlet", MyServlet.class);
	myServlet.addMapping("/custom/**");  // 서블릿 매핑
    }

}
