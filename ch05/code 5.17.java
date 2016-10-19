// 코드 5.17  새로운 사용자를 등록하기 위한 폼을 제출하기

package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(  // SpitterRepository 주입
			     SpitterRepository spitterRepository) {
	this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm() {
	return "registerForm";
    }

    @RequestMapping(value="/register", method=POST)
    public String processRegistration(Spitter spitter) {
	spitterRepository.save(spitter);  // Spitter 저장

	return "redirect:/spitter/" +  // 프로파일 페이지로 리다이렉션
	    spitter.getUsername();
    }
}
