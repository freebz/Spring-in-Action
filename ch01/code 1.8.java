// 코드 1.8  KnightMain.java는 기사를 포함하는 스프링 컨텍스트를 로드한다.

package com.springinaction.knights;

import org.springframework.context.support.
    ClassPathXmlApplicationContext;

public class KnightMain {

    public static void main(String[] args) throws Exception {
	ClassPathXmlApplicationContext context = // 스프링 컨텍스트 로드
	    new ClassPathXmlApplicationContext(
					       "META-INF/spring/knights.xml");
	Knight knight = context.getBean(Knight.class);  // 기사 빈 얻기
	knight.embarkOnQuest();  // <- 기사 사용
	context.close();
    }

}
