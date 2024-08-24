class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ab = String.valueOf(a) + String.valueOf(b);
        String ba = String.valueOf(b) + String.valueOf(a);
        
        int abValue = Integer.parseInt(ab);
        int baValue = Integer.parseInt(ba);
        
        if(abValue > baValue) {
            answer = abValue;
        } else {
            answer = baValue;
        }
        
        return answer;
    }
}