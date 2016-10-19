// 코드 5.13  SpitterController: 사용자가 랩에 가입할 수 있는 폼을 표시

package spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @RequestMapping(value="/register", method=GET)  // /spitter/register의 GET 요청을 처리
    public String showRegistrationForm() {
	return "registerForm";
    }

}
