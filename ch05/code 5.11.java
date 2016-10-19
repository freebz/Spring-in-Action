// 코드 5.11  페이지화된 Spittle 목록을 위한 새로운 테스트 메소드

@Test
public void shouldShowPagedSpittles() throws Exception {
    List<Spittle> expectedSpittles = createSpittleList(50);
    SpittleRepository mockRepository = mock(SpittleRepository.class);
    when(mockRepository.findSpittles(238900, 50))  // max와 count 파라미터를 예상
	.thenReturn(expectedSpittles);

    SpittleController controller =
	new SpittleController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller)
	.setSingleView(
		       new InternalResourceView("/WEB-INF/views/spittles.jsp"))
	.build();

    mockMvc.perform(get("/spittles?max=238900&count=50"))  // max와 count 파라미터를 전달
	.andExpect(view().name("spittles"))
	.andExpect(modle().attributeExists("spittleList"))
	.andExpect(model().attribute("spittleList",
				     hasItems(expectedSpittles.toArray())));
}
