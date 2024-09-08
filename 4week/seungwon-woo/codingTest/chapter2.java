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