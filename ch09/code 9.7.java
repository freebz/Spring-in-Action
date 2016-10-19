// 코드 9.7  기본 로그인 페이지를 활성화시키는 formLogin() 메소드

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
	.formLogin()  // 기본 로그인 페이지 활성화
	.and()
	.authorizeRequests()
	.antMatchers("/spitter/me").hasRole("SPITTER")
	.antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
	.anyRequest().permitAll();
    .and()
	 .requiresChannel()
	 .antMatchers("/spitter/form").requiresSecure();
}
