// 코드 5.16  폼 처리 컨트롤러를 테스트하는 메소드

@Test
public void shouldProcessRegistration() throws Exception {
    SpitterRepository mockRepository =
	mock(SpitterRepository.class);  // 모사 저장소 설정
    Spitter unsaved =
	new Spitter("jbauer", "24hours", "Jack", "Bauer");
    Spitter saved =
	new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
    when(mockRepository.save(unsaved)).thenReturn(saved);

    SpitterController controller =
	new SpitterController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller).build();  // MockMvc 설정

    mockMvc.perform(post("/spitter/register")  // 요청 수행
		    .param("firstName", "Jack")
		    .param("lastName", "Bauer")
		    .param("username", "jbauer")
		    .param("password", "24hours"))
	.andExpect(redirectedUrl("/spitter/jbauer"));

    verify(mockRepository, atLeastOnce()).save(unsaved);  // 저장 검증
}
