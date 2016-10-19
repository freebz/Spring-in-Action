// 코드 18.4  "marco" 웹 소켓으로 연결하는 자바스크립트 클라이언트

var url = 'ws://' + window.location.host + '/websocket/marco';
var sock = new WebSocket(url);  // 웹 소켓 오픈

sock.onopen = function() {  // 오픈 이벤트 처리
    console.log('Opening');
    sayMarco();
};

sock.onmessage = function(e) {  // 메시지 처리
    console.log('Received message: ', e.data);
    setTimeout(function(){sayMarco()}, 2000);
};

sock.onclose = function() {  // 종료 이벤트 처리
    console.log('Closing');
};

function sayMarco() {
    console.log('Sending Marco!');
    sock.send("Marco!");  // 메시지 전송
}
