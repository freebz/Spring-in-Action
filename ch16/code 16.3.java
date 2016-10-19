// 코드 16.3  @RestController 애너테이션 사용하기

package spittr.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

@RestController  // 기본 메시지 변환
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING="9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
	this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Spittle> spittles(
				  @RequestParam(value="max",
						defaultValue=MAX_LONG_AS_STRING) long max,
				  @RequestParam(value="count", defaultValue="20") int count) {

	return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(
		    method=RequestMethod.POST
		    consumes="application/json")
    public Spittle saveSpittle(@RequestBody Spittle spittle) {
	return spittleRepository.save(spittle);
    }

}
