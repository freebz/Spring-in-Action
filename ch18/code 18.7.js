// 코드 18.7  메시지는 STOMP 라이브러리를 사용하여 자바스크립트로부터 전송된다.

var url = 'http://' + window.location.host + '/stomp/marcopolo';
var sock = new SockJS(url);  // SockJS 연결 생성

var stomp = Stomp.over(sock);  // STOMP 클라이언트 생성

var payload = JSON.stringify({ 'message': 'Marco!' });

stomp.connect('guset', 'guest', function(frame) {  // STOMP 엔드포인트에 연결
    stomp.send("/marco", {}, payload);  // 메시지 전송
});
