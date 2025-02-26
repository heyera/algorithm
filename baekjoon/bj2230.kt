import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val numbers = List(n) { br.readLine().toInt() }.sorted()

    var left = 0
    var right = 0
    var result = Int.MAX_VALUE

    while (left < n) {
        val difference = numbers[left] - numbers[right]

        if (difference < m) {
            left++
        } else {
            result = result.coerceAtMost(difference)
            if (result == m) break
            right++
        }
    }
    println(result)

}