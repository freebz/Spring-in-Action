// 코드 13.4  Redis 서버에서 캐시 엔트리를 저장하기 위한 캐시 매니저 설정하기

package com.myapp;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
	return new RedisCacheManager(redisTemplate);  // Redis 캐시 매니저 빈
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {  // Redis 연결 팩토리 빈
	JedisConnectionFactory jedisConnectionFactory =
	    new JedisConnectionFactory();
	jedisConnectionFactory.afterPropertiesSet();
	return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(  // RedisTemplate 빈
						       RedisConnectionFactory redisCF) {
	RedisTemplate<String, String> redisTemplate =
	    new RedisTemplate<String, String>();
	redisTemplate.setConnectionFactory(redisCF);
	redisTemplate.afterPropertiesSet();
	return redisTemplate;
    }

}
