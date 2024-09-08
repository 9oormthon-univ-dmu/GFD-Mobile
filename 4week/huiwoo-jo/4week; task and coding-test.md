## 과제
### 과제 2 : TodoApp
<b>과제 조건</b>
- 자바 스크립트를 사용하여 Todo 앱 만들기
- 변수명을 최대한 명확하게 하며, 함수는 최소한의 단위로 나눠서 사용합니다.
- 페이지를 새로고침 해도 데이터가 지속될 수 있게 합니다. (localStorage)

<b>과제 업로드</b>
- 동일 폴더의 ```TodoApp```에 업로드하였습니다.

<hr />


### 과제 3 : Github Finder
<b>과제 조건</b>
- 자바 스크립트를 사용하여 github finder 앱 만들기
- 자바스크립트 OOP를 이용해서 구현합니다.
- 비동기 통신을 이용합니다.
- 위에 기능 외에 잔디밭 기능, Spinner 기능 등 원하는 기능을 추가해봅니다.

<b>과제 업로드</b>
- 잔디밭 기능을 추가하였습니다.
- 동일 폴더의 ```githubFinder```에 업로드하였습니다.

<hr />

## 코딩 테스트
### 개요
일주일에 한 번 딥다이브 과정에서 코딩테스트를 진행하여, 대비를 위해 ```알고리즘 위클리 챌린지```를 진행합니다.<br>
코딩테스트 난이도로 인하여 많은 문제를 풀지 못하였습니다.

### 가장 어려웠던 문제
<b>인싸가 되고 싶은 민수 ★2</b>
### 코드
```
import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        if (start == end) {
            System.out.println(findSmallestDivisor(start));
        } else {
            System.out.println(2);
        }
    }

    private static int findSmallestDivisor(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }
}
```
### 풀이 방법
<pre>
숫자 a와 b범위에서 반복문을 돌면서 약수를 구하고, 2를 제외하고 가장 많이 등장한 약수를 찾아야한다.
말 그대로 a와 b의 모든 약수를 구하고 그 안에서 약수를 카운팅 하였으나, 그러면 시간초과가 발생한다.
해설을 보니 n의 배수와 2의 배수의 차이를 계산하여 구간의 길이가 1인 경를 구하여야한다.
a와 b가 다를 때의 답은 2, 아닐 경우는 a 또는 b의 2 이상의 가장 작은 약수가 된다.
해설을 보고 나서 다른 접근법을 보니 큰 충격을 받았다.
</pre>

## 스터디 방식 변화
팀원의 kdt 하차로 인하여 개별 스터디 방식으로 변화되었다.
<pre>
  
</pre>





