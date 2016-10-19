// 코드 10.5  JDBC를 이용해 데이터베이스에 레코드를 업데이트하는 예제

private static final String SQL_UPDATE_SPITTER =
    "update spitter set username =?, password =?, fullname = ?"
    + "where id = ?";
public void saveSpitter(Spitter spitter) {
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
	conn = dataSource.getConnection();  // 커넥션 얻기
	stmt = conn.prepareStatement(SQL_UPDATE_SPITTER);  // 질의객체 생성
	stmt.setString(1, spitter.getUsername());  // 파라미터에 값 할당
	stmt.setString(2, spitter.getPassword());
	stmt.setString(3, spitter.getFullName());
	stmt.setLong(4, spitter.getId());
	stmt.execute();  // 질의객체 실행
    } catch (SQLException e) {
	// 여전히 여기서 무엇을 수행하는지 확실하지 않다.  // 예외 처리
    } finally {
	try { (somehow)
	    if (stmt != nll) {  // 해제
		stmt.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	} catch (SQLException e) {
	    // 이 부분도 마찬가지다.
	}
    }
}
