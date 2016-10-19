// 코드 10.6  JDBC를 이용해 데이터베이스에서 레코드를 질의하는 예제

private static final String SQL_SELECT_SPITTER =
    "select id, username, fullname from spitter where id = ?";
public Spitter findOne(long id) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
	conn = dataSource.getConnection();  // 커넥션 얻기
	stmt = conn.prepareStatement(SQL_SELECT_SPITTER);  // 질의객체 생성
	stmt.setLong(1, id);  // 파라미터에 값 할당
	rs = stmt.executeQuery();  // 질의문 실행
	Spitter spitter = null;
	if (rs.next()) {  // 결과처리
	    spitter = new Spitter();
	    spitter.setId(rs.getLong("id"));
	    spitter.setUsername(rs.getString("username"));
	    spitter.setPassword(rs.getString("password"));
	    spitter.setFullName(rs.getString("fullname"));
	}
	return spitter;
    } catch (SQLException e) {  // 예외처리
    } finally {  // 해제
	if(rs != null) {
	    try {
		rs.close();
	    } catch(SQLException e) {}
	}
	if (stmt != nll) {
	    try {
		stmt.close();
	    } catch(SQLException e) {}
	}
	if (conn != null) {
	    try {
		conn.close();
	    } catch (SQLException e) {}
	}
    }
    return null;
}
