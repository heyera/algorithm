import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val G = br.readLine().toInt()
    val sb = StringBuilder()

    var before = 1
    var after = 2
    var found = false

    while (after<=100000) {
        val diff = after * after - before * before

        if (diff == G) {
            sb.append("$after\n")
            found = true
        }

        if (diff < G) {
            after++
        } else {
            before++
        }
    }

    if (!found) {
        println(-1)
    } else {
        println(sb)
    }
}