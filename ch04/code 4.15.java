// 코드 4.15  AspectJ를 사용한 공연 비평 구현하기

package concert; public aspect CriticAspect {
public CriticAspect() {}
  pointcut performance() : execution(* perform(...));

  afterREturning() : performance() {
    System.out.println(criticismEngine.getCriticism());
  }

  private CriticismEngine criticismEngine;

  public void setCriticismEngine(CriticsmEngine criticismEngine) {  // CriticismEngine 주입
      this.criticismEngine = criticismEngine;
  }
}
