class Solution {
    fun solution(n: Int, locationA: Int, locationB: Int): Int {
        
        var a = locationA
        var b = locationB
        var turn =0
        
        while(a!=b){
            a = (a+1)/2
            b = (b+1)/2
            turn++
        }

        return turn
    }
}