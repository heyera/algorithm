import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private lateinit var visited: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    visited = BooleanArray(n + 1)

    bt(mutableListOf())

}

private fun bt(numbers: MutableList<Int>) {
    if (numbers.size == n ) {
        println(numbers.joinToString(" "))
        return
    }
    for (i in 1..n) {
        if (visited[i]) continue

        visited[i] = true
        numbers.add(i)
        bt(numbers)
        numbers.removeLast()
        visited[i] = false
    }
}