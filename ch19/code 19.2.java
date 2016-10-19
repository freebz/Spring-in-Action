// 코드 19.2  MimeMessageHelper를 사용하여 첨부를 포함한 이메일 메시지 보내기

public void sendSpittleEmailWithAttachment(
					   String to, Spittle spittle) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper =
	new MimeMessageHelper(message, true);  // 메시지 헬퍼 생성
    String spitterName = spittle.getSpitter().getFullName();
    helper.setFrom("noreply@spitter.com");
    helper.setTo(to);
    helper.setSubject("New spittle from " + spitterName);
    helper.setText(spitterName + " says: " + spittle.getText());
    FileSystemResource couponImage =
	new FileSystemResource("/collateral/coupon.png");
    helper.addAttachment("Coupon.jpg", couponImage);  // 첨부 추가
    mailSender.send(message);
}
