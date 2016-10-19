// 코드 12.5  자바 타입을 도큐먼트에 매핑하는 스프링 데이터 MongoDB 애너테이션

package orders;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document  // 도큐먼트
public class Order {

    @Id
    private String id;  // ID 선언

    @Field("client")
    private String customer;  // 기본 필드명 오버라이드

    private String type;

    private Collection<Item> items = new LinkedHashSet<Item>();

    public String getCustomer() {
	return customer;
    }

    public void setCustomer(String customer) {
	this.customer = customer;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public Collection<Item> getItems() {
	return items;
    }

    public void setItems(Collection<Item> items) {
	this.items = items;
    }

    public String getId() {
	return id;
    }

}
