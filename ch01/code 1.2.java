// 코드 1.2  소녀를 구하는 기사(DamselRescuingKnight)는 소녀 구출 임무를 받은 자만 떠날 수 있다.

package com.springinaction.knights;

public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;
    public DamselRescuingKnight() {
	this.quest = new RescueDamselQuest();  // RescueDamselQuest에 강하게 결합
    }
    public void embarkOnQuest() {
	quest.embark();
    }
}
