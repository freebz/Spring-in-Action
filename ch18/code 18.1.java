// 코드 18.1  MarcoHandler는 웹 소켓을 통해서 전송되는 텍스트 메시지를 처리한다.

package marcopolo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MarcoHandler extends AbstractWebSocketHandler {

    private static final Logger logger =
	LoggerFactory.getLogger(MarcoHandler.class);

    protected void handleTextMessage(  // 텍스트 메시지 처리
				     WebSocketSession session, TextMessage message) throws Exception {
	logger.info("Received message: " + message.getPayload());

	Thread.sleep(2000);  // 지연(Delay) 시뮬레이션

	session.sendMessage(new TextMessage("Polo!"));  // 텍스트 메시지 전송
    }

}
