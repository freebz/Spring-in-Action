// 코드 12.3  인증된 MongoDB 서버로 액세스하기 위해 MongoClient 만들기

@Autowired
private Environment env;

@Override
public Mongo mongo() throws Exception {
    MongoCredential credential =
	MongoCredential.createMongoCRCredential(  // MongoDB 자격 만들기
						env.getProperty("mongo.username"),
						"OrdersDB",
						env.getProperty("mongo.password").toCharArray());

    return new MongoClient(  // MongoClient 만들기
			   new ServerAddress("localhost", 37017),
			   Arrays.asList(credential));
}
