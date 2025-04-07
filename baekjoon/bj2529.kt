import java.io.BufferedReader
import java.io.InputStreamReader


private var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    val signs = br.readLine().split(" ").map { it[0] }.toCharArray()

    val visited = BooleanArray(10)
    val results = mutableListOf<String>()

    backtracking(0, "", signs, visited, results)
    results.sort()
    println(results.last())
    println(results.first())

}

private fun check(x: Char, a: Int, b: Int): Boolean {
    return if (x == '<') a < b else a > b
}

private fun backtracking(
    idx: Int,
    num: String,
    signs: CharArray,
    visited: BooleanArray,
    results: MutableList<String>
) {
    if (idx == n + 1) {
        results.add(num)
        return
    }

    for (i in 0..9) {
        if (!visited[i]) {
            if (idx == 0 || check(signs[idx - 1], num[idx - 1] - '0', i)) {
                visited[i] = true
                backtracking(idx + 1, num + i, signs, visited, results)
                visited[i] = false
            }
        }
    }
}