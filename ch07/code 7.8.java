// 코드 7.8  @ResponseStatus 애너테이션: 예외를 명시된 상태 코드에 매핑하기

package spittr.web;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,  // 예외를 HTTP 상태 코드 404에 매핑
		reason="Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
}
