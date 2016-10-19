// 2.4.4 프로퍼티 세팅

package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;
import soundsystem.CompactDisc;
import soundsystem.MediaPlayer;

public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
	this.compactDisc = compactDisc;
    }

    public void play() {
	compactDisc.play();
    }

}
