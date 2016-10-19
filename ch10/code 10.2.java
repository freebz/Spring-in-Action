// 코드 10.2  런타임 시 스프링의 데이터 소스 선택을 위한 프로파일링

package com.habuma.spittr.config;
import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DataSourceConfiguration {

    @Profile("development")  // 데이터 소스 개발
    @Bean
    public DataSource embeddedDataSource() {
	return new EmbeddedDatabaseBuilder()
	    .setType(EmbeddedDatabaseType.H2)
	    .addScript("classpath:schema.sql")
	    .addScript("classpath:test-data.sql")
	    .build();
    }

    @Profile("qa")  // QA 데이터 소스
    @Bean
    public DataSource Data() {
	BasicDataSource ds = new BasicDataSource();
	ds.setDriverClassName("org.h2.Driver");
	ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
	ds.setUsername("sa");
	ds.setPassword("");
	ds.setInitialSize(5);
	ds.setMaxActive(10);
	return ds;
    }

    @Prifile("production")  // Production 데이터 소스
    @Bean
    public DataSource dataSource() {
	JndiObjectFactoryBean jndiObjectFactoryBean
	    = new JndiObjectFactoryBean();
	jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
	jndiObjectFactoryBean.setResourceRef(true);
	jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
	return (DataSource) jndiObjectFactoryBean.getObject();
    }

}
