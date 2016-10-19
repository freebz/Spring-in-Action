// 코드 17.7  RabbitTemplate을 사용하여 Spittle 보내기

package com.habuma.spitter.alerts;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.habuma.spitter.domain.Spittle;

public class AlertServiceImpl implements AlertService {

    private RabbitTemplate rabbit;

    @Autowired
    public AlertServiceImpl(RabbitTemplate rabbit) {
	this.rabbit = rabbit;
    }

    public void sendSpittleAlert(Spittle spittle) {
	rabbit.convertAndSend("spittle.alert.exchange",
			      "spittle.alerts",
			      spittle);
    }

}
