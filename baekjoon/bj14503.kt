import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    val loc = br.readLine().split(" ").map { it.toInt() }

    val map = Array(row) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val robot = RobotCleaner(loc[0], loc[1], loc[2])
    var count = 0


    var flag = true

    val moveRow = arrayOf(-1, 0, 1, 0)
    val moveCol = arrayOf(0, 1, 0, -1)


    while (flag) {
        if (map[robot.row][robot.col] == 0) {
            map[robot.row][robot.col] = 2
            count += 1
        }

        var moved = false

        for (i in 0 until 4) {
            turn(robot)
            val nextRow = robot.row + moveRow[robot.way]
            val nextCol = robot.col + moveCol[robot.way]

            if (checkRange(nextRow, nextCol, map) && map[nextRow][nextCol] == 0) {
                robot.row = nextRow
                robot.col = nextCol
                moved = true
                break
            }
        }


        if (!moved) {
            val backWay = (robot.way + 2) % 4
            val backRow = robot.row + moveRow[backWay]
            val backCol = robot.col + moveCol[backWay]

            if (checkRange(backRow, backCol, map) && map[backRow][backCol] != 1) {
                robot.row = backRow
                robot.col = backCol
            } else {
                flag = false
            }
        }
    }

    println(count)
}

data class RobotCleaner(var row: Int, var col: Int, var way: Int)


fun turn(robotCleaner: RobotCleaner) {
    robotCleaner.way = (robotCleaner.way + 3) % 4
}

fun checkRange(row: Int, col: Int, map: Array<IntArray>): Boolean {
    return row in map.indices && col in map[0].indices
}



