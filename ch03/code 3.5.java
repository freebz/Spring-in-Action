// 코드 3.5  Condition에 magic 존재 여부 체크

package com.habuma.restfun;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

public class MagicExistsCondition implements Condition {

    public boolean matches(
			   ConditionContext context, AnnotatedTypeMetadata metadata) {
	Environment env = context.getEnvironment();
	return env.containsProperty("magic");    // "magic" 프로퍼티 체크
    }

}
