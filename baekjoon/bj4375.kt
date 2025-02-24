import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine() ?: break
        println(findNum(n.toInt()))
    }
}


fun findNum(n: Int): Int {
    var num = 1
    var length = 1

    while (num % n != 0) {
        num = (num * 10 + 1) % n
        length++
    }

    return length
}