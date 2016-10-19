// 코드 7.2  필터도 등록할 수 있는 WebApplicationInitializer

@Override
public void onStartup(ServletContext servletContext)
    throws ServletException {

    javax.servlet.FilterRegistration.Dynamic filter =
	servletContext.addFilter("myFilter", MyFilter.class);  // 필터 등록

    filter.addMappingForUrlPatterns(null, false, "/custom/*");  // 필터 매핑 추가
}
