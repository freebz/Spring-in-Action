// 코드 17.3  JmsTemplate을 이용한 Spittle 전송

package com.habuma.spittr.alerts;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jsm.core.MessageCreator;
import com.habuma.spittr.domain.Spittle;

public class AlertServiceImpl implements AlertService {

    private JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {  // JMS 템플릿 주입
	this.jmsOperations = jmsOperations;
    }

    public void sendSpittleAlert(final Spittle spittle) {
	jmsOperations.send(  // 메시지 전송
			   "spittle.alert.queue",  // 목적지 지정
			   new MessageCreator() {
			       public Message createMessage(Session session)
				   throws JMSException {
				   
				   return session.createObjectMessage(spittle);  // 메시지 생성
			       }
			   }
			     );
    }

}
