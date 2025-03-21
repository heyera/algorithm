import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t) { case ->
        val n = br.readLine().toInt()
        makeNumList(mutableListOf(), n - 1)

        if (case != t - 1) println()
    }
}


fun makeNumList(operators: MutableList<Char>, size: Int) {
    if (operators.size == size) {
        val result = buildNumList(operators)

        if (calculate(result) == 0) {
            println(result)
        }
        return
    }

    for (op in listOf(' ', '+', '-')) {
        operators.add(op)
        makeNumList(operators, size)
        operators.removeLast()
    }
}


fun buildNumList(operators: List<Char>): String {
    val sb = StringBuilder()
    for (i in 1..operators.size + 1) {
        sb.append(i)
        if (i <= operators.size) {
            sb.append(operators[i - 1])
        }
    }
    return sb.toString()
}

fun calculate(expr: String): Int {
    var sum = 0
    var num = ""
    var sign = 1

    for (ch in expr) {
        when (ch) {
            '+' -> {
                sum += sign * num.toInt()
                num = ""
                sign = 1
            }

            '-' -> {
                sum += sign * num.toInt()
                num = ""
                sign = -1
            }

            ' ' -> continue
            else -> num += ch
        }
    }

    sum += sign * num.toInt()
    return sum
}
