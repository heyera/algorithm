import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val word = br.readLine()

        if (word.length < m)
            continue

        map[word] = map.getOrDefault(word, 0) + 1
    }

    val sorted = map.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }
        .thenByDescending { it.key.length }
        .thenBy { it.key })

    val sb = StringBuilder()
    for ((word, _) in sorted) {
        sb.append("$word\n")
    }
    println(sb)
}