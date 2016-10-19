// 코드 21.3  연락처 애플리케이션의 기본적인 웹 요청을 처리하는 ContactController

package contacts;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframewrok.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ContactController {
    private ContactRepository contactRepo;

    @Autowired
    public ContactController(ContactRepository contactRepo) {  // ContactRepository 주입
	this.contactRepo = contactRepo;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Map<String,Object> model) {  // GET / 처리
	List<Contact> contacts = contactRepo.findAll();
	model.put("contacts", contacts);
	return "home";
    }
    @RequestMapping(method=RequestMethod.POST)  // POST / 처리
    public String submit(Contact contact) {
	contactRepo.save(contact);
	return "redirect:/";
    }

}
