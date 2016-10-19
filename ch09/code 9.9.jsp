<!-- 코드 9.9  SpEL 기반의 <sec:authorize> 조건부 렌더링 -->

<sec:authorize access="hasRole('ROLE_SPITTER')">  <!-- ROLE_SPITTER 권한이 있을 때만 -->
  <s:url value="/spittles" var="spittle_url" />
  <sf:form modelAttribute="spittle"
	   action="${spittle_url}">
    <sf:label path="text"><s:message code="label.spittle"
				     text="Enter spittle:"/></sf:label>
    <sf:textarea path="text" rows="2" cols="40" />
    <sf:errors path="text" />
    <br/>
    <div class="spitItSubmitIt">
      <input type="submit" value="Spit it!"
	     class="status-btn round-btn disabled" />
    </div>
  </sf:form>
</sec:authorize>
