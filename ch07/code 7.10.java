// 코드 7.10  모든 컨트롤러의 예외 처리를 위한 @ControllerAdvice의 사용

package spitter.web;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // 컨트롤러 어드바이스 선언
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateSpittleException.class)  // 예외-처리 메소드 정의
    public String duplicateSpittleHandler() {
	return "error/duplicate";
    }

}
