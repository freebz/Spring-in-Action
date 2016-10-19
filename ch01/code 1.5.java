// 코드 1.5  SlayDragonQuest는 BraveKnight에 주입될 Quest다.

package com.springinaction.knights;

import java.io.PrintStream;

public class SlayDragonQeust implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
	this.stream = stream;
    }

    public void embark() {
	stream.println("Embarking on quest to slay the dragon!");
    }

}
