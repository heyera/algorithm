import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Point(val row: Int, val col: Int, var count: Int = 0)

val moveRow = listOf<Int>(1, 2, 2, 1, -1, -2, -2, -1)
val moveCol = listOf<Int>(2, 1, -1, -2, -2, -1, 1, 2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()


    repeat(testCase) {
        val size = br.readLine().toInt()
        val map: MutableList<MutableList<Boolean>> = MutableList(size) { MutableList(size) { false } }
        var st = StringTokenizer(br.readLine(), " ")
        val startPoint = Point(st.nextToken().toInt(), st.nextToken().toInt())
        st = StringTokenizer(br.readLine(), " ")
        val endPoint = Point(st.nextToken().toInt(), st.nextToken().toInt())

        bfs(startPoint, endPoint, map)

    }
}

fun bfs(startPoint: Point, endPoint: Point, map: MutableList<MutableList<Boolean>>) {
    val que: Queue<Point> = LinkedList()
    que.add(startPoint)
    map[startPoint.col][startPoint.row] = true

    while (!que.isEmpty()) {
        val now = que.poll()
        if (now.row == endPoint.row && now.col == endPoint.col) {
            println(now.count)
            return
        }
        for (i in 0..7) {
            val newRow = now.row + moveRow[i]
            val newCol = now.col + moveCol[i]
            if (checking(newRow, newCol, map)) {
                que.add(Point(newRow, newCol, now.count + 1))
                map[newCol][newRow] = true
            }
        }
    }
}

fun checking(row: Int, col: Int, map: MutableList<MutableList<Boolean>>): Boolean {
    return row in 0 until map.size && col in 0 until map.size && !map[col][row]
}