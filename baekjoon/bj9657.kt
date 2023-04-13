//DP

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(1001) { item -> "" }
    dp[1] = "SK";
    dp[2] = "CY";
    dp[3] = "SK";
    dp[4] = "SK";

    for (i in 5..n) {
        var turn: String = "SK"

        if (dp[i - 1] != turn || dp[i - 3] != turn || dp[i - 4] != turn) {
            dp[i] = turn
            continue
        }

        dp[i] = "CY"
    }
    println(dp[n])
}