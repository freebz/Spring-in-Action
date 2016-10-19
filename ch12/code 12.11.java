// 코드 12.11  그래프 데이터베이스에서 Item은 노드로 표시된다.

package orders;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity  // Item은 노드
public class Item {

    @GraphId
    private Long id;
    private String product;
    private double price;
    private int quantity;

}
