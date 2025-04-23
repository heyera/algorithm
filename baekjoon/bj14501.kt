import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val schedule = Array(n+2) { Pair(0, 0) }

    repeat(n) {i->
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        schedule[i+1] = (Pair(a, b))
    }

    val dp = Array(1001) { 0 }

    for (i in 1 .. n) {
        dp[i] = maxOf(dp[i], dp[i - 1])

        if (i + schedule[i].first < 1001) {
            dp[i + schedule[i].first] = maxOf(dp[i+schedule[i].first], dp[i]+schedule[i].second)
        }
    }

    println(maxOf(dp[n], dp[n + 1]))

}