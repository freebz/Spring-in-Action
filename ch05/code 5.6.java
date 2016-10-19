// 코드 5.6  수정된 HomeControllerTest

package spittr.web;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.web.HomeController;

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
	HomeController controller = new HomeController();
	MockMvc mockMvc =  // MockMvc 셋업
	    standaloneSetup(controller).build();

	mockMvc.perform(get("/"))  // GET / 수행
	    .andExpect(view().name("home"));  // 홈뷰를 보여줌
    }
    
}
