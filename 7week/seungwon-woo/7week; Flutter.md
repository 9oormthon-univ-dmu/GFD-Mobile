# Flutter 소셜 로그인 & 토큰 관리
- 졸업작품에서 카카오와 네이버의 소셜 로그인 기능을 만들어 보았다.
- 소셜 로그인을 통해 받은 토큰을 백엔드에 전송한다. 백엔드에선 받은 토큰으로 사용자 정보를 조회하고 만든 JWT를 응답한다.

## 카카오 로그인
- 카카오에서는 카카오 로그인 API를 Flutter SDK로 [지원](https://developers.kakao.com/docs/latest/ko/kakaologin/flutter)하고 있다. 기타 설정은 줄여 말하겠다.

### 메서드 설명
```
Future<String?> isKakaoLogin() async {
    try {
      // 카카오톡 실행 가능 여부 확인
      bool isInstalled = await isKakaoTalkInstalled();
      if (isInstalled) {
        try {
          // 카카오톡으로 로그인
          final oauthToken = await UserApi.instance.loginWithKakaoTalk();
          logger.d(
              "kakaoTalk login accessToken : ${oauthToken.accessToken.toString()}");
          return oauthToken.accessToken.toString();
        } catch (e) {
          logger.d("kakaoTalk login errer : $e");
          if (e is PlatformException && e.code == "CANCELED") {
            logger.d("e : $e");
            return null;
          }
          try {
            final kakaoToken = await UserApi.instance.loginWithKakaoAccount();
            logger.d(
                "kakaoAccount login accessToken : ${kakaoToken.accessToken}");
            return kakaoToken.accessToken.toString();
          } catch (e) {
            logger.d("e : $e");
            return null;
          }
        }
      } else {
        try {
          // 카카오톡 어플이 없는 경우 -> 카카오 계정으로 로그인 유도
          final kakaoToken = await UserApi.instance.loginWithKakaoAccount();
          logger
              .d("kakaoAccount login accessToken : ${kakaoToken.accessToken}");
          return kakaoToken.accessToken.toString();
        } catch (e) {
          logger.d("e : $e");
          return null;
        }
      }
    } catch (e) {
      logger.d("e : $e");
      return null;
    }
}
```

1. `isKakaoTalkInstalled()` : 카카오톡 설치 유무 판단. 실패할 경우 카카오계정으로 로그인.
2. `loginWithKakaoTalk()` : Flutter SDK가 카카오톡을 실행. 앱 이용 동의를 구하는 동의 화면 출력.
3. `loginWithKakaoAccount()` : Flutter SDK가 기본 브라우저를 사용해 카카오계정 로그인 페이지를 팝업으로 엶. 로그인 후 앱 이용 동의를 구하는 화면 출력.

> 동의 화면에서 동의하고 계속하기를 선택하면 **인가 코드**가 발급되고, Flutter SDK가 인가 코드로 **토큰을 발급**받아 로그인을 완료한다. 
`.accessToken.toString()` : 발급받은 토큰 확인

## 네이버 로그인
- 카카오와 다르게 네이버에서는 공식적으로 로그인 API를 지원하지 않는다. 때문에 [flutter_naver_login](https://pub.dev/packages/flutter_naver_login) 패키지를 사용해야 한다. 기타 설정은 줄여 말하겠다.

### 메서드 설명
```
Future<String?> isNaverLogin() async {
    NaverLoginResult result;

    try {
      // 네이버 로그인 시도
      result = await FlutterNaverLogin.logIn();
      NaverAccessToken token = await FlutterNaverLogin.currentAccessToken;
      logger.d("naver login accessToken : ${token.accessToken}");
      return token.accessToken.toString();
    } catch (e) {
      logger.d("naver login error : $e");
      return null;
    }
}
```

1. `FlutterNaverLogin.logIn()` : 네이버 로그인 페이지를 엶.
2. `FlutterNaverLogin.currentAccessToken` : 네이버에 로그인 후 발급된 액세스 토큰을 반환. 

## 로그아웃
- LoginPlatform이라는 enum을 만듦
```
enum LoginPlatform {
  kakao,
  naver,
  apple,
  none, // logout
}

extension ParseToString on Enum {
  String toShortString() {
    return toString().split('.').last;
  }
}

extension LoginPlatformExtension on LoginPlatform {
  static LoginPlatform fromString(String? string) {
    return LoginPlatform.values.firstWhere((e) => e.toShortString() == string,
        orElse: () => throw Exception('Invalid platform string'));
  }
}

```
- 전달받은 loginPlatform의 값으로 해당 로그아웃 로직 수행
```
Future<bool> isLogout(LoginPlatform loginPlatform) async {
    switch (loginPlatform) {
      case LoginPlatform.kakao:
        try {
          // logout 실행 코드. SDK에서 토큰 삭제
          await UserApi.instance.unlink();
          logger.d("$loginPlatform : logout");
          return true;
        } catch (e) {
          logger.d("kakao logout error : $e");
          return false;
        }
      case LoginPlatform.naver:
        try {
          // logout 실행 코드. SDK에서 토큰 삭제
          await FlutterNaverLogin.logOut();
          logger.d("$loginPlatform : logout");
          return true;
        } catch (e) {
          logger.d("naver logout error : $e");
          return false;
        }
      case LoginPlatform.apple:
        try {
          // logout 실행 코드.
          // Apple은 logout이 없다.
          logger.d("$loginPlatform : logout");
          return true;
        } catch (e) {
          logger.d("kakao logout error : $e");
          return false;
        }
      case LoginPlatform.none:
        logger.d("login Platform none!");
        return true;
    }
}
```

## 자동 로그인
### FlutterSecureStorage
-  Flutter에서 민감한 데이터를 안전하게 저장하기 위한 플러그인.
- 암호화된 방식으로 데이터 저장소를 제공하여, API 토큰, 로그인 정보, 비밀번호와 같은 중요한 정보를 안전하게 관리할 수 있음.
- Key-Value 저장 구조
### 소셜 로그인 성공 시 SecureStorage에 토큰 저장
- 백엔드에 소셜 로그인 토큰을 전송하고 발급받은 JWT 저장
```
isLogined = await loginViewModel.naverLogin(context);
if (isLogined) {
// 로그인플랫폼 & 서버에서 발급받은 토큰을 FlutterSecureStorage에 저장
await storage.write(
    key: 'accessToken', value: loginViewModel.accessToken);
await storage.write(
    key: 'refreshToken',
    value: loginViewModel.refreshToken);
await storage.write(
    key: 'loginPlatform',
    value: loginViewModel.loginPlatform.name);
Map<String, String> allData = await storage.readAll();
logger.d("secure storage read : $allData");
Navigator.of(context).pushReplacement(
    MaterialPageRoute(builder: (context) => const MyAppPage()),
);
}
```
### 그 다음 진입부터 SecureStorage 토큰 확인
- SecureStorage에 저장된 토큰이 존재한다면 로그인 페이지가 아닌 메인 페이지로 이동
```
Future<void> _loadAuthToken() async {
    // key값에 맞는 데이터 값 불러옴. key에 맞는 데이터가 없을 때는 null을 반환
    final accessToken = await storage.read(key: 'accessToken');
    final refreshToken = await storage.read(key: 'refreshToken');
    Map<String, String> allData = await storage.readAll();
    // token 데이터가 있다면 메인페이지로 이동
    if (accessToken != null && refreshToken != null) {
      logger.d("secure storage read 1 : $allData");
      Navigator.of(context).pushReplacement(
        MaterialPageRoute(builder: (context) => const MyAppPage()),
      );
    }
}
```

## JWT 만료
### accessToken 만료 - reissue
- http status : API 호출의 401
- refreshToken 전송
- accessToken, refreshToken 재발급
- SecureStorage token 재작성
```
// FlutterSecureStorage에 있는 token 삭제
await storage.delete(key: 'accessToken');
await storage.delete(key: 'refreshToken');

Map<String, dynamic> jsonData = json.decode(response.body);
Map<String, dynamic> token = jsonData['data'];

// token 재작성
await storage.write(key: 'accessToken', value: token['accessToken']);
await storage.write(key: 'refreshToken', value: token['refreshToken']);
```
### refreshToken 만료 - reissue의 401
- http status : reissue의 401
- SecureStorage token 삭제
- 로그인 페이지로 전환
```
// FlutterSecureStorage에 있는 token 삭제
await storage.delete(key: 'accessToken');
await storage.delete(key: 'refreshToken');
await storage.delete(key: 'loginPlatform');
// 로그인 페이지로 전환
Navigator.of(context).pushReplacement(
    MaterialPageRoute(builder: (context) => LoginPage()),
);
```