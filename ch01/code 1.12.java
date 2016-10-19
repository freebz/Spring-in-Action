// 코드 1.12 JDBC등 상당수의 자바 API에는 상투적인 코드 작성이 포함되어 있다.

public Employee getEmployeeById(long id) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
	conn = dataSource.getConnection();
	stmt = conn.prepareStatement(
				     "select id, firstname, lastname, salary from " +
				     "employee where id=?");  // 직원 조회
	stmt.setLong(1, id);
	rs = stmt.executeQuery();
	Employee employee = null;
	if (rs.next()) {
	    employee = new Employee();  // 데이터로부터 객체 생성
	    employee.setId(rs.getLong("id"));
	    employee.setFirstName(rs.getString("firstname"));
	    employee.setLastName(rs.getString("lastname"));
	    employee.setSalary(rs.getBigDecimal("salary"));
	}
	return employee;
    } catch (SQLException e) {  // 여기서 무엇을 수행해야 하나?
    } finally {
	if(rs != null) {  // 정리 작업
	    try {
		rs.close();
	    } catch(SQLException e) {}
	}
	if(stmt != null) {
	    try {
		stmt.close();
	    } catch(SQLException e) {}
	}
	if(conn != null) {
	    try {
		conn.close();
	    } catch(SQLException e) {}
	}
    }
    return null;
}
