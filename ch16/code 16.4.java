// 코드 16.4  ResponseEntity 반환 시의 응답 내 헤더 설정

@RequestMapping(
		method=RequestMethod.POST
		consumes="application/json")
public ResponseEntity<Spittle> saveSpittle(
					   @RequestBody Spittle spittle) {

    Spittle spittle = spittleRepository.save(spittle);  // spittle 저장

    HttpHeaders headers = new HttpHeaders();  // 위치 헤더 설정
    URI locationUri = URI.create(
				 "http://localhost:8080/spittr/spittles/" + spittle.getId());
    headers.setLocation(locationUri);

    ResponseEntity<Spittle> responseEntity =  // ResponseEntity 생성
	new ResponseEntity<Spittle>(
				    spittle, headers, HttpStatus.CREATED)
    return responseEntity;
}
