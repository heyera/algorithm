import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toDouble()
    val list = br.readLine().split(" ").map { it.toDouble() }.sorted()
    var result = list[(n - 1).toInt()]

    repeat((n - 1).toInt()) {
        result += list[it] / 2
    }
    println(formatNumber(result))

}

fun formatNumber(value: Double): String {
    return if (value % 1.0 == 0.0) {
        String.format("%.0f", value)
    } else {
        String.format("%.1f", value)
    }
}
