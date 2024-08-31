class Solution {
    fun solution(n: Int): Int {
        
        var arr = IntArray(n + 1){1}
        arr[0] = 0
        
        if (n > 2) {
            (3..n).forEach { arr[it] = (arr[it-1] + arr[it-2]) % 1234567 }
        }
        
        return arr[n]
    }
}