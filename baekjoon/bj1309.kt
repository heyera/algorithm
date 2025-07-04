import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array(n + 1) { LongArray(3) }
    dp[1][0] = 1
    dp[1][1] = 1
    dp[1][2] = 1

    for (i in 2..n) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901
        dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901
    }

    println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901)
}