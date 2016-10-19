// 코드 1.10  Minstrel 메소드를 호출해야 하는 BraveKnight

package com.springinaction.knights;

public class BraveKnight implements Knight {

    private Quest quest;
    private Minstrel minstrel;

    public BraveKnight(Quest quest, Minstrel minstrel) {
	this.quest = quest;
	this.minstrel = minstrel;
    }

    public void embarkOnQuest() throws QuestException {
	minstrel.singBeforeQuest(); // 기사가 자신의 음유시인을 관리해야 할까?
	quest.embark();
	minstrel.singAfterQuest();
    }

}
