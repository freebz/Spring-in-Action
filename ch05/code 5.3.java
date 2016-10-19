// 코드 5.3  HomeController: 극단적으로 단순한 컨트롤러 예제

package spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  // 컨트롤러 선언
public class HomeController {

    @RequestMapping(value="/", method=GET)  // /에 대한 GET 요청을 처리
    public String home() {
	return "home";  // 뷰의 이름은 home
    }

}
