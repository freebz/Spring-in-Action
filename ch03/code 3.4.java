// 코드 3.4  빈의 조건 설정하기

@Bean
@Conditional(MagicExistsCondition.class)    // 조건적으로 빈 생성
public MagicBean magicBean() {
    return new MagicBean();
}





public interface Condition {
    boolean matches(ConditionContext ctxt,
		    AnnotatedTypeMetadata metadata);
}
