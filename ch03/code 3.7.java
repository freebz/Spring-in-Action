// 코드 3.7  @PropertySource 애너테이션과 Environment 사용하기

package com.soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")    // 프로퍼티 소스 선언
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc() {
	return new BlankDisc(
			     env.getProperty("disc.title"),    // 프로퍼티 값 얻기
			     env.getProperty("disc.artist"));
    }

}


// app.properties
disc.title=Sgt. Peppers Lonely Hearts Club Band
disc.artist=The Beatles
