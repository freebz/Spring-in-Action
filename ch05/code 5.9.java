// 코드 5.9  /spittles의 GET 요청 처리를 위한 SpittleController 테스트하기

@Test
public void shouldShowRecentSpittles() throws Exception {
    List<Spittle> expectedSpittles = createSpittleList(20);
    SpittleRepository mockRepository =  // Mock 저장소
	mock(SpittleRepository.class);
    when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
	.thenREturn(expectedSpittles);

    SpittleController controller =
	new SpittleController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller)  // Mock 스프링 MVC
	.setSingleView(
		       new InternalResourceView("/WEB-INF/views/spittles.jsp"))
	.build();

    mockMvc.perform(get("/spittles"))  // /spittles 확보
	.andExpect(view().name("spittles"))
	.andExpect(model().attributeExists("spittleList"))
	.andExpect(model().attribute("spittleList",  // Assert 예상
				     hasItems(expectedSpittles.toArray())));
}

private List<Spittle> createSpittleList(int count) {
    List<Spittle> spittles = new ArrayList<Spittle>();
    for (int i=0; i < count; i++) {
	spittles.add(new Spittle("Spittle " + i, new Date()));
    }
    return spittles;
}
