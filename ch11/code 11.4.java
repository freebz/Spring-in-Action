// 코드 11.4  스프링 데이터를 사용하여 인터페이스 정의에서 저장소 만들기

public interface SpitterRepository
    extends JpaRepository<Spitter, Long> {
}
