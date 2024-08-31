class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String ab = String.valueOf(a) + String.valueOf(b);
        int abValue = Integer.parseInt(ab);
        
        int ab2 = 2 * a * b;
        
        if(abValue >= ab2){
            answer = abValue;
        } else {
            answer = ab2;
        }
        
        return answer;
    }
}