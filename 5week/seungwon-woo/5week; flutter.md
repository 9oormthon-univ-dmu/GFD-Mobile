# Flutter 비동기 프로그래밍

## 비동기 프로그래밍?
- 비동기 프로그래밍 : 요청한 결과를 기다리지 않으며 응답 순서 또한 요청 순서와 다를 수 있음.
- 사용 이유 : 시간이 걸리는 작업(복잡한 계산, 이미지 인코딩 등)을 동기로 실행하면 앱이 매우 느려질 수 있음.
- 오랜 기간 CPU의 리소스가 막히는 상황 방지 가능

## Future
- Future : 비동기 응답을 한 번만 받을 때 사용하는 클래스
- 미래에 받을 값의 타입 지정 가능

## async와 await
- async : 비동기 함수 정의 가능
- await : 비동기 함수를 논리적 순서대로 실행 가능
- 비동기 프로그래밍을 유지하면서 코드 가독성 유지 가능
- 작성한 순서대로 실행됨

## Stream
- 지속적으로 값을 반환 받을 때는 Stream을 사용

## 오류 해결
```
Future<bool> tokenAPI() async {
    logger.d("loginPlatform : ${loginPlatform}");

    final data = {
      "token": socialToken,
    };
    final url = Uri.parse('.../${loginPlatform.name}');
    final headers = {'Content-Type': 'application/json'};
    final body = jsonEncode(data);

    try {
      final response = await http.post(url, headers: headers, body: body);
      if (response.statusCode == 200) {
        Map<String, dynamic> jsonData = json.decode(response.body);
        Map<String, dynamic> token = jsonData['data'];

        accessToken = token['accessToken'];
        refreshToken = token['refreshToken'];

        return true;
      } else {
        logger.d("Fail to load ${data}. status code : ${response.statusCode}");
        return false;
      }
    } catch (e) {
      logger.d("error : ${e}");
      return false;
    }
  }
```
> 토큰을 서버로부터 발급 받는 코드이다. Future 클래스로 선언되어 있다.    
처음엔 await를 사용하지 않고 코드를 작성했다가 에러가 떴었는데, **await를 사용하지 않은 Future 클래스의 코드는 요청 결과를 기다리지 않기 때문**이었다. 단순한 오류였지만 에러메세지 상으로는 headers에 문제가 있다고만 나와서 오랜 시간을 들였었다.    
이처럼 Future 클래스를 사용할 때는 코드의 진행을 생각해 두고 코드를 작성해야겠다...   
