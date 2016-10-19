// 코드 17.2  전통적인(비스프링) JMS 방식을 이용한 메시지 수신

ConnectionFactory cf =
    new ActiveMQConnectionFactory("tcp://localhost:61616");
Connection conn = null;
Session session = null;
try {
    conn = cf.createConnection();
    conn.start();
    session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
    Destination destination =
	new ActiveMQQueue("spitter.queue");
    MessageConsumer consumer = session.createConsumer(destination);
    Message message = consumer.receive();
    TextMessage textMessage = (TextMessage) message;
    System.out.println("GOT A MESSAGE: " + textMessage.getText());
    conn.start();
} catch (JMSException e) {
    // 예외처리?
} finally {
    try {
	if (session != null) {
	    session.close();
	}
	if (conn != null) {
	    conn.close();
	}
    } catch (JMSException ex) {
    }
}
