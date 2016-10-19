// 코드 4.13  애너테이션을 사용하지 않는 TrackCounter

package soundsystem;
import java.util.HashMap;
import java.util.Map;

public class TrackCounter {

    private Map<Integer, Integer> trackCounts =
	new HashMap<Integer, Integer>();  // 어드바이스 전에 선언할 메소드

    public void countTrack(int trackNumber) {
	int currentCount = getPlayCount(trackNumber);
	trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
	return trackCounts.containsKey(trackNumber)
	    ? trackCounts.get(trackNumber) : 0;
    }

}
