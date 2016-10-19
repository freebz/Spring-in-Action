// 코드 5.1  DispatcherServlet 설정하기

package spittr.config;
import org.springframework.web.servlet.support.
    AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {  // DispatcherServlet을 /에 매핑
	return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {  // 설정 클래스를 명시
	return new Class<?>[] { WebConfig.class };
    }

}
