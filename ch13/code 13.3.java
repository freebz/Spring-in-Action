// 코드 13.3  자바 설정에서 EhCacheCacheManager 설정하기

package com.habuma.cachefun;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheingConfig {

    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm) {  // EhCacheCacheManager 설정
	return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {  // EhCacheManagerFactoryBean
	EhCacheManagerFactoryBean ehCacheFactoryBean =
	    new EhCacheCacheManagerFactoryBean();
	ehCacheFactoryBean.setConfigLocation(
					     new ClassPathResource("com/habuma/spittr/cache/ehcache.xml"));
	return ehCacheFactoryBean;
    }

}
