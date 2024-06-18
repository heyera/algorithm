import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val total = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val (T, P) = br.readLine().split(" ").map { it.toInt() }
    var needT = 0
    arr.forEach { it ->
        if (it != 0 && it % T != 0) {
            needT += 1
        }
        needT += it / T
    }
    println(needT)
    println("${total / P} ${total % P}")


}