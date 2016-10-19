// 코드 16.1  RESTful 스프링 MVC 컨트롤러

package spittr.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING="922337203685477807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
	this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle spittles(
				 @RequestParam(value="max",
					       defaultValue=MAX_LONG_AS_STRING) long max,
				 @RequestParam(value="count", defaultValue="20") int count) {
	return spittleRepository.findSpittles(max, count);
    }

}
