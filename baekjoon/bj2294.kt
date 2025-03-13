import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val dp = Array(10001) { 10001 }
    val coins = mutableListOf<Int>()

    repeat(n) {
        val coin = br.readLine().toInt()
        if (coin <= k) dp[coin] = 1
        coins.add(coin)
    }

    dp[0] = 0

    for (i in 1..k) {
        coins.forEach { coin ->
            if (i - coin >= 0) {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }

    println(if (dp[k] == 10001) -1 else dp[k])
}