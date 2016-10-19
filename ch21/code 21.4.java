// 코드 21.4  Contact는 단순한 도메인 타입이다.

package contacts;

public class Contact {
    private Long id;  // 프로퍼티
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public void setId(Long id) {  // 접근자 메소드
	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setLastName(String lastname) {
	this.lastname = lastname;
    }

    public String getLastName() {
	return lastname;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

}
