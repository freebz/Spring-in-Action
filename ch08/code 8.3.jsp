<!-- 코드 8.3  주문에 대해 고객에게 감사를 표시하는 JSP 뷰 -->

<html xmlns:jsp="http://java.sun.com/JSP/Page">
  <jsp:output omit-xml-declaration="yes"/>
  <jsp:directive.page contentType="text/html;charset=UTF-8" />
  <head><title>Spizza</title></head>
  <body>
    <h2>Thank you for your order!</h2>
    <![CDATA[
    <a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>  <!-- Finished 이벤트 시작 -->
    ]]>
  </body>
</html>
