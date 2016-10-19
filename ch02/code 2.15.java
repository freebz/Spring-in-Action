// 2.5 설정 가져오기와 믹싱하기

// 2.5.1 JavaConfig로 XML 설정 참조하기

package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
	return new SgtPeppers();
    }

}
