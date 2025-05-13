import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (col, row) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(col) { br.readLine().toCharArray() }

    var result = 0

    for (i in 0 until col) {
        for (j in 0 until row) {
            if ('L' == map[i][j]) {
                result = maxOf(search(i, j, col, row, map), result)

            }
        }
    }

    println(result)

}

private fun search(col: Int, row: Int, maxCol: Int, maxRow: Int, map: Array<CharArray>): Int {
    val visited = Array(maxCol) { IntArray(maxRow) { -1 } }
    val moveRow = arrayOf(1, 0, -1, 0)
    val moveCol = arrayOf(0, 1, 0, -1)
    var max = 0

    val que = LinkedList<Pair<Int, Int>>()
    que.add(Pair(col, row))
    visited[col][row] = 0

    while (que.isNotEmpty()) {
        val (nowCol, nowRow) = que.poll()
        max = maxOf(max, visited[nowCol][nowRow])

        for (i in 0..3) {
            val nextCol = nowCol + moveCol[i]
            val nextRow = nowRow + moveRow[i]

            if (checking(nextCol, nextRow, maxCol, maxRow) && visited[nextCol][nextRow] == -1 && map[nextCol][nextRow]=='L') {
                que.add(Pair(nextCol, nextRow))
                visited[nextCol][nextRow] = visited[nowCol][nowRow] + 1
            }
        }
    }

    return max
}

private fun checking(col: Int, row: Int, maxCol: Int, maxRow: Int): Boolean {
    return row >= 0 && col >= 0 && maxCol > col && maxRow > row
}

