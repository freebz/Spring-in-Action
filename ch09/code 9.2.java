// 코드 9.2  스프링 MVC에서 웹 보안을 활성화하기 위한 가장 간단한 클래스 설정

package spitter.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.
    configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.
    configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity  // 스프링 MVC 보안 활성
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
