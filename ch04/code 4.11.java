// 코드 4.11  watchPerformance() 메소드를 사용하여 around 어드바이스 제공하기

package concert;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

    public void watchPerformance(ProceedingJoinPoint jp) {
	try {

	    System.out.println("Silencing cell phones");  // 공연 전

	    System.out.println("Taking seats");  // 공연 전

	    jp.proceed();  // 어드바이스된 메소드 진행

	    System.out.println("CLAP CLAP CLAP!!!");  // 공연 후
	} catch (Throwable e) {

	    System.out.println("Demainding a refund");  // 공연 실패 후
	}
    }

}
