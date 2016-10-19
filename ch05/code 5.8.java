// 코드 5.8  Spittle 클래스: 메시지, 타임스탬프, 위치를 저장하기

package spittr;
import java.util.Date;

public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;

    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date time) {
	this(message, time, null, null);
    }

    public Spittle(
		   String message, Date time, Double longitude, Double latitude) {
	this.id = null;
	this.message = message;
	this.time = time;
	this.longitude = longitude;
	this.latitude = latitude;
    }

    public long getId() {
	return id;
    }

    public String getMessage() {
	return message;
    }

    public Date getTime() {
	return time;
    }

    public Double getLongitude() {
	return longitude;
    }

    public Double getLatitude() {
	return latitude;
    }

    @Override
    public boolean equals(Object that) {
	return EqualBuilder.reflectionEqual(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
