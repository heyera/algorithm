import java.io.BufferedReader
import java.io.InputStreamReader

private val numbers = mutableListOf<List<Int>>()


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (num, k) = br.readLine().split(" ").map { it.toInt() }

    backtracking(num, mutableListOf())

    if (numbers.size >= k) {
        println(numbers[k - 1].joinToString("+"))
    } else {
        println("-1")
    }
}

private fun backtracking(left: Int, current: MutableList<Int>) {
    if (left == 0) {
        numbers.add(current.toList())
        return
    }

    for (i in 1..3) {
        if (left - i >= 0) {
            current.add(i)
            backtracking(left - i, current)
            current.removeLast()
        }
    }
}