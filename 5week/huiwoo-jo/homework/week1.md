## 1주차
- Text, Button, Modifier
- Surface, Box, Row, Column
- BoxWithConstraints
## Text
https://developer.android.com/jetpack/compose/text?hl=ko

### Text의 속성
Compose의 Text는 Text()로 선언하며, Xml의 TextView와 유사하다.
속성은 총 14개로 아래와 같다.
```kotlin
@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
)
```

### text
text는 표시 할 문자를 기입하는 곳이다.
직접 문자를 적거나 `stringResource`를 통해 문자열 리소스를 사용할 수 있다.
```kotlin
// 직접 텍스트를 입력
Text(
  text = "Hello World!"
)

// 문자열 리소스 사용
Text(
  text = stringResource(id = R.string.hello_world)
)
```

### modifier
크기, 레이아웃, 동작 및 모양 변경, 사용자 입력 처리, 클릭, 스크롤 등 다양한 상호작용을 설정할 수 있따.
대표적으로 width, height, padding, background 설정이 가능하다.
background에 경우 `colorResource`를 통해 색상 리소스를 사용할 수 있다.

``` kotlin
Text(
  text = "Hello World!",
  modifier = Modifier
    .background(Color.Blue) // 배경 색상 : Color 사용
    .fillMaxWidth() // xml : match parent
    .padding(bottom = 25.dp) // bottom 간격을 25.dp 만큼 띄운다
)

Text(
  text = stringResource(R.string.hello_world),
  modifier = Modifier
    .background(colorResource(id = R.color.purple_200)) // 배경 색상 : 색상 리소스 사용
    .width(300.dp) // xml : width=300dp
    .height(50.dp) // xml : height = 50dp
)
```

### color
텍스트의 색상을 변경 할 수 있다.
`colorResource`를 통해 색상 리소스를 사용할 수 있다.

``` kotlin
Text(
  text = "Hello World!",
  color = Color.Blue // Color 사용
)

Text(
  text = stringResource(R.string.hello_world),
  coolor = colorResource(id = R.color.purple_200) // 배경 색상 : 색상 리소스 사용
)
```

### fontSize / fontStyle / fontWeight / fontFamily
- fontSize : 텍스트의 크기를 설정할 수 있다.
  - 미설정시 TextUnit.Unspecified 테마에 설정된 기본값이 설정된다.
  - font 사이즈는 `sp`혹은 `em`만 사용이 가능하며 `dp`를 사용할 경우 변환이 필요하다.
   ``` kotlin
   Text("Hello World!", fontSize = 30.sp)
   ```
- fontStyle : 텍스트의 기울임꼴을 표시할 수 있다.
  ``` kotlin
  Text("Hello World!", fontStyle = FontStyle.Italic)
   ```
- fontWiehgt : 텍스트의 굵기를 표시할 수 있다.
  - Bold, Black, ExtraBold, ExtraLight, Light, Medium, SemiBold, Thin 등
  ``` kotlin
  Text("Hello World", fontWeight = FontWeight.Bold)
   ```
- fontFamily : 폰트를 설정할 수 있다.
  ``` kotlin
  Text(
    text = "Hello World",
    fontFamily = FontFamily(Font(R.font.pretendard_regular))
  )
   ```


### textDecoration / textAlign
- textDecoration : 텍스트에 밑줄, 가로줄을 설정할 수 있다.
  ```kotlin
  // decoration 하나
  Text(
    text = "Hello World",
    style = TextStyle(
      textDecoration = TextDecoration.LineThrough
    )
  )

  /// decoration 여러개
  Text(
    text = "Hello World",
    textDecoration = TextDecoration.combine(
      listOf(
          TextDecoration.LineThrough, TextDecoration.Underline
      )
    )
  )
  ```
- textAlign : 텍스트의 정렬을 설정할 수 있다.
  ``` kotlin
  Text(
    text = "왼쪽 정렬",
    textAlign = TextAlign.Start // 왼쪽 정렬
  )
  Text(
    text = "가운데 정렬",
    textAlign = TextAlign.Center // 가운데 정렬
  )
  Text(
    text = "오른쪽 정렬",
    textAlign = TextAlign.End // 오른쪽 정렬
  )
  ```

### style
fontSize, fontStyle, fontWeight, fontFamily, textAlign, textDecoration 등 텍스트의 스타일을 지정할 수 있다.
```kotlin
Text(
    text = "Hello World",
    style = TextStyle(
      textAlign = TextAlign.Justify,
      fontFamily = FontFamily(
      Font(R.font.pretendard_regular)
      )
    )
)
```

### letterSpacing / lineHeight
- letterSpacing : 글자 사이의 간격을 설정한다.
- lineHeight : 줄 간격을 설정한다.

### maxLines / overflow / softWrap
- maxLines : 최대 줄 수를 설정한다.
- overflow : 글자가 영역을 넘어갔을 경우 보여지는 방법을 설정한다.
  - Clip : 영역을 넘어간 텍스트를 자른다.
  - Ellipsis : 영역을 넘어간 텍스트를 줄임표(...) 처리한다.
  - Visible : 영역을 넘어간 텍스트를 줄바꿈한다. (maxLines)는 넘어가지 않는다.
```
Text(
  text = "테스트1".repeat(100),
  maxLines = 1, // 최대 1줄
  overflow = TextOverflow.Clip, // TextOverflow Cli
)
Text(
    text = "테스트2".repeat(100),
    maxLines = 2, // 최대 2줄
    overflow = TextOverflow.Ellipsis, // TextOverflow Ellipsis
)
Text(
  text = "테스트3".repeat(100),
  maxLines = 3, // 최대 3줄
  overflow = TextOverflow.Visible, // TextOverflow Visible
)
```
- softWrap : 글자가 영역을 넘어갔을 경우 자동으로 줄을 바꿀지 설정한다.
  - Boolean 값으로 true로 설정 시 자동 줄바꿈이 실행된다.

### shadow
텍스트의 그림자를 설정한다.
``` kotlin
Text(
  text = "Hello world",
  style = TextStyle(
    fontSize = 24.sp,
    shadow = Shadow(
    color = Color.Blue,
    offset = offset,
    blurRadius = 3f
    )
  )
)
```
### 여러 스타일 추가
`buildAnnotatedString`을 사용하여 텍스트에 여러 스타일을 추가할 수 있다.
- `SpanStyleRange`의 `List` : 텍스트 값 내의 위치 범위가 포함되는 인라인 스타일 지정한다.
- `ParagraphStyleRange`의 `List` : 텍스트 정렬, 텍스트 방향, 줄 간격, 텍스트 들여쓰기 스타일 지정한다.
``` kotlin
Text(text = buildAnnotatedString {
  append("preview와 surface의 변수를 각자 지정하면 미리보기에는 ")

  withStyle(
    style = SpanStyle(
      Color.Red,
      fontSize = 20.sp,
      fontWeight = FontWeight.W400
    )
  ) {
      append("preview")
  }

  append(" 가 출력됨")
})
```

### ClickableText / SelectionContainer
- CliableText : 클릭이 가능한 text를 생성한다.
- SelctionContainer : 드래그가 가능한 text를 생선한다.
``` kotlin
// 클릭 사용
ClickableText(
  text = AnnotatedString("This text is cliable"),
  onClick = {
  Toast.makeText(context, "Text 클릭됨!!", Toast.LENGTH_SHORT).show() // in Activity
})

// 선택 사용
SelectionContainer {
  Text("This text is selectable")
}
```

## Button
https://developer.android.com/develop/ui/compose/components/button?hl=ko

### Button API 노출 영역
Compose의 Button은 Xml의 Button과 유사하다.
버튼의 유형은 5가지이다.
|유형|디자인|목적|
|---|---|---|
|채워짐|대비되는 텍스트가 있는 단색 배경|높은 강조 버튼: '제출', '저장' 등 애플리케이션의 기본 작업에 사용됩니다. 그림자 효과는 버튼의 중요도를 강조합니다.|
|채워진 색조|배경 색상은 표면에 따라 다릅니다.|기본 작업 또는 중요한 작업에도 적용됩니다. 채워진 버튼은 '장바구니에 추가' 및 '로그인'과 같이 무게와 정장 기능을 더 시각적으로 제공합니다.|
|미열|그림자로 돋보일 수 있습니다.|색조 버튼과 비슷한 역할을 합니다. 엘리베이션을 올려 버튼이 더 눈에 띄게 표시되도록 합니다.|
|윤곽선 있음|채우기가 없는 테두리가 있습니다.|중간 강조 버튼: 중요하지만 기본적이지 않은 작업이 포함됩니다. 다른 버튼과 잘 어우러져 '취소' 또는 '뒤로'와 같은 대체 작업이나 보조 작업을 나타냅니다.|
|텍스트|배경이나 테두리 없이 텍스트를 표시합니다.|낮은 강조 버튼은 탐색 링크와 같은 덜 중요한 작업이나 '자세히 알아보기' 또는 '세부정보 보기'와 같은 보조 기능에 적합합니다.|

API 노출 영역은 4개로 아래와 같다.
- `onClick`: 사용자가 버튼을 누를 때 호출되는 함수입니다.
- `enabled`: false인 경우 이 매개변수로 인해 버튼이 사용할 수 없거나 비활성 상태로 표시됩니다.
- `colors`: 버튼에 사용되는 색상을 결정하는 ButtonColors의 인스턴스입니다.
- `contentPadding`: 버튼 내의 패딩입니다.

### 채워진 버튼
기본적으로 단색으로 채워지는 버튼이다.
`Button()`을 통해 생성하며, 내부에 `Text()`를 이용해 내부 문구를 설정한다.
``` kotlin
Button(onClick = {}) {
    Text(text= "Filled")
}
```

### 색조 버튼
`FilledTonalButton`을 통해 생성하며, 기본적으로 색조 색상으로 채워진다.
``` kotlin
FilledTonalButton(onClick = { }) {
    Text("Tonal")
}
```

### 윤곽선 버튼
테두리만 있는 버튼으로 `OutlinedButton`으로 생성한다.
``` kotlin
OutlinedButton(onClick = { }) {
    Text("Outlined")
}
```

### 돌출 버튼 : Elavation
`ElevatedButton`을 통해 생성하며, 기본적으로 고도 효과를 나타내는 그림자가 있다.
기본적으로는 그림자가 있는 윤곽선 버튼이다.
``` kotlin
// ElevatedButton으로 생성
ElevatedButton(onClick = { }) {
    Text("Elevated")
}

// elevation 속성으로 생성
Button(
    onClick = { },
    elevation = ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp
    )
) {
    Text(text = "Button elevation")
}
```

### 텍스트 버튼
`TextButton`을 사용하여 생성하며, 누를때까지는 텍스트로 표시된다.
단색 채우기 혹은 윤곽선은 없다.
``` kotlin
TextButton(
    onClick = { }
) {
    Text("Text Button")
}
```

### 비활성화 버튼
`enabled` 속성을 사용하여 버튼의 활성화 여부를 설정한다.
기본적으로는 `true`로 설정되어 있다.
``` kotlin
Button(
    enabled = false,
    onClick = { },
) {
    Text(text = "Button enabled false")
}
```

### PressedElavation
버튼을 누를 경우 그림지의 변화를 주는 속성이다.
- `defaultElevation` : 기본 그림자 상태
- `pressedElevation` : 클릭 시 그림자 상태
``` kotlin
Button(
    elevation = ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp, // 그림자 주기
        pressedElevation = 0.dp, // 클릭 시 그림자 상태
    ),
    onClick = { },
) {
    Text(text = "Button PressedElevation")
}
```

### shape
버튼의 shape를 설정한다.
아래 코드에 경우 `RoundConerShape`를 설정하여 버튼의 모서리 곡선을 설정하였다.
``` kotlin
Button(
    shape = RoundedCornerShape(10.dp), // 모서리 라운드 10dp
        onClick = { },
    ) {
        Text(text = "Button shape")
}
```

### border
버튼의 테두리를 설정한다.
`BorderStroke`를 사용하여 버튼의 굵기와 색상을 설정할 수 있다.
``` kotlin
Button(
    border = BorderStroke(4.dp, Color.Red), // 굵기 , 색상
    onClick = { },
) {
    Text(text = "Button border")
}
```

### 버튼 색상
버튼의 배경 색상을 지정한다.
- `containerColor` : 기본 색상
- `disabledContainerColor` : 비활성화 시 색상
``` kotlin
Button(
    colors = ButtonDefaults.buttonColors(
        containerColor = Color.Blue,
        disabledContainerColor = Color.Red // 버튼이 비활성시 색 지정
    ),
    onClick = { },
) {
    Text(text = "Button color")
}
```

### padding
버튼의 `padding` 값을 지정한다.
`vertical`과 `horizontal`을 개별적으로 지정할 수 있다.
``` kotlin
// 전체
Button(
    contentPadding = PaddingValues(40.dp),
    onClick = { },
) {
    Text(text = "Button padding")
}

// horizontal
Button(
    contentPadding = PaddingValues(horizontal = 40.dp),
    onClick = { },
) {
    Text(text = "Button padding")
}
```

## Modifier
`Compose`의 UI 구성 요소를 꾸미거나 행동을 추가하기 위한 요소들의 모음이다. <br>
`Composable function`에 기본 `Modifier`을 제공하면 재사용성이 높아진다.
``` kotlin
fun testComposableFun(modifier: Modifier = Modifier)
```

### 크기 조정 : width, height
- Modifier.width(width: Dp) : 너비를 width.dp로 설정
- Modifier.height(height: Dp) : 높이를 height.dp로 설정
- Modifier.fillMaxWidth(fraction: Float = 1f) : 가로 전체 채우기
  기본 설정은 전체 채우기(fraction = 1f) / 전체 대비 비율을 설정 가능
- Modifier.fillMaxHeight(fraction: Float = 1f) : 높이(세로) 전체 채우기
  기본 설정은 전체 채우기(fraction = 1f) / 전체 대비 비율을 설정 가능
- Modifier.fillMaxSize(fraction: Float = 1f) : 너비와 높이 모두 전체 채우기
  기본은 모두 채우기(fraction = 1f) / 전체 대비 비율을 설정 가능

### 여유 공간 : padding, offset
- padding : 자신을 기준으로 안쪽의 여유공간 값
  자식 컴포넌트의 크기 측정값에 영향을 준다.
- offset : 자식 컴포넌트의 크기 측정값에 영향을 주지 않고 자식 컴포넌트를 x축 혹은 y축으로 얼만큼 이동할 것인지 결정하는 값

### 스크롤 : VerticalScroll, HorizontalScroll
``` kotlin
public fun Modifier.verticalScroll(
    state: ScrollState,
    enabled: Boolean,
    flingBehavior: FlingBehavior? = null,
    reverseScrolling: Boolean = false
): Modifier
```
- state : 스크롤의 상태를 나타내는 ScrollState 객체
- enabled : 스크롤 활성화 여부
- flingBehavior : 스크롤의 플링 동작 / null : 기본 플링 동작
- reverseScrolling : 스크롤 반대 방향 설정 (false : 기존 방향 / true : 역방향)

### 클릭 가능 여부 : Cliable
``` kotlin
public fun Modifier.clickable(
    enabled: Boolean,
    onClickLabel: String? = null,
    role: Role?,
    onClick: () -> Unit
): Modifier
```

- onClickLabel: 클릭 가능한 영역에 대한 화면 낭독기 라벨
- role: 클릭 가능한 영역의 역할을 정의

### 수정자의 순서가 중요
`Modifier`의 수정자의 순서는 속성 효과에 영향을 준다
``` kotlin
@Composable
fun ArtistCard(/*...*/) {
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(padding)
            .fillMaxWidth()
    ) {
        // rest of the implementation
    }
}
```
위와 같이 `clickable` 뒤에 `padding`이 위치할 경우 `padding`영역까지 클릭이 가능하다.<br>
반대로 `padding`이 먼저 올 경우 패딩 영역은 클릭이 불가능하다.


## Surface
`Compose`에서 화면을 그리는 가장 기본 단위이다.<br>
그림자, 경계선, 배경색과 같은 시각적 효과를 자동으로 처리한다.<br>
Xml의 `MaterialCardView`와 유사하다.

### Surface의 속성
`surface`의 속성은 7가지이다.
``` kotlin
modifier: Modifier = Modifier,
shape: Shape = RectangleShape,
color: Color = MaterialTheme.colors.surface,
contentColor: Color = contentColorFor(color),
border: BorderStroke? = null,
elevation: Dp = 0.dp,
content: @Composable () -> Unit
```

### 활용 방법
`suface`에 사용 할 요소를 넣고 사용하는 것이 성능적으로 우수하다.<br>
자식 요소와 속성 값이 중복될 경우 자식의 속성이 우선 순위가 높다.

![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/c355b10b-b993-4f94-bfd0-6bb99e9c8a38)

``` kotlin
Surface(
    border = BorderStroke(width = 2.dp, color = Color.Blue),
    modifier = Modifier.padding(5.dp),
    elevation = 10.dp,
    shape = CircleShape,
    color = MaterialTheme.colors.secondary
) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(8.dp)
    )
}
```

## Box
`Compose Layout`의 한 종류로 여러 위젯을 겹쳐 놓을 수 있는 레이아웃이다.
Xml의 `Frame Layout`과 동작이 비슷하다.
`align` 속성을 사용하여 사용자의 위치를 직접 설정해야 한다.

### align 미설정
기본 설정 시 `Start` 위치에 모든 요소들이 중첩되어 정렬된다.

![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/3236e311-6937-4308-a9b5-f4c50044e4b1)

```kotlin
Box (modifier = Modifier.fillMaxHeight().weight(1f)){
    Text(text = "First")
    Text(text = "Second")
    Text(text = "Third")
}
```

### contentAlignment
`Box`의 `contentAlignment`를 사용하여 요소들의 위치를 동시에 지정할 수 있다.

![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/6a05e661-44db-4371-a5ca-d44260a4c3a4)

```kotlin
Box(modifier = Modifier.fillMaxHeight().weight(1f),
    contentAlignment = Alignment.BottomEnd) {
    Text(text = "First")
    Text(text = "Second")
    Text(text = "Third")
}
```

### Modifier.align
요소의 `Modifier.align`을 속성을 지정하여 개별적인 위치를 지정할 수 있다.

![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/965daebd-0fe5-4f36-8b2e-32e1ebf45e76)

```kotlin
Box (modifier = Modifier.fillMaxHeight().weight(1f)){
    // Top
    Text(modifier = Modifier.align(Alignment.TopStart), text = "1")
    Text(modifier = Modifier.align(Alignment.TopCenter), text = "2")
    Text(modifier = Modifier.align(Alignment.TopEnd), text = "3")

    // Center
    Text(modifier = Modifier.align(Alignment.CenterStart), text = "4")
    Text(modifier = Modifier.align(Alignment.Center), text = "5")
    Text(modifier = Modifier.align(Alignment.CenterEnd), text = "6")

    // Bottom
    Text(modifier = Modifier.align(Alignment.BottomStart), text = "7")
    Text(modifier = Modifier.align(Alignment.BottomCenter), text = "8")
    Text(modifier = Modifier.align(Alignment.BottomEnd), text = "9")
}
```

### 두 속성의 중첩
`Box`의 `contentAlignment`와 요소의 `modifier`을 같이 설정할 경우 개별적으로 설정한 속성값이 우선 순위가 높다.

![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/cfc7b6d6-05f2-496b-aff9-dc652ca422c0)

```kotlin
Box(modifier = Modifier.fillMaxHeight().weight(1f),
    contentAlignment = Alignment.BottomEnd) {
    Text(modifier = Modifier.align(Alignment.TopStart), text = "First")
    Text(modifier = Modifier.align(Alignment.Center), text = "Second")
    Text(modifier = Modifier.align(Alignment.BottomEnd), text = "Third")
}
```
  
## Row
항목을 화면에 가로에 배치할 때 사용한다.

![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/b80515e0-fec4-4b55-9062-bef728ed6fee)

  ``` kotlin
  Row {
    Text("Alfred Sisley")
    Text("3 minutes ago")
  }
  ```
### Column
항목을 화면에 세로로 배치할 때 사용한다.

  ![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/5b301e02-3f43-4c1a-bc9f-20aadb5be153)

  ``` kotlin
  Column {
    Text("Alfred Sisley")
    Text("3 minutes ago")
  }
  ```
### Row / Column
horizontalArrangement, verticalArrangement 파라미러를 사용하여 Row/Column 자식들 컴포넌트들의 간격을 조정할 수 있다.
`spaceBy`를 사용하여 간격을 설정할 수도 있다.

  ![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/93b05a27-a355-4650-9e9f-e8bf91dcd48c)

  ``` kotlin
  Row(verticalAlignment = Alignment.CenterVertically) {
      Image(bitmap = artist.image, contentDescription = "Artist image")
      Column {
          Text(artist.name)
          Text(artist.lastSeenOnline)
      }
  }
  ```
|Row|Column|
|---|---|
|![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/7b41af25-bd69-4b6e-909d-89454b82bf50)|![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/8175dc60-a1de-4aad-bac3-691e645b0fd4)|

## BoxWithConstraints
`Box Layout`의 기능을 모두 포함하면서 `Layout`의 `Constraint도 접근이 가능한 레이아웃이다.<br>
`minWidth`, `maxWidth`, `minHeight`, `maxHeight` 값을 `dp`로 접근할 수 있다.

### minHeight가 지정 값 보다 큰 경우 : if
![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/9952d88e-ca64-486a-8bf0-8800f6e6c8f8)

``` kotlin
@Preview(showBackground = true)
@Composable
fun BoxLargerContainer() {
    Row(modifier = Modifier.height(250.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            if (this.minHeight > 220.dp) {
                Text(text = "Larger then 220dp")
            }
            if (this.minHeight < 220.dp) {
                Text(text = "Smaller then 220dp")
            }
            if (this.minHeight == 220.dp) {
                Text(text = "This is 220dp")
            }
            Text(
                modifier = Modifier.align(Alignment.BottomStart), text = "minHeight :${this.minHeight}"
            )
        }
    }
}
```
### minHeight가 지정 값과 같은 경우 : if-else
![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/7ef0d96d-67f6-4cc0-8114-1e46c03568e9)

``` kotlin
@Preview(showBackground = true)
@Composable
fun BoxBoundaryContainer() {
    Row(modifier = Modifier.height(220.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            if (this.minHeight > 220.dp) {
                Text(text = "Larger then 220dp")
            } else if (this.minHeight < 220.dp) {
                Text(text = "Smaller then 220dp")
            } else{
                Text(text = "This is 220dp")
            }
            Text(
                modifier = Modifier.align(Alignment.BottomStart), text = "minHeight :${this.minHeight}"
            )
        }
    }
}
```

### minHeight가 지정 값보다 작을 경우 : when
![image](https://github.com/BraekCompose/Huiwoo/assets/84004687/10ec725a-32a5-4e2a-ac2e-8c01c6721d1f)

``` kotlin
@Preview(showBackground = true)
@Composable
fun BoxSmallerContainer() {
    Row(modifier = Modifier.height(200.dp)) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            Text(text =
                when{
                    this.minHeight > 220.dp -> "Larger then 220dp"
                    this.minHeight < 220.dp -> "Smaller then 220dp"
                    else -> "This is 220dp"
                }
            )
            Text(
                modifier = Modifier.align(Alignment.BottomStart), text = "minHeight :${this.minHeight}"
            )
        }
    }
}
```

