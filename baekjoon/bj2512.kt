import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()


    var min = 1
    var max = list.last()
    var pivot = 0
    var sum = 0

    while (min <= max) {
        sum = 0
        pivot = (min + max) / 2
        list.forEach { it ->
            sum += if (it > pivot) {
                pivot
            } else {
                it
            }
        }
        if (sum <= m) {
            min = pivot + 1
        } else {
            max = pivot - 1
        }
    }
    println(max)

}