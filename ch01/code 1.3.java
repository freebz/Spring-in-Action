// 코드 1.3  부여된 어떤 Quest도 충분히 감당할 만큼 유연한 BraveKnight

package com.springinaction.knights;

public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) { // Quest 주입
	this.quest = quest;
    }

    public void embarkOnQuest() {
	quest.embark();
    }
    
}
