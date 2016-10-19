// 코드 4.6  트랙 재생횟수를 카운트하기 위해 파라미터화된 어드바이스 사용하기

package soundsystem;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts =
	new HashMap<Integer, Integer>();

    @Pointcut(
	      "execution(* soundsystem.CompactDisc.playTrack(int)) " +  // playTrack() 메서드를 어드바이스하기
	      "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {}

    @Before("trackPlayed(trackNumber)")  // 재생되기 전에 트랙 카운트하기
    public void countTrack(int trackNumber) {
	int currentCount = getPlayCount(trackNumber);
	trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
	return trackCounts.containsKey(trackNumber)
	    ? trackCounts.get(trackNumber) : 0;
    }

}
