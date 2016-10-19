// 코드 2.2  @Component로 애너테이트된 SgtPeppers의 CompactDisc 구현

package soundsystem;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
	System.out.println("Playing " + title + " by " + artist);
    }

}
