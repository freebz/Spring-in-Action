// 코드 18.9  convertAndSendToUser()는 특정 사용자에게 메시지를 전송한다.

package spittr;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpittleFeedServiceImpl implements SpittleFeedService {

    private SimpMessagingTemplate messaging;
    private Pattern pattern = Pattern.compile("\\@(\\S+)");  // 사용자가 언급한 Regex 패턴

    @Autowired
    public SpittleFeedServiceImpl(SimpMessagingTemplate messaging) {
	this.messaging = messaging;
    }

    public void broadcastSpittle(Spittle spittle) {

	messaging.convertAndSend("/topic/spittlefeed", spittle);
	Matcher matcher = pattern.matcher(spittle.getMessage());
	if (matcher.find()) {
	    String username = matcher.group(1);
	    messaging.convertAndSendToUser(  // 사용자에게 통지(notification) 보내기
					   username, "/queue/notifications",
					   new Notification("You just got mentioned!"));
	}
    }

}
