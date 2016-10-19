// 코드 18.5  @EnableWebSocketMessageBroker는 웹 소켓을 통해 STOMP를 사용한다.

package marcopolo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.
    AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.
    EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.
    StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker  // STOMP 메시징 사용
public class WebSocketStompConfig
    extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
	registry.addEndpoint("/marcopolo").withSockJS();  // /marcopolo를 통해 SockJS 사용
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
	registry.enableSimpleBroker("/queue", "/topic");
	registry.setApplicationDestinationPrefixes("/app");
    }

}
