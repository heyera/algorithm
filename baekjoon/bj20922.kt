import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    val count = IntArray(200001) { 0 }.toMutableList()

    var result = 0
    var left = 0
    var right = 0

    while (right < n) {
        count[list[right]] += 1

        while (count[list[right]] > k) {
            count[list[left]]--
            left += 1
        }

        result = maxOf(result, right - left + 1)
        right += 1
    }
    println(result)

}