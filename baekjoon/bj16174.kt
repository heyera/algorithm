import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()

    val map = Array(size) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val que = LinkedList<Pair<Int, Int>>()
    val visited = Array(size) { BooleanArray(size) { false } }
    que.add(Pair(0, 0))
    visited[0][0] = true
    var flag = false

    while (que.isNotEmpty()) {
        val (row, col) = que.poll()
        if (row == size - 1 && col == size - 1) {
            flag = true
            break
        }
        val reach = map[row][col]
        if (row + reach < size && !visited[row + reach][col]) {
            que.add(Pair(row + reach, col))
            visited[row + reach][col] = true
        }
        if (col + reach < size && !visited[row][col + reach]) {
            que.add(Pair(row, col + reach))
            visited[row][col + reach] = true
        }

    }

    println(if (flag) "HaruHaru" else "Hing")

}