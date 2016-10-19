// 스프링 환경에 대해 더 살펴보기

@Bean
public BlankDisc disc() {
    return new BlankDisc(
			 env.getProperty("disc.title", "Rattle and Hum"),
			 env.getProperty("disc.artist", "U2"));
}

// Integer 형으로 변환
int connectionCount =
    env.getProperty("db.connection.count", Integer.class, 30);


// 필수지정 지정되지 않을 경우 IllegalStateException이 발생
@Bean
public BlankDisc disc() {
    return new BlankDisc(
			 env.getRequiredProperty("disc.title"),
			 env.getRequiredProperty("disc.artist"));
}

// 프로퍼티 존재 확인
boolean titleExists = env.containsProperty("disc.title");

// Class로 처리할 경우
Class<CompactDisc> cdClass =
    env.getPropertyAsClass("disc.class", CompactDisc.class);
