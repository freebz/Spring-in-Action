// 코드 6.1  타일 정의를 결정하기 위한 TilesConfigurer 설정하기

@Bean
public TilesConfigurer tilesConfigurer() {
    TitlesConfigurer tiles = new TitlesConfigurer();  // 타일 정의
    tiles.setDefinitions(new String[] {  // 위치 명시
	    "/WEB-INF/layout/tiles.xml"
	});
    tiles.setCheckREfresh(true);  // 리프레시를 가능하게 설정
    return tiles;
}
