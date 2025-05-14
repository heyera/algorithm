import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var nums: IntArray
private lateinit var operators: IntArray
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE
private var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    operators = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    backtracking(1, nums[0])

    println("$max\n$min")

}

private fun backtracking(depth: Int, result: Int) {
    if (depth == n) {
        max = maxOf(max, result)
        min = minOf(min, result)
        return
    }

    for (i in 0 until 4) {
        if (operators[i] <= 0) continue

        operators[i] -= 1
        val next = when (i) {
            0 -> result + nums[depth]
            1 -> result - nums[depth]
            2 -> result * nums[depth]
            3 -> result / nums[depth]
            else -> result
        }
        backtracking(depth + 1, next)
        operators[i] += 1

    }
}