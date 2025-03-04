import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()

    val result = StringBuilder()

    repeat(testCase) {
        val commands = br.readLine()
        val size = br.readLine().toInt()
        val inputList = br.readLine().trim('[', ']')

        val deque = ArrayDeque<Int>()
        if (inputList.isNotEmpty()) {
            deque.addAll(inputList.split(",").map { it.toInt() })
        }

        var reverseFlag = false
        var errorFlag = false

        for (command in commands) {
            when (command) {
                'R' -> reverseFlag = !reverseFlag
                'D' -> {
                    if (deque.isEmpty()) {
                        errorFlag = true
                        break
                    }
                    if (reverseFlag) deque.removeLast() else deque.removeFirst()
                }
            }
        }

        if (errorFlag) {
            result.append("error\n")
        } else {
            val resultList = if (reverseFlag) deque.reversed() else deque
            result.append(resultList.joinToString(",", "[", "]")).append("\n")
        }
    }
    println(result)
}
