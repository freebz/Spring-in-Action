// 코드 1.4  BraveKnight 테스트를 위하여 모의 Quest 주입하기

package com.springinaction.knights;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class BraveKnightTest {

    @Test
    public void kinghtShouldEmbarkOnQuest() {
	Quest mockQuest = mock(Quest.class);  // 모의 Quest 생성
	BraveKnight knight = new BraveKnight(mockQuest);  // 모의 Quest 주입
	knight.embarkOnQuest();
	verify(mockQuest, times(1)).embark();
    }

}
