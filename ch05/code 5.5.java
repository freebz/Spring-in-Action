// 코드 5.5  HomeControllerTest: HomeController 테스트

package spittr.web;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import spittr.web.HomeController;

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
	HomeController controller = new HomeController();
	assertEquals("home", controller.home());
    }
}
