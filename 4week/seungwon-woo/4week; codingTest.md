# 코딩테스트 - 구름
## chapter2
```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 사용자가 입력한 값 int로 변환
        String[] num = input.split(" ");
        int a = Integer.parseInt(num[0]);
        int b = Integer.parseInt(num[1]);

        // a != b이면 답은 2(풀이 찾아봄)
        if (a != b){
            System.out.println(2);
        } else { // a == b이면 가장 작은 약수 출력
            for (int i = 2; i <= Math.sqrt(a); i++) { // 1은 제외하기로 했으니 2부터 증가, Math.sqrt : 제곱근을 구하기 위해 사용
                if (a % i == 0) {
                    System.out.println(i); // 가장 작은 약수를 구하고 끝
                    break;
                }
            }
            System.out.println(a);
        }
    }
}
```
- 입력한 숫자 사이의 모든 약수를 구함
- 구한 약수 중 가장 빈도가 많은 약수를 구함
- 빈도수가 같은 경우 가장 작은 수를 구함
> KDT 중도 하차의 이유로 문제는 축약해서 정리했습니다.
## 문제 도출 과정
- 코드를 작성하다 모르겠어서 구글링을 통해 문제 풀이를 보았음.    
"a와 b가 다른 경우 가장 많고 작은 약수는 2다."를 보고 a != b의 경우에 2를 출력하는 것으로 함.
- a와 b가 같은 경우는 가장 작은 약수를 구하는 것으로 함. 
## 소감
- 해당 문제는 **그리디 알고리즘**이었다.    
처음 문제를 읽었을 때 반복문을 중첩해서 풀다가 오류가 발생해 해설을 찾아보았다.    
그리디 알고리즘은 문제를 잘 읽어보고 출제자의 의도를 판단하는 것이 중요한 것 같다... 
## 교내스터디 방향성
> 개인적인 사정으로 KDT를 중도 하차하게 되었다. 때문에 교내스터디의 주제가 개별 주제로 바뀌게 되었다.   
KDT 수강 철회 과정과 이번 주 스터디 과정이 겹치게 되어, 스터디 내용이 아쉽게 되었다.. 
### 교내스터디 계획 정리
- 다음 주부터는 **"코드팩토리의 플러터 프로그래밍"이라는 교재**의 내용을 중점적으로 교내 스터디를 진행할 것이다. 또한 졸업작품을 진행하며 겪은 **오류의 해결방향**도 스터디 내용에 포함할 예정이다. 