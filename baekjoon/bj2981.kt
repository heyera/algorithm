import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numbers = List(n) { br.readLine().toInt() }.sorted()

    var g = numbers[1] - numbers[0]
    for (i in 2 until n) {
        g = gcd(g, numbers[i] - numbers[i - 1])
    }

    val result = mutableListOf<Int>()
    for (i in 2..sqrt(g.toDouble()).toInt()) {
        if (g % i == 0) {
            result.add(i)
            if (i != g / i) result.add(g / i)
        }
    }

    result.add(g)
    result.sort()

    println(result.joinToString(" "))
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}