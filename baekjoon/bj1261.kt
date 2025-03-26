import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }

    repeat(n) { i ->
        map[i] = br.readLine().map { it - '0' }.toIntArray()
    }

    val result = Array(n) { IntArray(m) { -1 } }
    val moveRow = listOf(0, 1, 0, -1)
    val moveCol = listOf(1, 0, -1, 0)

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(0, 0))
    result[0][0] = 0

    while (deque.isNotEmpty()) {
        val (row, col) = deque.removeFirst()
        for (dir in 0 until 4) {
            val nextCol = col + moveCol[dir]
            val nextRow = row + moveRow[dir]

            if (nextRow !in 0 until n || nextCol !in 0 until m) continue

            if (result[nextRow][nextCol] == -1) {
                if (map[nextRow][nextCol] == 0) {
                    result[nextRow][nextCol] = result[row][col]
                    deque.addFirst(Pair(nextRow, nextCol))
                } else {
                    result[nextRow][nextCol] = result[row][col] + 1
                    deque.addLast(Pair(nextRow, nextCol))
                }
            }
        }
    }

    println(result[n - 1][m - 1])


}
