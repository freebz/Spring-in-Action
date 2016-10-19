// 코드 10.8  JdbcTemplate을 사용하는 Spitter 쿼리

public Spitter findOne(long id) {
    return jdbcOperations.queryForObject(  // Spitter에 대한 쿼리
					 SELECT_SPITTER_BY_ID, new SpitterRowMapper(),
					 id  // 객체로 객체 매핑
					   );
}

private static final class SpitterRowMapper
    implements RowMapper<Spitter> {

    public Spitter mapRow(ResultSet rs, int rowNum)
	throws SQLException {

	return new Spitter(  // 파라미터 결합
			   rs.getLong("id"),
			   rs.getString("username"),
			   rs.getString("password"),
			   rs.getString("fullName"),
			   rs.getString("email"),
			   rs.getBoolean("updateByEmail"));
    }
}
