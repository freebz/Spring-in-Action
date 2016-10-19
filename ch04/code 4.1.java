// 코드 4.1  Audience 클래스: 공연 관람 애스펙트

package concert;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {

    @Before("execution(** concert.Performance.perform(..))")  // 공연 이전
    public void silenceCellPhones() {
	System.out.println("Silencing cell phones");
    }

    @Before("execution(** concert.Performance.perform(..))")  // 공연 이전
    public void takeSeate() {
	System.out.println("Taking seats");
    }

    @AfterReturning("execution(** concert.Performance.perform(..))")  // 공연 후
    public void applause() {
	System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(** concert.Performance.perform(..))")  // 공연 실패 후
    public void demandREfund() {
	System.out.println("Demanding a refund");
    }

}
