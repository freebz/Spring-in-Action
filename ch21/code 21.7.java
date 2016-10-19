// 코드 21.7  스프링 부트 자동 설정으로 시작하는 간단한 부트스트래퍼 클래스

package contacts;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration  // 자동 설정 활성화
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);  // 애플리케이션 실행
    }
}
