import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }

    var min = Int.MAX_VALUE
    var left = 0
    var count = 0

    for (right in 0 until n) {
        if (arr[right] == 1)
            count += 1

        while (count >= k) {
            min = minOf(min, right - left + 1)

            if (arr[left] == 1)
                count -= 1

            left += 1
        }
    }

    println(if (min == Int.MAX_VALUE) -1 else min)
}