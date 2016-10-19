// 2.3 자바로 빈 와이어링하기

// 2.3.1 설정 클래스 만들기

package soundsystem;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    // 2.3.2 간단힌 빈 선언하기
    
    @Bean(name="lonelyHeartsClubBand")
    public CompactDisc sgtPeppers() {
	return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomBeatlesCD() {
	int choice = (int) Math.floor(Math.random() * 4);
	if (choice == 0) {
	    return new SgtPeppers();
	} else if (choice == 1) {
	    return new WhiteAlbum();
	} else if (choice == 2) {
	    return new HardDaysNight();
	} else {
	    return new Revolver();
	}
    }


    // 2.3.3 JavaConfig 주입하기

    @Bean
    public CDPlayer cdPlayer() {
	return new CDPlayer(sgtPeppers());
    }

    @Bean
    public CDPlayer anotherCDPlayer() {
	return new CDPlayer(sgtPeppers());
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
	return new CDPlayer(compactDisc);
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
	CDPlayer cdPlayer = new CDPlayer();
	cdPlayer.setCompactDisc(compactDisc);
	return cdPlayer;
    }
    
}
