import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str1 = br.readLine()
    val str2 = br.readLine()
    val dp = Array(str1.length + 1) { Array(str2.length + 1) { 0 } }

    for (i in str1.indices) {
        for (j in str2.indices) {
            if (str1[i] == str2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1
            } else {
                //coerceAtLeast 호출된객체와 비교 후 큰거 반환
                dp[i+1][j+1] = dp[i+1][j].coerceAtLeast(dp[i][j +1])
            }
        }
    }

    println(dp[dp.size-1][dp[1].size-1])

}