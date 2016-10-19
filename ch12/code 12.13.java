// 코드 12.13  명명 규칙을 따르는 쿼리 메소드 정의하기

package orders.db;
import java.util.List;
import orders.Order;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface OrderRepository extends GraphRepository<Order> {

    List<Order> findByCustomer(String customer);  // 쿼리 메소드
    List<Order> findByCustomerAndType(String customer, String type);

}
