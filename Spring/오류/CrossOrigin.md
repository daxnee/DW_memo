### @CrossOrigin 부재 오류
---
![CrossOrigin오류](https://user-images.githubusercontent.com/96815399/173301572-58659d37-c40f-4069-a66a-7abe780ed9f7.PNG)

---

### 문제 상황
```
postman에서 url요청시 DB에 문제 없이 insert가 되기도 하고
이클립스에서도 오류문을 발견하지 못했는데
개발자 도구(f12)에서 이러한 경고문이 뜬다.
```

### 해결방법
```
1. restController의 메소드에 @CrossOrigin을 설정해줬나 확인하기(보통 없는 경우에 오류가 발생한다)
2. 설정 후 서버 off 후 다시 실행하면 오류가 해결된다.
```

=> 다른 Origin 에서 온 자원들을 허용할 수 있게 만들어 주기 때문에 오류 해결이 가능한 것임!