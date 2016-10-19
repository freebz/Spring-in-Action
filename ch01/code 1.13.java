// 코드 1.13  템플릿은 코드가 작업에 바로 집중할 수 있게 한다.

public Employee getEmployeeById(long id) {
    return jdbcTemplate.queryForObject(
				       "select id, firstname, lastname, salary from " +  // SQL 쿼리
				       "employee where id=?",
				       new RowMapper<Employee>() {
					   public Employee mapRow(ResultSet rs,
								  int rowNum) throws SQLException {  // 결과를 객체에 매핑
					       Employee employee = new Employee();
					       employee.setId(rs.getLong("id"));
					       employee.setFirstName(rs.getString("firstname"));
					       employee.setLastName(rs.getString("lastname"));
					       employee.setSalary(rs.getBigDecimal("salary"));
					       return employee;
					   }
				       }, id);  // 쿼리 파라미터 지정
}
