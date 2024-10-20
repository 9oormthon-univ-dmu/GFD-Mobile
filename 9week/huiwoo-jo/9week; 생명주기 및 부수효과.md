# 9주차
- 생명주기
- 부수효과

## 핵심 용어
- 컴포지션(Composition): 컴포저블 함수가 실행되어 UI를 구성하는 과정.
- 초기 컴포지션: 컴포저블이 처음 실행되어 컴포지션이 생성되는 시점.
- 리컴포지션(Recomposition): 데이터 변경에 따라 컴포지션이 업데이트되는 과정.

## 컴포저블 생명주기
### 컴포저블의 수명 주기
![img.png](https://developer.android.com/static/develop/ui/compose/images/lifecycle-composition.png?hl=ko)
컴포저블의 수명 주기는 컴포지션 시작, 0회 이상의 리컴포지션, 그리고 컴포지션 종료로 정의된다.
리컴포지션은 일반적으로 State<T> 객체가 변경될 때 트리거되며, Compose는 이 상태를 추적하여 영향을 받는 컴포저블을 다시 실행한다.
컴포저블은 특정 상황에서만 재구성되며, 변경되지 않은 부분은 건너뛰기(스마트 리컴포지션) 기능이 작동한다.

### 컴포지션에서 컴포저블의 위치 및 호출 사이트
컴포저블은 호출된 위치(호출 사이트)에 따라 고유하게 식별된다.<Br>
동일한 호출 사이트에서 여러 번 호출되면 각 호출은 컴포지션에 여러 인스턴스로 추가된다.<Br>
이를 통하여 컴포저블은 중복되지 않고 고유하게 처리된다.

### Key를 통한 인스턴스 구분
리스트나 반복되는 컴포저블에서 key를 사용하면 각 인스턴스를 고유하게 식별할 수 있다.<Br>
key는 특히 컴포저블이 부수 효과를 가지거나 내부 상태를 가지고 있을 때 유용하며, 컴포지션 트리에서 컴포저블의 위치를 기억하고 재사용할 수 있다.

### 부수 효과와 안정성
컴포저블에서 부수 효과를 다룰 때는 리컴포지션 중에도 지속성을 유지하도록 신경 써야 한다.<Br>
각 컴포저블 호출에서 안정성(stability)을 유지하는 것이 중요하며 변경되지 않은 상태에서는 재구성을 건너뛸 수 있게 한다.<Br>
Compose에서는 `Stable`로 표시된 유형들이 안정적으로 간주되며, 기본적으로 `Boolean`, `Int`, `String`과 같은 변경 불가능한 값들은 안정성을 보장한다.

### 컴포지션 내 컴포저블
컴포지션 내 컴포저블의 인스턴스는 호출 사이트로 식별된다.<Br>
Compose 컴파일러는 각 호출 사이트를 고유한 것으로 간주하며, 여러 호출 사이트에서 컴포저블을 호출 시 컴포지션에 컴포저블의 여러 인스턴스가 생성된다.


## 부수효과
부수 효과는 컴포저블 외부에서 발생하는 앱 상태 변경을 의미하며, 컴포저블의 수명 주기와 리컴포지션의 예측 불가능성 때문에 가능한 부수 효과를 피해야 한다.<Br>
하지만 일부 작업에서는 부수 효과가 필요하며, Jetpack Compose는 이를 관리할 다양한 효과 API를 제공한다.

### 상태 및 부수 효과 사용 사례
컴포저블은 부수 효과가 없어야 하며, 부수 효과가 필요한 경우에는 효과 API를 사용해 예측 가능한 방식으로 실행한다.<Br>
Compose에서 부수 효과는 UI를 내보내지 않으며, 컴포지션이 완료되었을 때 부수 효과가 실행된다.

#### LaunchedEffect
컴포저블의 범위에서 코루틴을 실행하는 API이다.<Br>
컴포저블이 처음 컴포지션에 들어갈 때 정지 함수가 실행되고, 컴포지션이 종료되면 코루틴이 취소된다.<Br>
키 값이 변경되면 기존 코루틴이 취소되고 새로운 코루틴이 실행된다.

- 예시: 알파 애니메이션을 지정된 간격마다 반복 실행
```kotlin
LaunchedEffect(pulseRateMs) {
    while (isActive) {
        delay(pulseRateMs)
        alpha.animateTo(0f)
        alpha.animateTo(1f)
    }
}
```

#### rememberCoroutineScope
컴포지션 외부에서도 코루틴을 실행할 수 있도록 범위를 제공한다.

- 예시: 사용자가 버튼을 눌렀을 때 스낵바를 표시
```kotlin
val scope = rememberCoroutineScope()
Button(onClick = {
    scope.launch {
        snackbarHostState.showSnackbar("Something happened!")
    }
}) {
    Text("Press me")
}
```

#### rememberUpdatedState
효과가 다시 시작되지 않도록 최신 값을 참조한다.<Br>

- 예시: 컴포저블이 재구성되더라도 이전에 설정된 딜레이를 유지
```kotlin
val currentOnTimeout by rememberUpdatedState(onTimeout)
LaunchedEffect(true) {
    delay(SplashWaitTimeMillis)
    currentOnTimeout()
}
```

#### DisposableEffect
컴포저블이 컴포지션을 종료할 때 정리해야 하는 작업이 있을 때 사용한다.<Br>

- 예시: `LifecycleObserver`를 사용하여 라이프사이클 이벤트를 관찰
```kotlin
DisposableEffect(lifecycleOwner) {
    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_START) currentOnStart()
        else if (event == Lifecycle.Event.ON_STOP) currentOnStop()
    }
    lifecycleOwner.lifecycle.addObserver(observer)
    onDispose {
        lifecycleOwner.lifecycle.removeObserver(observer)
    }
}
```

#### SideEffect
Compose 상태를 비Compose 객체와 공유해야 할 때 사용한다.

- 예시: 애널리틱스 라이브러리와 같은 외부 시스템에 상태 전달
```kotlin
SideEffect {
    analytics.setUserProperty("userType", user.userType)
}
```

#### produceState
외부 상태를 Compose 상태로 변환하는 데 사용한다.

- 예시: 네트워크에서 이미지 호출
```kotlin
produceState<Result<Image>>(initialValue = Result.Loading, url, imageRepository) {
    val image = imageRepository.load(url)
    value = if (image == null) Result.Error else Result.Success(image)
}
```

#### derivedStateOf
Compose에서 상태를 파생하여 불필요한 리컴포지션을 방지하는 중요한 도구이다.<Br>
상태 변화가 발생할 때마다 UI가 필요 이상으로 업데이트되는 것을 막아 성능을 최적화할 수 있다.<Br>
특히, 상태가 자주 변할 때 UI가 특정 임계값에서만 반응하도록 제한할 수 있다.

1. 올바른 사용 사례<Br>
스크롤 위치가 0보다 클 때만 버튼을 표시하고 싶을 때 `derivedStateOf`를 사용하면, 스크롤 상태 변화가 자주 발생하더라도 불필요한 리컴포지션을 피할 수 있다.<Br>
아래 코드는 `listState.firstVisibleItemIndex`는 계속해서 변하지만, 버튼은 스크롤이 첫 번째 항목을 넘는 경우에만 보여지므로 `derivedStateOf`를 사용하여 필요한 경우에만 리컴포지션을 유발하도록 설정한다.

```kotlin
@Composable
fun MessageList(messages: List<Message>) {
    Box {
        val listState = rememberLazyListState()

        LazyColumn(state = listState) {
            // ...
        }

        val showButton by remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
            }
        }

        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton()
        }
    }
}
```

2. 잘못된 사용 사례<Br>
단순히 두 상태를 결합할 때는 `derivedStateOf`를 사용하는 것이 오히려 오버헤드가 발생할 수 있다.<Br>
예시처럼 두 상태를 문자열로 결합하는 경우에는 `derivedStateOf`를 사용할 필요가 없다.

```kotlin
// 잘못된 예
val fullNameBad by remember { derivedStateOf { "$firstName $lastName" } } // 불필요한 사용

// 올바른 예
val fullNameCorrect = "$firstName $lastName"
```

#### `snapshotFlow`
Compose의 상태를 Flow로 변환할 때는 `snapshotFlow`를 사용한다.<Br>
Compose의 상태 변화에 따라 Flow를 트리거하며, `distinctUntilChanged`와 유사하게 상태가 변경될 때만 Flow를 실행한다.

- 예시: `listState.firstVisibleItemIndex`가 0보다 클 때만 이벤트를 트리거하여 분석 서비스에 알리는 부작용을 수행
```kotlin
LaunchedEffect(listState) {
    snapshotFlow { listState.firstVisibleItemIndex }
        .map { it > 0 }
        .distinctUntilChanged()
        .filter { it == true }
        .collect {
            MyAnalyticsService.sendScrolledPastFirstItemEvent()
        }
}
```