웹 브라우저와 웹 서버 간에 상태 정보를 유지하기 위한 기술

쿠키는 서버가 브라우저는 이를 **로컬에 저장**하고 필요할 때마다 **서버에 전송**하여 사용자 상태 정보를 유지한다.

쿠키는 HTTP 헤더에 Set-Cookie와 같은 헤더를 통해 서버에서 클라이언트에 전송된다.

쿠키는 **key-value** 쌍으로 이루어져 있다.




### Cookie 취약점
쿠키 탈취의 문제점.
Front-end에서 cookie의 내용을 읽어갈 수 있다.

```
cookie.setHttpOnly(true);
cookie.setSecure(true); // https에서만 사용되도록 설정
```

js에서 console을 통해 cookie 값을 읽을 수 없도록 막는다.

