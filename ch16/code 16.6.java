// 코드 16.6  아파치 HTTP 클라이언트를 사용하여 페이스북 프로파일을 가져오기

public Profile fetchFacebookProfile(String id) {
    try {
	HttpClient client = HttpClients.createDefault();  // 클라이언트 생성

	HttpGet request = new HttpGet("http://graph.facebook.com/" + id);  // 요청 생성
	request.setHeader("Accept", "application/json");

	HttpResponse response = client.execute(request);  // 요청 실행

	HttpEntity entity = response.getEntity();
	ObjectMapper mapper = new ObjectMapper();  // 객체에 응답 매핑
	return mapper.readValue(entity.getContent(), Profile.class);
    } catch (IOException e) {
	throw new RuntimeException(e);
    }

}
