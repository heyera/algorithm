import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val shirt = br.readLine().split(" ").map { it.toInt() }.sorted()

    val distance = mutableListOf<Int>()
    repeat(n - 1) {
        distance.add(shirt[it + 1] - shirt[it])
    }
    distance.sortDescending()
    val result = distance.drop(k - 1).sum()
    println(result)

}