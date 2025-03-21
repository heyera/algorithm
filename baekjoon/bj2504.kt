import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val brackets = br.readLine().toCharArray()

    val stack = Stack<Any>()

    for (char in brackets) {
        when (char) {
            '(', '[' -> {
                stack.push(char)
            }

            ')', ']' -> {

                var sum = 0


                while (stack.isNotEmpty()) {
                    var top = stack.pop()

                    if (top is Int) {
                        sum += top
                    } else if (char == ')' && top == '(' || char == ']' && top == '[') {
                        val multiplier = if (char == ')') 2 else 3
                        stack.push(if (sum == 0) multiplier else sum * multiplier)
                        break
                    } else if ((top == '(' || top == '[')) {
                        println(0)
                        return
                    } else {
                        println(0)
                        return
                    }
                }

                if (stack.isEmpty()) {
                    println(0)
                    return
                }
            }

        }
    }

    var result = 0
    for (item in stack) {
        if (item is Int) {
            result += item
        } else {
            println(0)
            return
        }
    }
    println(result)
}