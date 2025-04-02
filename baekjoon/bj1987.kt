import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var map: Array<CharArray>
private var maxCount = 0

private val moveRow = arrayOf(0, 1, 0, -1)
private val moveCol = arrayOf(1, 0, -1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    map = Array(row) { br.readLine().toCharArray() }
    val visited = BooleanArray(26)
    visited[map[0][0] - 'A'] = true

    backTracking(0, 0, 1, visited)

    println(maxCount)

}

private fun backTracking(row: Int, col: Int, count: Int, visited: BooleanArray) {
    maxCount = maxOf(maxCount, count)

    for (i in 0 until 4) {
        val newRow = row + moveRow[i]
        val newCol = col + moveCol[i]

        if (inRangeCheck(newRow, newCol)) {
            val char = map[newRow][newCol] - 'A'
            if (!visited[char]) {
                visited[char] = true
                backTracking(newRow, newCol, count + 1, visited)
                visited[char] = false
            }
        }
    }

}

private fun inRangeCheck(row: Int, col: Int): Boolean {
    return row in 0 until map.size && col in 0 until map[0].size
}
