// 코드 5.2  최소화되어 있지만 유용한 스프링 MVC 설정

package spittr.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.
    DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.
    WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.
    InternalResourceViewResolver;

@Configuration
@EnableWebMvc  // Spring MVC 활성화
@ComponentScan("spittr.web")  // component-scanning 활성화
public class WebConfig
    extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver resolver =  // JSP 뷰 리졸버 설정
	    new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setExposeContextBeansAsAttributes(true);
	return resolver;
    }

    @Override
    public void configureDefaultServletHandling (  // 정적 콘텐츠 처리 설정
						 DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }

}
