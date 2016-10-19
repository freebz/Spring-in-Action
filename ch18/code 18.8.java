// 코드 18.8  SimpMessagingTemplate은 메시지를 전송한다.

package spittr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class SpittleFeedServiceImpl implements SpittleFeedService {

    private SimpMessageSendingOperations messaging;

    @Autowired
    public SpittleFeedServiceImpl(
				  SimpMessageSendingOperations messaging) {  // 메시징 템플릿 주입
	this.messaging = messaging;
    }

    public void broadcastSpittle(Spittle spittle) {
	messaging.convertAndSend("/topic/spittlefeed", spittle);  // 메시지 전송
    }

}
