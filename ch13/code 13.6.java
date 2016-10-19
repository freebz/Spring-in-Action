// 코드 13.6  캐시에 값을 저장하고 값을 가져오기 위해 @Cacheable 사용하기

@Cacheable("spittleCache")  // 이 메소드 결과 캐싱하기
public Spittle findOne(long id) {
    try {
	return jdbcTemplate.queryForObject(
					   SELECT_SPITTLE_BY_ID,
					   new SpittleRowMapper(),
					   id);
    } catch (EmptyResultDataAccessException e) {
	return null;
    }
}
