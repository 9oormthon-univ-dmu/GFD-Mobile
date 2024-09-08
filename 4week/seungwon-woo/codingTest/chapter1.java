import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에 입력한 숫자를 읽어 int로 변환
        int line = Integer.parseInt(br.readLine());

        // string 형식의 모음 배열 생성
        String[] vowel = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};

        // 입력된 문자열을 저장할 배열
        String inputStr[];

        // 입력된 숫자만큼 반복
        for(int i = 0; i < line; i++){
            // 모음 유무 판단
            int count = 0;
            // 한 줄씩 읽어옴
            String str = br.readLine();
            // 한 글자씩 분리해 배열에 저장
            inputStr = str.split("");
            // 비교
            for(int j = 0; j < inputStr.length; j++){
                for (String s : vowel) {
                    if (s.indexOf(inputStr[j]) != -1) {
                        System.out.print(inputStr[j]);
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println("???");
            }
        }
    }
}