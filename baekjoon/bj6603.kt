import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var numbers: List<Int>
var k = 0
val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        numbers = br.readLine().split(" ").map { it.toInt() }
        k = numbers[0]
        if (k == 0) break
        numbers= numbers.drop(1)
        backTracking(0,0,mutableListOf())
        println(sb)
        sb.clear()
    }
}

private fun backTracking(start: Int, depth: Int, pickList: List<Int>) {
    if (depth == 6) {
        for (i in pickList) {
            sb.append(i).append(" ")
        }
        sb.append("\n")
        return
    }
    for (i in start until k) {
        backTracking(i + 1, depth + 1, pickList + numbers[i])
    }
}