// 코드 10.7  JdbcTemplate 기반의 addSpitter() 메서드

public void addSpitter(Spitter spitter) {
    jdbcOperations.update(INSERT_SPITTER,  // Spitter 추가

			  spitter.getUsername(),
			  spitter.getPassword(),
			  spitter.getFullName(),
			  spitter.getEmail(),
			  spitter.isUpdateByEmail());
}
