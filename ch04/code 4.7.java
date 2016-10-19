// 코드 4.7  트랙 재생횟수를 카운트하기 위한 TrackCounter 설정하기

package soundsystem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  // AspectJ 오토 프록싱 활성화
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {  // CompactDisc 빈
	BlankDisc cd = new BlankDisc();
	cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
	cd.setArtist("The Beatles");
	List<String> tracks = new ArrayList<String>();
	tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
	tracks.add("With a Little Help from My Friends");
	tracks.add("Lucy in the Sky with Diamonds");
	tracks.add("Getting Better");
	tracks.add("Fixing a Hole");
	// ...other tracks omitted for brevity...
	cd.setTracks(tracks);
	return cd;
    }

    @Bean
    public TrackCounter trackCounter() {  // TrackCounter 빈
	return new TrackCounter();
    }

}
