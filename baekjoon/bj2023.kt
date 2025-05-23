import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val primeList = intArrayOf(2, 3, 5, 7)

    for (i in primeList) {
        bt(i,1,n)
    }

}

private fun bt(num: Int, depth: Int, n: Int) {
    if (!isPrime(num)) return

    if (depth == n) {
        println(num)
        return
    }

    for (i in 0..9) {
        bt(num * 10 + i, depth + 1, n)
    }
}


private fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}