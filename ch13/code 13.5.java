// 코드 13.5  CompositeCacheManager는 캐시 매니저 리스트를 반복한다.

@Bean
public CacheManager cacheManager(
				 net.sf.ehcache.CacheManager cm,
				 javax.cache.CacheManager jcm) {

    CompositeCacheManager cacheManager = new CompositeCacheManager();  // CompositeCacheManager 생성
    List<CacheManager> managers = new ArrayList<CacheManager>();
    managers.add(new JCacheCacheManager(jcm));
    managers.add(new EhCacheCacheManager(cm));
    managers.add(new RedisCacheManager(redisTemplate()));
    cacheManager.setCacheManagers(managers);  // 개별 캐시 매니저 추가
    return cacheManager;
}
