import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Position(val col: Int, val row: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (col, row) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(col) { Array(row) { 0 } }
    val visited = Array(col) { Array(row) { false } }


    repeat(col) { c ->
        val temp = br.readLine().split(" ").map { it.toInt() }
        repeat(row) { r ->
            map[c][r] = temp[r]
        }
    }

    var peakCount = 0


    val moveCol = arrayOf(-1, 1, 0, 0, -1, -1, 1, 1)
    val moveRow = arrayOf(0, 0, -1, 1, -1, 1, -1, 1)

    val queue: Queue<Position> = LinkedList()

    repeat(col) { c ->
        repeat(row) { r ->
            if (!visited[c][r] && map[c][r] > 0) {
                queue.add(Position(c, r))
                visited[c][r] = true

                var isPeak = true
                while (queue.isNotEmpty()) {
                    val current = queue.poll()

                    for (d in 0 until 8) {
                        val newCol = current.col + moveCol[d]
                        val newRow = current.row + moveRow[d]

                        if (isValid(newCol, newRow, col, row)) {
                            if (map[newCol][newRow] > map[current.col][current.row]) {
                                isPeak = false
                            }

                            if (!visited[newCol][newRow] && map[newCol][newRow] == map[current.col][current.row]) {
                                queue.add(Position(newCol, newRow))
                                visited[newCol][newRow] = true
                            }
                        }
                    }
                }

                if (isPeak) peakCount++
            }
        }
    }

    println(peakCount)
}

private fun isValid(col: Int, row: Int, maxCol: Int, maxRow: Int): Boolean {
    return col in 0 until maxCol && row in 0 until maxRow
}
