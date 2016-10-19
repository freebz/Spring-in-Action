// 코드 4.2  @Pointcut를 이용해 자주 사용되는 포인트커트 표현식 선언하기

package concert;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

    @Pointcut("execution(** concert.Performance.perform(..))")  // 명명된 포인트커트 정의
    public void performance() {}

    @Before("performance()")  // 공연 이전
    public void silenceCellPhones() {
	System.out.println("Silencing cell phones");
    }

    @Before("performance()")  // 공연 이전
    public void takeSeate() {
	System.out.println("Taking seats");
    }

    @AfterReturning("performance()")  // 공연 후
    public void applause() {
	System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")  // 공연 실패 후
    public void demandREfund() {
	System.out.println("Demanding a refund");
    }

}
