// 코드 6.4  스프링에서 Thymeleaf를 지원하기 위한 자바 설정

@Bean
public ViewResolver viewResolver(  // Thymeleaf 뷰 리졸버
				 SpringTemplateEngine templateEngine) {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine);
    return viewResolver;
}

@Bean
public TemplateEngine templateEngine(  // 템플릿 엔진
				     TemplateResolver templateResolver) {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    return templateEngine;
}

@Bean
public TemplateResolver templateResolver() {  // 템플릿 리졸버
    TemplateResolver templateResolver =
	new ServletContextTemplateResolver();
    templateResolver.setPrefix("/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML5");
    return templateResolver;
}
 
