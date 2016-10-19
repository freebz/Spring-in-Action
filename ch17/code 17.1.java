// 코드 17.1  전통적인(비스프링) JMS 방식을 이용한 메시지 전송

ConnectionFactory cf =
    new ActiveMQConnectionFactory("tcp://localhost:61616");
Connection conn = null;
Session session = null;
try {
    conn = cf.createConnection();
    session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
    Destination destination = new ActiveMQQueue("spitter.quque");
    MessageProducer producer = session.createProducer(destination);
    TextMessage message = session.createTextMessage();

    message.setText("Hello world!");
    producer.send(message);  // 메시지 전송
} catch (JMSException e) {
    // handle exception?
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
