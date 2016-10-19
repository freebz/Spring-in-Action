// 코드 19.1  MailSender를 이용해 스프링으로 이메일 전송하기

@Autowired
JavaMailSender mailSender;

public void sendSimpleSpittleEmail(String to, Spittle spittle) {
    SimpleMailMessage message = new SimpleMailMessage();  // 메시지 구성
    String spitterName = spittle.getSpitter().getFullName();
    message.setFrom("noreply@spitter.com");  // 이메일 주소
    message.setTo(to);
    message.setSubject("New spittle from " + spitterName);
    message.setText(spitterName + " says: " +  // 메시지 텍스트 설정
		    spittle.getText());
    mailSender.send(message);  // 메일 전송
}
