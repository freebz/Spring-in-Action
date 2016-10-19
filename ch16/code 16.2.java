// 코드 16.2  ContentNegotiationManager 설정하기

@Bean
public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
    ContentNegotiatingViewResolver cnvr =
	new ContentNegotiatingViewResolver();
    cnvr.setContentNegoiationManager(cnm);
    return cnvr;
}

@Override
public void configureContentNegotiation(
					ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.TEXT_HTML);  // HTML에 대한 기본
}

@Bean
public ViewResolver beanNameViewREsolver() {  // 빈으로서 뷰를 검색
    return new BeanNameViewResolver();
}

@Bean
public View spittles() {
    return new MappingJackson2JsonView();  // "spittles" JSON 뷰
}
