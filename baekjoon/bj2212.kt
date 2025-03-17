import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val sensor = br.readLine().split(" ").map { it.toInt() }.sorted()

    val distance = mutableListOf<Int>()
    repeat(n - 1) {
        distance.add(sensor[it + 1] - sensor[it])
    }
    distance.sortDescending()
    val result = distance.drop(k - 1).sum()
    println(result)

}