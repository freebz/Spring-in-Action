// 코드 5.10  SpittleController: 모델의 최근 spittles 리스트를 얻는다.

package spittr.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(  // SpittleRepository 주입
			     SpittleRepository spittleRepository) {
	this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String spittles(Model model) {
	model.addAttribute(  // spittles를 모델에 추가
			   spittleRepository.findSpittles(
							  Long.MAX_VALUE, 20));
	return "spittles";  // 뷰 이름 반환
    }

}
