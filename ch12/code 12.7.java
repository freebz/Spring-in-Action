// 코드 12.7  자동 저장소에 맞춤형 저장소 기능 혼합하기

package orders.db;
import java.util.List;
import orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class OrderRepositoryImpl implements OrderOperations {
    @Autowired
    private MongoOperations mongo;  // MongoOperations 주입

    public List<Order> findOrdersByType(String t) {
	String type = t.equals("NET") ? "WEB" : t;

	Criteria where = Criteria.where("type").is(t);  // 쿼리 생성
	Query query = Query.query(where);

	return mongo.find(query, Order.class);  // 쿼리 수행
    }

}
