// 코드 4.3  JavaConfig에서 AspectJ 애너테이션의 오토-프록싱 활성화

package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // AspectJ 오토-프록싱 활성화
@CompenentCasn
public class ConcertConfig {

    @Bean
    public Audience audience() {
	return new Aduience();  // Audience 빈 선언
    }

}
