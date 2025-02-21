import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Pair<String, Int>>()

    repeat(n) {
        list.add(br.readLine().split(" ").let { Pair(it[0], it[1].toInt()) })
    }
    var result = StringBuilder("")

    repeat(m) {
        val num = br.readLine().toInt()

        var start = 0
        var last = n - 1

        while (start <= last) {
            val mid = (start + last) / 2

            if (list[mid].second >= num) {
                last = mid - 1
            } else {
                start = mid + 1
            }
        }
        result.append(list[start].first).append("\n")
    }

    println(result)
}