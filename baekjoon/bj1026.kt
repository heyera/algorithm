import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()

    var arr1 = br.readLine().split(" ").map { it.toInt() }
    var arr2 = br.readLine().split(" ").map { it.toInt() }
    arr1 = arr1.sorted()
    arr2 = arr2.sorted().reversed()
    var result: Int = 0

    repeat(arr1.size) {
        result += arr1[it] * arr2[it]
    }
    println(result)
}