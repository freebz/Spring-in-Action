// 코드 18.2  자바 설정에서 웹 소켓을 활성화하고 메시지 핸들러를 매핑한다.

package marcopolo;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(
					  WebSocketHandlerRegistry registry) {
	registry.addHandler(marcoHandler(), "/marco");  // "/marco"로 MarcoHandler를 매핑
    }

    @Bean
    public MarcoHandler marcoHandler() {  // MarcoHandler 빈 선언
	return new MarcoHandler();
    }

}
