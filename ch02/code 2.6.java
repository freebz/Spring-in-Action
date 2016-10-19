// 코드 2.6  오토와이어링을 사용하여 CompactDisc를 CDPlayer 빈으로 주입하기

package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
	this.cd = cd;
    }

    public void play() {
	cd.play();
    }

}
