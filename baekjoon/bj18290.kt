import java.io.BufferedReader
import java.io.InputStreamReader


private var n = 0
private var m = 0
private var k = 0


private var result = Int.MIN_VALUE
private lateinit var visited: Array<BooleanArray>
private lateinit var map: Array<IntArray>


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inList = br.readLine().split(" ").map { it.toInt() }
    n = inList[0]
    m = inList[1]
    k = inList[2]

    map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(m) }

    bt(0,0,0)
    println(result)

}


private val moveX = intArrayOf(-1, 0, 1, 0)
private val moveY = intArrayOf(0, -1, 0, 1)


private fun bt(count: Int, start: Int, sum: Int) {
    if (count == k) {
        result = maxOf(result, sum)
        return
    }

    for (i in start until n * m) {
        val x = i / m
        val y = i % m

        if (visited[x][y]) continue

        var isAdjacent = false
        for (d in 0 until 4) {
            val nx = x + moveX[d]
            val ny = y + moveY[d]
            if (nx in 0 until n && ny in 0 until m) {
                if (visited[nx][ny]) {
                    isAdjacent = true
                    break
                }
            }
        }

        if (isAdjacent) continue

        visited[x][y] = true
        bt(count + 1, i + 1, sum + map[x][y])
        visited[x][y] = false
    }
}



