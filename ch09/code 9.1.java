// 코드 9.1  스프링 MVC 웹 보안을 화럿ㅇ화하는 가장 간단한 클래스 설정

package spitter.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.
    configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.
    configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity  // 웹 보안 활성
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
