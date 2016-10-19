// 프로퍼티 플레이스홀더 처리하기

public BlankDisc(
		 @Value("${disc.title}") String title,
		 @Value("${disc.artist}") String artist) {
    this.title = title;
    this.artist = artist;
}

// PropertyPlaceholderConfigurer 또는 PropertySourcesPlaceholderConfigurer 빈 설정 필요
@Bean
public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
}
