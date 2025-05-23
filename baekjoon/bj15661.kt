import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.system.exitProcess

private lateinit var map: Array<IntArray>
private lateinit var visited: BooleanArray
private var n = 0
private var result = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = BooleanArray(n)

    bt(0, 0)
    println(result)
}

private fun bt(depth: Int, start: Int) {
    if (depth > 1) {
        teamScore()
    }
    if (depth == n) {
        return
    }

    for (i in start until n) {
        if (visited[i]) continue

        visited[i] = true
        bt(depth + 1, i + 1)
        visited[i] = false
    }
}

private fun teamScore() {
    var teamStart = 0
    var teamLink = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visited[i] && visited[j]) {
                teamStart += map[i][j]
            }
            if (!visited[i] && !visited[j]) {
                teamLink += map[i][j]
            }
        }
    }

    result = minOf(result, abs(teamStart - teamLink))
    if (result == 0) {
        println("0")
        exitProcess(0)
    }


}