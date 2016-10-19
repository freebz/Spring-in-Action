// 코드 9.3  인메모리 사용자 저장소를 사용하기 위한 스프링 시큐리티 설정

package spitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.
    authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.
    configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.
    configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {

	auth
	    .inMemoryAuthentication()  // 인메모리 사용자 저장소 활성
	    .withUser("user").password("password").roles("USER").and()
	    .withUser("admin").password("password").roles("USER", "ADMIN");
    }

}
