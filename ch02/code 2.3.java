// 코드 2.3  컴포넌트 스캐닝을 가능케 하는 @ComponentScan

package soundsystem;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CDPlayerConfig {
}
