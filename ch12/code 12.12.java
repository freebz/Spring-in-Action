// 코드 12.12  LineItem은 Order 노드와 Product 노드를 연결한다.

package orders;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type="HAS_LINE_ITEM_FOR")  // LineItem은 관계를 나타냄
public class LineItem {

    @GraphId  // 그래프 ID
    private Long id;

    @StartNode  // 시작 노드
    private Order order;

    @EndNode  // 종단 노드
    private Product product;

    private int quantity;

}
