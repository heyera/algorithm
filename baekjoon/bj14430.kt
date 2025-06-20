import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n) { IntArray(m) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            val fromTop = if (i > 0) dp[i - 1][j] else 0
            val fromLeft = if (j > 0) dp[i][j - 1] else 0
            dp[i][j] = maxOf(fromTop, fromLeft) + map[i][j]
        }
    }


    println(dp[n - 1][m - 1])

}