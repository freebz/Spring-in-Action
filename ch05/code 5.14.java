// 코드 5.14  폼을 표시하는 컨트롤러 메소드 테스트

@Test
public void shouldShowRegistration() throws Exception {
    SpitterController controller = new SpitterController();
    MockMvc mockMvc = standaloneSetup(controller).build();  // MockMvc 설정

    mockMvc.perform(get("/spitter/register"))
	.andExpect(view().name("registerForm"));  // registerForm 뷰 검사
}
