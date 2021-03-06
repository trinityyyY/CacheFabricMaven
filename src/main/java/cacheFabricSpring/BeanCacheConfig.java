package cacheFabricSpring;


import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@EnableCaching
@Configuration
@ComponentScan("cacheFabricSpring")
public class BeanCacheConfig{
	@Bean
	public org.springframework.cache.CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());	
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehCacheConfig.xml"));
		cmfb.setShared(true);
		return cmfb;
   }
}
