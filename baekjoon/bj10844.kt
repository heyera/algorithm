import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array(n + 1) { LongArray(10) }

    for (j in 1..9) {
        dp[1][j] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            if (j > 0) dp[i][j] += dp[i - 1][j - 1]
            if (j < 9) dp[i][j] += dp[i - 1][j + 1]
            dp[i][j] = dp[i][j] % 1000000000
        }
    }

    println(dp[n].sum() % 1000000000)

}