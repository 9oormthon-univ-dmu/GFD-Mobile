import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        
        val openBrackets = charArrayOf('(', '{', '[')
        val closeBrackets = charArrayOf(')', '}', ']')
        
        var answer = 0

        val queue: Queue<Char> = LinkedList<Char>()
        s.forEach { queue.add(it) }

        
        fun blacketCheck(str: String): Boolean {
            
            val stack = Stack<Char>()
            
            for (char in str) {
                if (char in openBrackets) {
                    stack.push(char)
                } else {
                    val index = closeBrackets.indexOf(char)
                    
                    if (index != -1 && stack.isNotEmpty() && stack.peek() == openBrackets[index]) {
                        stack.pop()
                    } else {
                        return false
                    }
                }
            }
            
            return stack.isEmpty()
        }

        repeat(s.length) {
            if (blacketCheck(queue.joinToString(""))) {
                answer++
            }
            
            val first = queue.remove()
            queue.offer(first)
        }
        
        return answer
    }
}