class Solution {
    fun solution(n: Int): Int {
        if(n<3) return n
        
        var a = 1
        var b = 2
        var result = 0
        
        for (i in 3..n) {
            result = (a + b) % 1234567
            a = b
            b = result
        }
        
        return result
    }
}