// 코드 9.5  requiresChannel() 메소드는 선택한 URL에 HTTPS를 적용한다.

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
	.authorizeRequests()
	.antMatchers("/spitter/me").hasRole("SPITTER")
	.antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
	.anyRequest().permitAll();
    .and()
	 .requiresChannel()
	 .antMatchers("/spitter/form").requiresSecure();  // HTTPS를 요구
}
