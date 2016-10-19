// 코드 13.1  @EnableCaching을 사용하여 애너테이션 주도 캐싱 사용하기

package com.habuma.cachefun;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching  // 캐싱 할성화
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {  // 캐시 매니저 선언
	return new ConcurrentMapCacheManager();
    }
}
