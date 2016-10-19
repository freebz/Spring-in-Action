// 코드 3.1  활성화 파일에 기반을 둔 빈을 와이어링하는 @Profile 애너테이션

package com.myapp;
import javax.activation.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DataSourceConfig {

    @Bean(destroyMethod="shutdown")
    @Profile("dev")    // "dev" 프로파일 와이어링
    public DataSource embeddedDataSource() {
	return new EmbeddedDatabaseBuilder()
	    .setType(EmbeddedDatabaseType.H2)
	    .addScript("classpath:schema.sql")
	    .addScript("classpath:test-data.sql")
	    .build();
    }

    @Bean
    @Profile("prod")   // "prod" 프로파일 와이어링
    public DataSource jndiDataSource() {
	JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
	jndiObjectFactoryBean.setJndiName("jdbc/myDS");
	jndiObjectFactoryBean.setResourceRef(true);
	jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
	return (DataSource) jndiObjectFactoryBean.getObject();
    }

}
