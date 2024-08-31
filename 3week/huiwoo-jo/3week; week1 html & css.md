# 3주차 - 집체 특강과 html/css 강의

## 출석 인증

#### 고용노동부 HRD-NET

#### 딥다이브 11주차 HTML/CSS


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
