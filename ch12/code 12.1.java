// 코드 12.1  스프링 데이터 MongoDB용 필수 설정

package orders.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongofactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories(backPackages="orders.db")  // MongoDB 저장소 활성화
public class MongoConfig {

    @Bean
    public MongoFactoryBean mongo() {  // MongoClient 빈
	MongoFactoryBean mongo = new MongoFactoryBean();
	mongo.setHost("localhost");
	return mongo;
    }

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {  // MongoTemplate 빈
	return new MongoTemplate(mongo, "OrdersDB");
    }

}
