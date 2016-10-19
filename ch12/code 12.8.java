// 코드 12.8  @EnableNeo4jRepositories로 스프링 데이터 Neo4j 설정하기

package orders.config;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@EnableNeo4jRepositories(basePackages="orders.db")  // 자동 저장소 활성화
public class Neo4jConfig extends Neo4jConfiguration {

    public Neo4jConfig() {
	setBasePackage("orders");  // 모든 베이스 패키지 세팅
    }

    @Bean(destroyMethod="shutdown")
    public GraphDatabaseService graphDatabaseService() {
	return new GraphDatabaseFactory()
	    .newEmbeddedDatabase("/tmp/graphdb");  // 임베디드 데이터베이스 패키지 설정
    }

}
