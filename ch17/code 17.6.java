// 코드 17.6  AlertServiceImpl은 JMS 메시지를 처리할 JMS가 없는 POJO다.

package com.habuma.spittr.alerts;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.habuma.spittr.domain.Spittle;

@Component("alertService")
public class AlertServiceImpl implements AlertService {

    private JavaMailSender mailSender;
    private String alertEmailAddress;
    public AlertServiceImpl(JavaMailSender mailSender,
			    String alertEmailAddress) {
	this.mailSender = mailSender;
	this.alertEmailAddress = alertEmailAddress;
    }

    public void sendSpittleAlert(final Spittle spittle) {  // Spittle 알림 전송
	SimpleMailMessage message = new SimpleMailMessage();
	String spitterName = spittle.getSpitter().getFullName();
	message.setFrom("noreply@spitter.com");
	message.setTo(alertEmailAddress);
	message.setSubject("New spittle from " + spitterName);
	message.setText(spitterName + " says: " + spittle.getText());
	mailSender.send(message);
    }

}
