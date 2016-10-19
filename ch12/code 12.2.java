// 코드 12.2  @EnableMongoRepositories를 사용하여 스프링 데이터 MongoDB 활성화하기

package orders.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("orders.db")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {  // 데이터베이스 명 지정
	return "OrdersDB";
    }

    @Override
    public Mongo mongo() throws Exception {  // Mongo 클라이언트 생성
	return new MongoClient();
    }

}
