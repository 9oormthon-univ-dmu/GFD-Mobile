import java.util.ArrayDeque

class Solution {
    fun solution(numbers: IntArray): IntArray {
        
        val len = numbers.size
        val answer = IntArray(len)
        val stack = ArrayDeque<Int>()

        for (i in numbers.indices) {
            while (stack.isNotEmpty() && numbers[stack.peekLast()] < numbers[i]) {
                answer[stack.removeLast()] = numbers[i]
            }
            stack.addLast(i)
        }

        while (stack.isNotEmpty()) {
            answer[stack.removeLast()] = -1
        }

        return answer
    }
}
