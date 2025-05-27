import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 0..n) {
        for (j in 0..i.coerceAtMost(k)) {
            if (j == 0 || j == i) dp[i][j] = 1
            else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007
        }
    }
    println(dp[n][k])
}