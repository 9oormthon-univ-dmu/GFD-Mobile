# 7주차
- LazyColumn
- Dialog, Snackbar

## LazyColumn
스크롤이 가능한 목록을 표시하는 데 사용된다.
아이템들이 필요할 때만 로드되어 성능을 최적화할 수 있다.
속성은 아래와 같다.

- items: 리스트의 각 아이템, 데이터를 기반으로 여러 항목을 표시
- modifier: LazyColumn의 크기, 패딩, 배경 등을 정의
- horizontalAlignment: 아이템들을 수평으로 정렬
- verticalArrangement: 아이템들의 세로 간격 설정

```kotlin
LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally, // 아이템을 수평으로 가운데 정렬
    verticalArrangement = Arrangement.spacedBy(12.dp) // 아이템 간의 간격을 12dp로 설정
) {
    items(itemsList) { item ->
        Text(
            text = item,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}
```

## Dialog
사용자에게 중요한 정보를 전달하거나 결정을 요청할 때 사용하는 팝업 창이다.
화면 상단에 표시되어 상호작용을 차단한다.
속성은 아래와 같다.

- onDismissRequest: 사용자가 대화 상자 종료 시 호출 함수
- properties: 다이얼로그의 동작을 제어 추가 설정 - e.g. 뒤로 버튼 비활성화
- content: 다이얼로그 안에 표시될 내용 정의

```kotlin
Dialog(
    onDismissRequest = { /* 다이얼로그를 닫을 때 호출되는 함수 */ },
    properties = DialogProperties(
        dismissOnBackPress = false, // 뒤로 가기 버튼을 비활성화
        dismissOnClickOutside = false // 다이얼로그 외부 클릭 시 닫히지 않게 설정
    )
) {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.White)
    ) {
        Text(
            text = "This is a dialog",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
```


## Snackbar
간단한 메시지나 작업 확인을 위해 화면 하단에 잠시 표시되는 메시지로, 유저가 중요한 정보를 놓치지 않도록 도와준다.
속성은 아래와 같다.

- text: 표시할 메시지
- action: 추가 작업
- modifier: 배치와 크기를 정의
- duration: 표시 시간 설정 - Short, Log, Indefinite

```kotlin
Snackbar(
    action = {
        TextButton(onClick = { /* 추가 작업 정의 */ }) {
            Text("Undo")
        }
    },
    modifier = Modifier.padding(8.dp),
    duration = SnackbarDuration.Short // 스낵바가 표시되는 시간 설정 (짧게) : Short, Log, Indefinite
) {
    Text(text = "This is a snackbar")
}
```