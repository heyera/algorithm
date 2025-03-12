import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (col, row, n) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(col) { Array(row) { true } }
    val result = mutableListOf<Int>()

    repeat(n) {
        val inputList = br.readLine().split(" ").map { it.toInt() }
        drawTriangle(inputList[0], inputList[1], inputList[2], inputList[3], map)
    }

    search(map, result)
    println(result.size)
    result.sort()
    result.forEach {
        print("$it ")
    }

}


private fun drawTriangle(x1: Int, y1: Int, x2: Int, y2: Int, map: Array<Array<Boolean>>) {
    for (y in y1 until y2) {
        for (x in x1 until x2) {
            map[y][x] = false
        }
    }
}

data class Point2583(val col: Int, val row: Int) {}

private fun search(map: Array<Array<Boolean>>, result: MutableList<Int>) {

    val queue: Queue<Point2583> = LinkedList()
    val moveCol = arrayOf(0, 1, 0, -1)
    val moveRow = arrayOf(1, 0, -1, 0)

    repeat(map.size) { c ->
        repeat(map[0].size) { r ->
            if (map[c][r]) {
                queue.add(Point2583(c, r))
                map[c][r] = false
                var areaSize = 0


                while (queue.isNotEmpty()) {
                    val poll = queue.poll()
                    areaSize += 1

                    for (d in 0 until 4) {
                        val newCol = poll.col + moveCol[d]
                        val newRow = poll.row + moveRow[d]

                        if (isValid(newCol, newRow, map.size, map[0].size) && map[newCol][newRow]) {
                            queue.add(Point2583(newCol, newRow))
                            map[newCol][newRow] = false
                        }
                    }
                }
                result.add(areaSize)
            }
        }
    }
}

private fun isValid(col: Int, row: Int, maxCol: Int, maxRow: Int): Boolean {
    return col in 0 until maxCol && row in 0 until maxRow
}
