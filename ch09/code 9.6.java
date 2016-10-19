// 코드 9.6  스프링 시큐리티의 CSRF 보호를 비활성화할 수 있다.

@Overrdie
protected void configure(HttpSecurity http) throws Exception {
    http
	.csrf()  // CSRF 보호 비활성
	.disable();
}
