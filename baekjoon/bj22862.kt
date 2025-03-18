import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    var left = 0
    var right = 0
    var oddCount = 0
    var max = 0

    while (right < s) {
        if (list[right] % 2 == 1) {
            oddCount += 1
        }
        while (oddCount > k) {
            if (list[left] % 2 == 1) {
                oddCount--
            }
            left += 1
        }

        max = maxOf(max, right - left + 1 - oddCount)
        right += 1
    }
    println(max)
}
