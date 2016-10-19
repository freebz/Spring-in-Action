// 코드 12.14  OrderRepository로 맞춤형 기능들을 혼합하기

package orders.db;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import orders.Order;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.template.Neo4fOperations;

public class OrderRepositoryImpl implements Order Operations {  // 중간 형태의 인터페이스 구현

    private final Neo4jOperations neo4j;

    @Autowired
    public OrderRepositoryImpl(Neo4jOperations neo4j) {  // Neo4jOperations 주입
	this.neo4j = neo4j;
    }

    public List<Order> findSiAOrders() {
	Result<Map<String, Object>> result = neo4j.query(  // 쿼리 수행
							 "match (o:Order)-[:HAS_ITEMS]->(i:Item) " +
							 "where i.product='Spring in Action' return o");
	
	EndResult<Order> endResult = result.to(Order.class);  // EndResult<Order>로 변경

	return IteratorUtil.asList(endResult);  // List<Order>로 변경
    }

}
