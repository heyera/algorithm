import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()) {
        val list = br.readLine().split(" ").map { it.toInt() }
        val length =
            ((list[3] - list[0]) * (list[3] - list[0])) + ((list[4] - list[1]) * (list[4] - list[1]))

        val result = when {
            length == 0 && list[2] == list[5] && list[2] != 0 -> -1
            length > (list[5] + list[2]) * (list[5] + list[2]) || length < (list[5] - list[2]) * (list[5] - list[2]) || (length == 0 && list[2] != list[5]) -> 0
            length == (list[5] + list[2]) * (list[5] + list[2]) || length == (list[5] - list[2]) * (list[5] - list[2]) -> 1
            else -> 2
        }
        println(result)
    }
}