class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sumSquare = 0;
        int multi = 1;
        
        for(int i = 0; i < num_list.length; i++){
            sumSquare += num_list[i];
            multi *= num_list[i];
        }
    
        if(multi < (sumSquare * sumSquare)) {
            answer = 1;
        }
        
        return answer;
    }
}