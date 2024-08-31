class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        int oddValue;
        int evenValue;
        
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0) {
                even += String.valueOf(num_list[i]);
            } else {
                odd += String.valueOf(num_list[i]);
            }
        }
        evenValue = Integer.parseInt(even);
        oddValue = Integer.parseInt(odd);
        answer = evenValue + oddValue;
        
        return answer;
    }
}