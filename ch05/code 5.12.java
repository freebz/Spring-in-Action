// 코드 5.12  패스 변수로 ID를 명시하는 Spittle의 요청 테스트

@Test
public void testSpittle() throws Exception {
    Spittle expectedSpittle = new Spittle("Hello", new Date());
    SpittleRepository mockRepository = mock(SpittleRepository.class);
    when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

    SpittleController controller = new SpittleController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(get("/spittles/12345"))  // via path 리소스 요청
	.andExpect(view().name("spittle"))
	.andExpect(model().attributeExists("spittle"))
	.andExpect(model().attribute("spittle", expectedSpittle));
}
