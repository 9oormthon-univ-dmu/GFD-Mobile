# 3주차 - 집체 특강과 html/css 강의

## 출석 인증

#### 고용노동부 HRD-NET
![image](https://github.com/user-attachments/assets/153f8f3b-cbb1-4a97-8be6-0d9d8e91def0)


#### 딥다이브 11주차 HTML/CSS
<img width="1494" alt="image" src="https://github.com/user-attachments/assets/6ab605d6-a6e0-4c41-a359-ac5634058b20">
<img width="1494" alt="image" src="https://github.com/user-attachments/assets/cde7bdfe-5c13-4a6c-9bcb-c671f0140c43">
<img width="1494" alt="image" src="https://github.com/user-attachments/assets/a3694df8-79d2-4efb-a4d1-8f5209402ad9">
<img width="1494" alt="image" src="https://github.com/user-attachments/assets/d621fdd3-7995-45cd-ab98-0e812d08e847">



## 공부 내용 정리

### 프로그램

1. **Web Browser**: 크롬
2. **Editor**: Visual Studio Code

### HTML

#### HTML 개요

- **HTML**: 하이퍼 텍스트 마크업 언어로, 웹 페이지를 구성하는 기본 언어.
  - 웹을 이루는 가장 기초적인 구성 요소
  - 웹 페이지를 만들기 위한 표준 마크업 언어

#### HTML의 구성 요소

- 요소 (Element)
  - 구성: 시작 태그, 종료 태그, 내용
  - 종류:
    - 빈 요소 (Empty Element): 내용 없이 구조 기능만 수행 (`<br />`, `<hr />`)
    - 블록 요소 (Block Element): 다른 블록 요소와 인라인 요소를 포함 가능하며, 다음 줄에 이어서 나타남 (`<h1>`, `<div>`, `<p>` 등)
    - 인라인 요소 (Inline Element): 블록 요소 안에 포함되며, 다른 인라인 요소를 포함 가능하지만 블록 요소는 포함 불가 (`<a>`, `<span>`, `<strong>` 등)

- 태그 (Tag)
  - 웹 문서를 구성하는 명령어로 꺾새 안에 정보를 정의
  - 요소의 일부로 시작 태그와 종료 태그로 나뉨
  - 예: `<br />`, `<hr />`와 같이 내용과 종료 태그가 없는 태그도 존재

- 속성 (Attribute)
  - 태그를 보조하는 명령어로 태그 안쪽에 위치
  - 태그의 기본 기능 외 추가적인 명령 수행
  - 예: `width`, `height`, `alt`, `style`, `href` 등

#### HTML의 기본 구조

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
</body>
</html>
```
- Doctype
  - 문서 시작에 명시: 문서의 버전을 나타내며 필수 작성 요소
  - `<!DOCTYPE html>` : HTML5 버전 명시

- Html
  - HTML 문서 정의: 문서가 HTML로 작성되었음을 브라우저에 알림
  - 문서의 시작과 끝: `<html>`로 문서의 시작과 끝을 정의
  - 언어 설정: `lang` 속성으로 문서의 언어를 설정 e.g.) `lang="en"`

- Head
  - 메타데이터와 타이틀 기입: 웹 페이지의 메타 정보와 브라우저 창 제목을 정의
  - 메타데이터: 웹 페이지 인코딩 방식, 검색 엔진 정보 설정
  - 타이틀: 브라우저 창 제목에 출력

- Body
  - 브라우저 화면 출력: 브라우저에 표시될 콘텐츠 작성
  - 콘텐츠 요소: 이미지, 리스트, 비디오 등
  - 단일 Body: HTML 문서에는 단 하나의 `<body>`만 존재

 ### HTML 기본 태그와 역할

#### Heading
- 제목 태그: `<h1>`부터 `<h6>`까지
  - 주로 웹 페이지의 제목으로 사용
  - `<h1>`은 한 페이지에 한 번만 사용하는 것을 추천

#### Paragraphs (`<p>`)
- 단락 태그: 문단을 정의할 때 사용
  - 블록 태그로, 자동으로 줄 바꿈이 포함됨

#### Preformatted Text (`<pre>`)
- 미리 정의된 텍스트 형식: 여백과 줄 바꿈을 그대로 출력

#### List (목록)
- 순서 있는 목록: `<ol>`
  - 숫자로 나열하여 표시
- 순서 없는 목록: `<ul>`
  - 글머리 기호로 표시
- 설명 목록: `<dl>`
  - 이름-값 형식으로 제시

### 텍스트 서식

#### Strong / Em

- `<strong>` / `<em>`: 의미적 태그로, 텍스트의 중요성이나 강조를 나타냄.
  - `<strong>`: 강한 강조를 의미하며, 일반적으로 굵게 표시됨.
  - `<em>`: 강조를 의미하며, 일반적으로 이탤릭체로 표시됨.

#### 인용

- `<blockquote>`: 인용 블록 요소로, 들여쓰기를 통해 인용문을 강조.
- `<q>`: 인라인 인용 요소로, 따옴표를 사용하여 텍스트를 인용함.

### CSS: Cascading Style Sheets

CSS는 사용자에게 문서를 표시하는 방법을 지정하는 언어로, 주로 스타일, 레이아웃 등을 정의합니다. HTML이 문서의 구조를 결정하는 반면, CSS는 문서를 브라우저에 어떻게 보여줄지를 지정하여 구조와 디자인을 분리합니다.

#### CSS 사용 방법

1. 인라인 스타일
   - HTML 요소 내에서 `style` 속성을 사용하여 직접 지정.
  
2. 내부 스타일 시트
   - HTML 파일 내 `<style>` 태그를 사용하여 스타일을 정의.
  
3. 외부 스타일 시트
   - 별도의 CSS 파일을 생성하고, HTML 파일에서 `<link>` 태그를 사용하여 해당 파일을 로드하여 사용.

#### 스타일 적용 우선순위

1. 인라인 스타일
2. 내부 스타일 시트, 외부 스타일 시트
3. 웹 브라우저 기본 스타일

혼합된 스타일 적용 시, 인라인 스타일이 가장 우선 적용됩니다.

### CSS 기본 구조

1. 선택자
   - CSS를 적용할 위치의 HTML 요소.
2. 프로퍼티
   - 셀렉터가 지정한 위치와 무엇을 바꿀지를 결정.
3. 값
   - 프로퍼티로 지정한 것을 얼마나 바뀌게 할지 결정.

### CSS 속성 (프로퍼티)

#### Button

- Background-color
  - 배경 색을 지정.
  - 색이름: `white`, `black`, `blue`.
  - RGB: `rgb(10, 150, 25)`.
  - Hex: `#1D9CF0`.

- Colors
  - 텍스트 색을 지정.

- Height
  - 높이 지정.
  - 픽셀값 또는 퍼센트로 설정.

- Width
  - 너비를 지정.

- Border
  - `none`: 테두리 제거.

- Border-radius
  - 둥근 모서리를 만듦.

- Cursor
  - 요소 위로 마우스 커서를 가져갈 경우 마우스 모양을 변경.

- Border-color
  - 테두리 색상 지정.

- Border-style
  - `solid`, `dashed`, `dotted`.

- Border-width
  - 테두리 너비 지정.

### 색을 표현하는 방법

1. 색 이름
   - 예: `black`, `blue`, `white`.

2. RGB 값
   - 색상을 표현하는 보다 정확한 방법.
   - 빨강, 초록, 파랑의 조합을 사용하여 색상 생성.
   - 숫자 값: 0~255.
     - 검정: `rgb(0, 0, 0)`.
     - 흰색: `rgb(255, 255, 255)`.

3. HEX 값
   - RGB 값을 표현하는 다른 방법.
   - 16진수를 사용하여 값을 표현 (0~9, A~F).
   - 2개의 문자를 사용하여 16 * 16의 값을 조합.
   - RGB와 동일한 범위로 각 2자씩 순서대로 Red, Green, Blue를 나타냄.
   - RGB to Hex 계산기를 사용.

4. RGBA 값
   - RGB 값과 기본적으로 동일.
   - 값은 색상의 투명도를 결정.
     - 0: 완전한 투명.
     - 1: 단색 및 투명도 없음.
     - 0.5: 50% 투명.

### 수치값 표현 방법

1. 픽셀
   - 고정된 절대값.
   - 디지털 세계에서 일반적인 측정 단위.

2. 퍼센트
   - Viewport의 높이와 너비에 따라 상대적으로 측정.

3. Em, Rem
   - 환경에 따라 변하는 가변 단위.
   - Em: 같은 엘리먼트에서 지정된 폰트 사이즈를 기준으로 px로 변경.
     - 같은 엘리먼트에 지정된 폰트가 없을 경우 상위 요소의 폰트 사이즈를 기준으로 변경.
     - `font-size: 10px` ⇒ `2em: 20px`.

   - Rem: 최상위 엘리먼트에 지정된 폰트 사이즈를 기준으로 px를 변경.
     - 별도의 폰트 사이즈가 없을 경우 브라우저의 기본 크기로 값이 지정됨.

### CLASS 속성

- CSS로 특정 요소를 대상으로 지정.
- 요소에 클래스를 추가; 클래스 이름(“…”) 사이의 텍스트는 무엇이든 될 수 있음.
- 여러 요소가 동일한 클래스를 가질 수 있음.
- 요소는 공백으로 구성된 클래스를 여러 개 가질 수 있음.


### Transition

스타일 변경 시 부드럽게 전환합니다. 선택자가 변화될 때 시간의 흐름을 줘서 변화시키는 방법입니다. `all`은 모든 요소에 적용됩니다.

### 가상 클래스 (의사 클래스) / 가상 요소 (의사 요소)

#### 가상 클래스

별도의 클래스를 지정하지 않고도 요소를 선택할 수 있습니다.

- `:first-child` vs `:first-of-type`
  - `:first-child`: 부모 요소의 하위 요소 중 첫 번째 요소를 선택합니다.
  - `:first-of-type`: 부모 요소의 하위 요소들 중 특정 타입의 첫 번째 요소를 선택합니다.

#### 가상 요소

존재하지 않는 요소를 존재하는 것처럼 부여하여 문서의 특정 부분을 선택할 수 있습니다.

- `::before` / `::after`: 요소의 앞뒤에 콘텐츠를 삽입합니다.

### Float CSS

컨테이너의 왼쪽 혹은 오른쪽에 요소를 배치하여 텍스트 및 인라인 요소가 주위를 둘러쌀 수 있도록 합니다. 페이지의 정상 흐름에 벗어나지만 흐름에 포함되도록 합니다.

### Clear CSS

Float의 영향을 받지 않도록 설정합니다. 지정 가능한 속성은 `none`, `left`, `right`, `both`, `inherit`입니다.

### Margin, Padding, Border

Box Model은 HTML을 감싸는 상자입니다.

- Content: 텍스트와 이미지가 나타나는 상자의 내용.
- Border: 패딩과 콘텐츠를 둘러싸는 테두리.
- Margin: 콘텐츠 밖의 영역이며, 음수로 지정할 수 있습니다.
- Padding: 콘텐츠 주변 영역입니다.

### Text Style

- `font-family`: 글꼴을 변경합니다.
- `font-size`: 폰트 크기를 지정합니다.
- `font-weight`: 폰트의 굵기를 설정합니다.
- `text-align`: 텍스트 정렬을 지정합니다.
  - `left`, `right`, `center`, `justify`, `initial`, `inherit`
- 텍스트 요소인 `<span>`, `<a>`, `<strong>`, `<u>`로 텍스트 라인 내 표현 가능.

### Image

- `src`: 이미지 소스의 URL을 지정합니다.
- `alt`: 이미지를 보여줄 수 없을 때 대체할 텍스트를 제공합니다. 이미지가 로드되지 않거나 시각 장애인을 위한 스크린 리더 등에서 사용됩니다.
- `width`, `height`: 이미지의 크기를 지정합니다. 둘 다 지정할 경우 이미지가 늘어날 수 있습니다.
- `object-fit`: 이미지가 늘어나지 않게 합니다.
  - `fill`, `contain`, `cover`, `none`, `scale-down`
- `object-position`: 영역 내의 이미지 위치를 결정합니다.

### Input

HTML에서 다양한 타입의 사용자 입력 창을 제공합니다.
- `text`, `password`, `radio`, `checkbox`, `file`, `select`, `textarea`, `button`, `submit`, `fieldset`

### Transform

요소를 변형하는 속성입니다.

- `transform`: `none`, `transform-function`, `inherit`
- `transform-function`: 다양한 변형 함수를 사용합니다.
  - `scale()`, `skewX()`, `skewY()`, `translate()`, `rotate()`, `matrix()`, `perspective()`

### Animation

요소의 스타일을 다른 스타일로 점진적으로 변환합니다. 몇 가지 keyframes을 지정해야 하며, keyframe은 특정 시간에 요소의 스타일을 유지합니다.

### Background-clip

요소 내에서 배경(색상 또는 이미지)이 확장되어야 하는 거리를 정의합니다.

### Flexbox

반응형 레이아웃 제작  
1차원 레이아웃 제공  
CSS3에서 도입

### Flexbox 요소

- Flex Container
  - `flex`, `inline-flex`
- Flex Items
  - Flex Container의 직계 자식

### Flex 축

- Main Axis (주축)
  - `flex-direction`
- Cross Axis (교차축)
  - Main Axis의 수직

### Flex Container Properties

1. Flex-direction
   - Main Axis 방향, 위치
2. Flex-wrap
   - 아이템 줄바꿈
     - `nowrap`, `wrap`, `wrap-reverse`
3. Flex-flow
   - `flex-direction`, `flex-wrap` 결합
4. Justify-content
   - 주축 정렬
     - `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, `space-evenly`
5. Align-items
   - 교차축 정렬
     - `flex-start`, `flex-end`, `center`, `stretch`, `baseline`
6. Align-content
   - 수직축 라인 기준 정렬
7. Align-self
   - 개별 요소 정렬

### Flex Items Properties

1. Order
   - 나열 순서, 기본값 0, 음수 가능
2. Flex-grow
   - 아이템 크기 확대, 기본값 0, 음수 불가능
3. Flex-shrink
   - 아이템 크기 축소, 기본값 1, `flex-wrap`에서 적용되지 않음
4. Flex-basis
   - 기본 크기 정의, 기본값 `auto`
5. Flex
   - `flex-grow`, `flex-shrink`, `flex-basis` 결합
     - 값 하나: `grow` 또는 `basis`
     - 값 두 개: 첫째는 `grow`, 둘째는 `shrink` 또는 `basis`
     - 값 세 개: `grow`, `shrink`, `basis`

### Grid CSS

2차원 레이아웃에서 정렬

### Grid CSS Properties

1. Gap
   - Column gap, row gap
   - 요소들 사이의 공백

2. Grid-template-columns, Grid-template-rows
   - 공백으로 구분된 값으로 열과 행 정의

3. Repeat
   - 동일한 값으로 반복 생성

4. 1fr
   - Fraction
   - 사용 가능한 공간 비율

5. Grid-column-start, Grid-column-end, Grid-row-start, Grid-row-end
   - 요소의 시작과 끝 부분 지정

### Display: Table

- `float`, `grid`로 대체
- 테이블처럼 작동, `tr`, `td` 사용하지 않음

### Position CSS

요소의 위치를 정의

1. Static
   - 기본값, 자동 배치, 임의 설정 불가능

2. Relative
   - 자기 자신을 기준으로 원래 위치에서 좌표 지정

3. Absolute
   - 부모 요소를 기준으로 배치
   - 부모 요소 중 `static`이 아닌 요소가 기준
   - `static`이 없으면 `body`를 기준

4. Fixed
   - 스크롤과 상관없이 좌측 상단 기준으로 좌표 고정

5. Sticky
   - 스크롤 영역을 기준으로 배치
   - 스크롤 위치에 따라 `static`과 `fixed` 요소 사이 전환

### Z-index

요소의 앞, 뒤 위치를 지정

- `Z-index`가 높은 요소가 위에 나타남
- 음수 사용 가능
- `position: static`이 기본
- 부모끼리 `z-index` 설정 후 자식 적용

### Media Query

반응형 웹디자인 제작

- 화면 해상도, 기기 방향 등에 따라 스타일 전환
- 문법: `@media [only | not] [미디어 유형] [and | ,] (조건문) {실행문}`

- `only`: 미디어 쿼리를 제공하는 브라우저에서만 적용
- `not`: 미디어 쿼리를 제공하지 않는 브라우저 설정
- `and`: 조건이 모두 true
- `,`: 조건 중 하나만 충족해도 true

- 주의 사항
  - `min`: 크기 작은 순서로 작성
  - `max`: 크기 큰 순서로 작성

### CSS 적용 우선순위

1. `!important` 속성
2. HTML `style` 직접 지정 속성
3. `#id`로 지정한 속성
4. `.클래스`, `:가상 클래스`로 지정한 속성

### Box Sizing

박스의 크기를 기준으로 결정

### 사용자 지정 속성 (CSS Variable)

- 정의: 문서 전반적으로 재사용할 임의의 값
- 사용: CSS 변수 지정하여 사용
- JavaScript로 변경 가능

### 사용자 지정 속성 재정의 (Overriding)

- 특정 섹션에서 CSS 변수 지정하여 사용

### SVG (Scalable Vector Graphic)

- 벡터 데이터를 사용하는 이미지 형식
- 장점
  - 텍스트 편집기에서 수정 가능
  - JS, CSS로 조작 가능
  - 크기와 관계없이 해상도 유지
  - 스크린 리더 호환

- 단점
  - 고품질 사진 출력 어려움
  - 최신 브라우저만 지원
  - 코드 이해 어려움
