// 코드 20.2  NotificationPublisher를 이용한 JMX 통지 전송

package com.habuma.spittr.jmx;
import javax.management.Notification;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
@ManagedResource("spitter:name=SpitterNotifier")
@ManagedNotification(
		     notificationTypes="SpittleNotifier.OneMillionSpittles",
		     name="TODO")
public class SpittleNotifierImpl
    implements NotificationPublisherAware, SpittleNotifier {  // Notification PublisherAware 구현

    private NotificationPublisher notificationPublisher;

    public void setNotificationPublisher(  // NotificationPublisher 주입
					 NotificationPublisher notificationPublisher) {
	this.notificationPublisher = notificationPublisher;
    }

    public void millionthSpittlePosted() {
	notificationPublisher.sendNotification(  // 통지 전송
					       new Notification(
								"SpittleNotifier.OneMillionSpittles", this, 0));
    }

}
