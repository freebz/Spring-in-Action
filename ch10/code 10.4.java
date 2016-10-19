// 코드 10.4  JDBC를 이용해 데이터베이스에 레코드를 추가하는 예제

private static final String SQL_INSERT_SPITTER =
    "insert into spitter (username, password, fullname) values (?, ?, ?)";
private DataSource dataSource;
public void addSpitter(Spitter spitter) {
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
	conn = dataSource.getConnection();  // 커넥션 얻기
	stmt = conn.prepareStatement(SQL_INSERT_SPITTER);  // 질의객체 생성
	stmt.setString(1, spitter.getUsername());  // 파라미터에 값 할당
	stmt.setString(2, spitter.getPassword());  // 파라미터 실행
	stmt.setString(3, spitter.getFullName());
	stmt.execute();  // 질의객체 실행
    } catch (SQLException e) {
	// 확실하지 않지만 무엇인가 수행해야 한다.  // 예외 처리
    } finally {  // 예외 처리
	try {
	    if (stmt != nll) {  // 해제
		stmt.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	} catch (SQLException e) {
	    // 여기서는 무엇을 수행해야 하는지 더 확실하지 않다.
	}
    }
}
