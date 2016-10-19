// 코드 1.9  Minstrel은 중세 시대의 음악을 좋아하는 로깅 시스템

package com.springinaction.knights;

import java.io.PrintStream;

public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
	this.stream = stream;
    }
    public void singBeforeQuest() {  // 원정 전에 호출됨
	stream.println("Fa la la, the knight is so brave!");
    }

    public void singAfterQuest() { // 원정 후에 호출됨
	stream.println("Tee hee hee, the brave knight " +
		       "did embark on a quest!");
    }

}
