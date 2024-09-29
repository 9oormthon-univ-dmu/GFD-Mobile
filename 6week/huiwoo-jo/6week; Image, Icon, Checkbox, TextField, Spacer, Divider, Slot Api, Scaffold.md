# 6주차
- Image, Icon, Checkbox, TextField, Spacer, Divider
- Slot Api, Scaffold

## Image
이미지를 화면에 표시하는 데 사용한다. 속성은 아래와 같다.

- painter: 이미지 파일
- contentDescription: 사진의 설명
- title: 사진 제목
- modifier: 이미지 카드의 사이즈

```kotlin
Image(
    painter = painterResource(id = R.drawable.image_name),
    contentDescription = "Description of image",
    modifier = Modifier.size(100.dp),
    contentScale = ContentScale.Crop
)
```

## Icon
아이콘을 표시하는 컴포넌트이다.
`Icons` 라이브러리의 기본 아이콘을 사용할 수 있다.
속성은 아래와 같다.

- imageVector: 아이콘 파일
- contentDescription: 아이콘의 설명
- tint: 아이콘 색상
- modifier: 아이콘의 사이즈

```kotlin
// drawable 라이브러리
Icon(
    imageVector = Icons.Default.Home,
    contentDescription = ImageVector.vectorResource(id = R.drawable.ic_home),
    tint = Color.Blue,
    modifier = Modifier.size(24.dp)
)

// Icons 라이브러리
Icon(
    imageVector = Icons.Default.Home,
    contentDescription = "Home Icon",
    tint = Color.Blue,
    modifier = Modifier.size(24.dp)
)
```

## Checkbox
체크박스를 제공하여 선택/해제를 처리한다. 속성은 아래와 같다.
- checked: 체크 선택 상태 (true일 경우 활성화)
- onCheckedChange: 체크 선택/해제 변화 감지
- enabled: 체크 박스 사용 가능 상태 (true일 경우 활성화)
- colors: checkbox의 색상

```kotlin
var checked by remember { mutableStateOf(false) }

Checkbox(
    checked = checked,
    onCheckedChange = { checked = it },
    enabled = ture,
    colors = CheckboxDefaults.colors(
        checkedColor = Color.Blue, // 사용 가능 상태의 배경 색상
        uncheckedColor = Color.Green, // 사용 가능 상태의 선 색상
        checkmarkColor = Color.Yellow, // 체크 마크 색상
        disabledCheckedColor = Color.Black,// 사용 불가능 상태의 배경 혹은 선 색상
        disabledIndeterminateColor = Color.Magenta // on,off 인지 상태값을 알 수 없을 때의 색
    )
)
```

## TextField
사용자 입력을 받는 텍스트 필드이다. 속성은 아래와 같다.
- value: 텍스트 필드에 표시될 현재 텍스트 값
- onValueChange: 텍스트가 변경될 때 호출되는 콜백 함수
- label: 텍스트 필드의 레이블로, 사용자가 입력할 내용을 안내하는 텍스트
- placeholder: 텍스트 필드에 입력하기 전 표시되는 안내 텍스트
- enabled: 텍스트 필드 사용 가능 상태 (true일 경우 활성화)
- isError: 텍스트 필드에 오류가 있는지 여부 (true일 경우 오류 상태)
- colors: 텍스트 필드의 색상 설정
- modifier: 텍스트 필드의 레이아웃 및 스타일을 조정하는 데 사용되는 수정자

```kotlin
var text by remember { mutableStateOf("") } // 텍스트 상태를 저장할 변수

TextField(
    value = text,
    onValueChange = { text = it },
    label = { Text("Enter your name") },
    placeholder = { Text("e.g., John Doe") },
    enabled = true, 
    isError = text.isEmpty(), // 오류 상태: 입력이 비어있으면 오류로 간주
    colors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Blue, // 포커스된 상태의 인디케이터 색상
        unfocusedIndicatorColor = Color.Gray, // 포커스 해제 상태의 인디케이터 색상
        errorIndicatorColor = Color.Red, // 오류 상태의 인디케이터 색상
        focusedLabelColor = Color.Blue, // 포커스된 상태의 레이블 색상
        unfocusedLabelColor = Color.Gray, // 포커스 해제 상태의 레이블 색상
        errorLabelColor = Color.Red, // 오류 상태의 레이블 색상
        placeholderColor = Color.LightGray // 안내 텍스트 색상
    ),
    modifier = Modifier.fillMaxWidth().padding(16.dp)
)
```

## Spacer
레이아웃 내에 빈 공간을 추가한다. 속성은 아래와 같다.
- modifier: spacer의 크기 값을 정한다.

```kotlin
Spacer(modifier = Modifier.height(16.dp))
```

## Divider
수평 또는 수직 구분선을 그린다. 속성은 아래와 같다.
- color: divider의 색상
- thickness: divider의 두께
- modifier: divider의 padding값

```kotlin
Divider(
    color = Color.Gray,
    thickness = 1.dp,
    modifier = Modifier.padding(vertical = 8.dp)
)
```

## Slot API
`Slot API`는 부모 컴포넌트가 자식 컴포넌트를 배치할 수 있는 슬롯(자리)을 제공한다.
컴포넌트를 매개변수로 받아 레이아웃의 유연성이 증가한다.
@Composable () -> Unit 람다를 통해 카드의 내용을 사용하는 측에서 정의 할 수 있다.
속성은 content가 있다.
- content: 카드의 내부를 자유롭게 구성

```kotlin
@Composable
fun CustomCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        content()  // 자식 컴포넌트
    }
}

CustomCard {
    Text("This is inside the card!")
}
```

## Scaffold
기본적인 화면 레이아웃을 쉽게 구성하기 위한 컨테이너이다.
`topBar`, `bottomBar`, `floatingActionButton` 등의 슬롯을 제공한다.
속성은 아래와 같다.
- topBar: 상단에 배치할 앱 바 - 제목 및 액션 버튼
- bottomBar: 하단에 배치할 바 - 네비게이션 바
- floatingActionButton: 플로팅 액션 버튼 정의
- content: 본문 콘텐츠를 정의
- drawerContent: 슬라이드 메뉴(내비게이션 드로어) 정의, 드로어를 사용할 경우 제공
- snackbarHost: 스낵바의 호스트를 정의(사용자에게 간단한 알림을 제공)


```kotlin
Scaffold(
    topBar = {
        TopAppBar(
            title = { Text("Scaffold Example") }
        )
    },
    floatingActionButton = {
        FloatingActionButton(onClick = { /* Handle action */ }) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
    },
    content = { paddingValues ->
        // 컨텐츠
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Hello, Scaffold!")
        }
    }
)
```