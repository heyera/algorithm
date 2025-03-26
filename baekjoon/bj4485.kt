import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Deque
import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 0

    while (true) {
        val n = br.readLine().toInt()
        count += 1

        if (n == 0) break

        val map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

        println("Problem $count: ${findWay(n, map)[n - 1][n - 1]}")


    }
}

data class Zelda(val row: Int, val col: Int, val cost: Int){
}


private fun findWay(n: Int, map: Array<IntArray>): Array<IntArray> {
    val result = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    val que = PriorityQueue(compareBy<Zelda> { it.cost })
    que.add(Zelda(0, 0, map[0][0]))
    result[0][0] = map[0][0]

    val moveRow = listOf(0, 1, 0, -1)
    val moveCol = listOf(1, 0, -1, 0)

    while (que.isNotEmpty()) {
        val (row, col, cost) = que.poll()
        if (result[row][col] < cost) continue

        for (i in 0..3) {
            val nextRow = row + moveRow[i]
            val nextCol = col + moveCol[i]



            if (nextRow !in 0 until n || nextCol !in 0 until n) continue
            if (result[nextRow][nextCol] > cost + map[nextRow][nextCol]) {
                result[nextRow][nextCol] = cost + map[nextRow][nextCol]
                que.add(Zelda(nextRow, nextCol, cost + map[nextRow][nextCol]))
            }
        }


    }
    return result
}