import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val t = Array(1500002) { 0 }
    val p = Array(1500002) { 0 }
    for(i in 1..n){
        val (ti, pi) = br.readLine().split(" ").map { it.toInt() }
        t[i] = ti
        p[i] = pi
    }


    val dp = Array(1500002) { 0 }

    for (i in 1..n) {
        dp[i] = maxOf(dp[i], dp[i - 1])

        val nextDay = i + t[i]
        if (nextDay <= n + 1)
            dp[nextDay] = maxOf(dp[nextDay], dp[i] + p[i])
    }
    println(maxOf(dp[n], dp[n + 1]))



}