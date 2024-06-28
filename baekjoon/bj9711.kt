import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dp = Array<BigInteger>(10001) { BigInteger.ZERO }
    dp[0] = BigInteger.ONE
    dp[1] = BigInteger.ONE
    makeNum(dp,10000)

    repeat(br.readLine().toInt()) { i ->
        val (p, q) = br.readLine().split(" ").map { it.toInt() }
        println("Case #${i + 1}: ${dp[p-1].mod(q.toBigInteger())}")
    }


}

fun makeNum(arr: Array<BigInteger>, end: Int) {
    for (i in 2..end) {
        arr[i] = arr[i - 2].plus(arr[i - 1])
    }
}