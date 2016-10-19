// 코드 4.5   around 어드바이스를 사용하여 Audience 애스펙트 재작성하기

package concert;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

    @Pointcut("execution(** concert.Perfomance.perform(..))")  // 명명된 포인트커트 선언
    public void performance() {}

    @Around("performance()")  // around 어드바이스 메소드
    public void watchPerformance(ProceedingJoinPoint jp) {
	try {
	    System.out.println("Silencing cell phones"); System.out.println("Taking seats");
	    jp.proceed();
	    System.out.println("CLAP CLAP CLAP");
	} catch (Throwable e) {
	    System.out.println("Demanding a refund");
	}
    }

}
