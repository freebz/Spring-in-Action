// 코드 21.8  그루비로 작성된 ContactController는 자바보다 간결하다.

@Grab("thymeleaf-spring4")  // Thymeleaf 의존성 확보

@Controller
@RequestMapping("/")
class ContactController {

  @Autowired
  ContactRepository contactRepo  // ContactRepository 주입

  @RequestMapping(method=RequestMethod.GET)  // GET / 처리
  String home(Map<String,Object> model) {
    List<Contact> contacts = contactRepo.findAll()
    model.putAll([contacts: contacts])
    "home"
  }

  @RequestMapping(method=RequestMethod.POST)  // POST / 처리
  String submit(Contact contact) {
    contactRepo.save(contact)
    "redirect:/"
  }

}
