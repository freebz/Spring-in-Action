// 코드 17.4  JmsTemplate을 이용한 메시지 수신

public Spittle receiveSpittleAlert() {
    try {
	ObjectMessage receivedMessage =
	    (ObjectMessage) jmsOperations.receive();  // 메시지 수신
	return (Spittle) receivedMessage.getObject();  // 객체 얻기
    } catch (JMSException jmsException) {
	throw JmsUtils.convertJmsAccessException(jmsException);  // 변환된 예외 던지기
    }
}
