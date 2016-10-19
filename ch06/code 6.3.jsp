<!-- 코드 6.3  주 레이아웃 템플릿: 뷰를 생성하기 위해 다른 템플릿들을 참조 -->

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-titles" prefix="t" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spittr</title>
    <link rel="stylesheet"
    	  type="text/css"
	  href="<s:url value="/resources/style.css" />" >
  </head>
  <body>
    <div id="header">
      <t:insertAttribute name="header" />  <!-- 헤더 삽입 -->
    </div>
    <div id="content">
      <t:insertAttribute name="body" />  <!-- 보디 삽입 -->
    </div>
    <div id="footer">
      <t:insertAttribute name="footer" />  <!-- 꼬리말 삽입 -->
    </div>
  </body>
</html>
