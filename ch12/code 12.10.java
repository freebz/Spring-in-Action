// 코드 12.10  Order는 그래프 데이터베이스에서 노드로 애너테이션되지 않는다.

package orders;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity  // Order는 노드
public class Order {

    @GraphId  // 그래프 ID
    private Long id;
    private String customer;
    private String type;

    @RelatedTo(type="HAS_ITEMS")  // 아이템의 관계
    private Set<Item> items = new LinkedHashSet<Item>();

}
