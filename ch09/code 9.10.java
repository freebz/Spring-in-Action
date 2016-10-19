// 코드 9.10  Thymeleaf의 스프링 시큐리티 언어 등록

@Bean
public SpringTemplateEngine templateEngine(
					   TemplateResolver templateResolver) {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    templateEngine.addDialect(new SpringSecurityDialect());  // 시큐리티 언어 등록
    return templateEngine;
}
