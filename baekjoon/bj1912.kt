import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n) { 0 }

    dp[0] = arr[0]
    var result = dp[0]

    for (i in 1 until n) {
        dp[i] = maxOf(dp[i - 1] + arr[i], arr[i])
        result = maxOf(dp[i], result)
    }

    println(result)

}