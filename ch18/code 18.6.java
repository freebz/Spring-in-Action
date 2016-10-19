// 코드 18.6  컨트롤러의 STOMP 메시지를 처리하는 @MessageMapping

package marcopolo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MacroController {

    private static final Logger logger =
	LoggerFactory.getLogger(MarcoController.class);

    @MessageMapping("/marco")  // /app/marco 목적지에 대한 메시지 처리
    public void handleShout(Shout incoming) {
	logger.info("Received message: " + incoming.getMessage());
    }

}
