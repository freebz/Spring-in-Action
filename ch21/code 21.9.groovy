// 코드 21.9  그루비로 작성하면 ContactRepository가 더 간결해진다.

@Grab("h2")  // H2 데이터베이스 의존성 확보

import java.sql.ResultSet

class ContactRepository {

  @Autowired
  JdbcTemplate jdbc  // JdbcTemplate 주입

  List<Contact> findAll() {  // 연락처에 대한 쿼리
    jdbc.query(
      "select id, firstName, lastName, phoneNumber, emailAddress " +
      "from contacts order by lastName",
      new RowMapper<Contact>() {
	Contact mapRow(ResultSet rs, int rowNum) {
	  new Contact(id: rs.getLong(1), firstName: rs.getString(2),
	  lastName: rs.getString(3), phoneNumber: rs.getString(4),
	  emailAddress: rs.getString(5))
	}
      })
  }

  void save(Contact contact) {  // 연락처 저장
    jdbc.update(
      "insert into contacts " +
      "(firstName, lastName, phoneNumber, emailAddress) " +
      "values (?, ?, ?, ?, ?)",
      contact.firstName, contact.lastName,
      contact.phoneNumber, contact.emailAddress)
  }

}
