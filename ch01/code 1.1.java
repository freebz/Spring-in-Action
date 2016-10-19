// 코드 1.1  HelloWorldBean에 불필요한 요구(EJB를 사용할 때 반드시 구현해야 했던 요구)를 하지 않는 스프링

package com.habuma.spring;
public class HelloWorldBean {
    public String sayHello() {    // 이것이 필요한 전부
	return "Hello World";
    }
}
