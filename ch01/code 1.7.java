// 코드 1.7  XML 설정의 대안으로 자바 기반 설정을 제공하는 스프링

package com.springinaction.knights.config;

import com.springframework.context.annotation.Bean;
import com.springframework.context.annotation.Configuration;

import com.springinaction.knights.BraveKnight;
import com.springinaction.knights.Knight;
import com.springinaction.knights.Quest;
import com.springinaction.knights.SlayDragonQuest;

@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
	return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
	return new SlayDragonQuest(System.out);
    }

}
