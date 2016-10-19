// 코드 12.6  스프링 데이터 MongoDB의 자동 저장소 인터페이스 구현하기

package orders.db;
import orders.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository
    extends MongoRepository<Order, String> {
}
