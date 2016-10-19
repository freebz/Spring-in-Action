// 코드 4.16  CriticAspect로 주입될 CriticismEngine

package com.springinaction.springidol;
public class CriticismEngineImpl implements CriticismEngine {
    public CriticismEngineImpl() {}

    public String getCriticism() {
	int i = (int) (Math.random() * criticismPool.length);
	return criticismPool[i];
    }

    // 주입 대상
    private String[] criticismPool;
    public void setCriticismPool(String[] criticismPool) {
	this.criticismPool = criticismPool;
    }
}
