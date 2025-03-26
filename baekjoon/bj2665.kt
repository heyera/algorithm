import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = Array(n) { br.readLine().map { it - '0' }.toIntArray() }

    val result = Array(n) { IntArray(n) { -1 } }
    val moveRow = listOf(0, 1, 0, -1)
    val moveCol = listOf(1, 0, -1, 0)

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(0, 0))
    result[0][0] = 0

    while (deque.isNotEmpty()) {
        val (row, col) = deque.removeFirst()

        for (i in 0 until 4) {
            val nextRow = row + moveRow[i]
            val nextCol = col + moveCol[i]

            if (nextRow !in 0 until n || nextCol !in 0 until n) continue

            if (result[nextRow][nextCol] == -1) {
                if (map[nextRow][nextCol] == 1) {
                    deque.addFirst(Pair(nextRow, nextCol))
                    result[nextRow][nextCol] = result[row][col]
                } else {
                    deque.addLast(Pair(nextRow, nextCol))
                    result[nextRow][nextCol] = result[row][col] + 1
                }
            }
        }
    }

    println(result[n - 1][n - 1])
}