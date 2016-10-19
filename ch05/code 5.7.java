// 코드 5.7  HomeController의 @RequestMapping 분할하기

package spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")  // /에 매핑
public class HomeController {

    @Requestmapping(method=GET)  // GET 요청 처리
    public String home() {
	return "home";  // 뷰 이름은 home
    }
}
