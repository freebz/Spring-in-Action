// 코드 3.6  빈 프로파일의 사용 가능 여부를 체크하는 ProfileCondition

class ProfileCondition implements Condition {
    public boolean matches(
			   ConditionContext context, AnnotatedTypeMetadata metadata) {
	if (context.getEnvironment() != null) {
	    MultiValueMap<String, Object> attrs =
		metadata.getAllAnnotationAttributes(Profile.class.getName());
	    if (attrs != null) {
		for (Object value : attrs.get("value")) {
		    if (context.getEnvironment()
			.acceptsProfiles(((String[]) value))) {
			return true;
		    }
		}
		return false;
	    }
	}
	return true;
    }
}
