// 코드 16.5  위치 URI를 생성하기 위해 UriComponentsBuilder 사용하기

@RequestMapping(
		method=RequestMethod.POST
		consumes="application/json")
public ResponseEntity<Spittle> saveSpittle(
					   @RequestBody Spittle spittle,
					   UriComponentsBuilder ucb) {  // UriComponentsBuilder 제공

    Spittle spittle = spittleRepository.save(spittle);

    HttpHeaders headers = new HttpHeaders();  // 위치 URI 계산

    URI locationUri =
	ucb.path("/spittles/")
	.path(String.valueOf(spittle.getId()))
	.build()
	.toUri();
    headers.setLocation(locationUri);

    ResponseEntity<Spittle> responseEntity =
	new ResponseEntity<Spittle>(
				    spittle, headers, HttpStatus.CREATED)
    return responseEntity;
}
