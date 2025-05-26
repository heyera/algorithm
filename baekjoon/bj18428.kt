import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var map: Array<Array<String>>
private var found = false
private var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    map = Array(n) { br.readLine().split(" ").toTypedArray() }

    val teachers = mutableListOf<Pair<Int, Int>>()
    val empties = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            when (map[i][j]) {
                "T" -> teachers.add(Pair(i, j))
                "X" -> empties.add(Pair(i, j))
            }
        }
    }


    bt(empties, 0, mutableListOf(), teachers)

    println(if (found) "YES" else "NO")
}

private val moveX = arrayOf(-1, 1, 0, 0)
private val moveY = arrayOf(0, 0, -1, 1)


private fun bt(
    empties: List<Pair<Int, Int>>,
    start: Int,
    selected: MutableList<Pair<Int, Int>>,
    teachers: List<Pair<Int, Int>>
) {
    if (found) return

    if (selected.size == 3) {
        for ((x, y) in selected) {
            map[x][y] = "O"
        }

        if (isSafe(teachers)) {
            found = true
        }


        for ((x, y) in selected) map[x][y] = "X"
        return
    }

    for (i in start until empties.size) {
        selected.add(empties[i])
        bt(empties, i + 1, selected, teachers)
        selected.removeLast()
    }
}

private fun isSafe(teachers: List<Pair<Int, Int>>): Boolean {
    for ((x, y) in teachers) {
        for (dir in 0 until 4) {
            var nextX = x
            var nextY = y
            while (true) {
                nextX += moveX[dir]
                nextY += moveY[dir]
                if (nextX !in 0 until n || nextY !in 0 until n) break
                if (map[nextX][nextY] == "O") break
                if (map[nextX][nextY] == "S") return false
            }
        }
    }
    return true
}
