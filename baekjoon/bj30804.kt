import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = 0
    val fruit = mutableMapOf<Int, Int>()
    var maxLength = 0

    while (right < n) {
        fruit[s[right]] = fruit.getOrDefault(s[right], 0) + 1

        while (fruit.size > 2) {
            fruit[s[left]] = fruit[s[left]]!! - 1
            if (fruit[s[left]] == 0) {
                fruit.remove(s[left])
            }
            left += 1
        }
        maxLength = maxOf(maxLength, right - left + 1)
        right++

    }

    println(maxLength)

}