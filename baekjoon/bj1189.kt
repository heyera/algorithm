import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var map: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private var R = 0
private var C = 0
private var K = 0
private var result = 0


private val moveRow = intArrayOf(-1, 1, 0, 0)
private val moveCol = intArrayOf(0, 0, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    R = r
    C = c
    K = k

    map = Array(R) { br.readLine().toCharArray() }
    visited = Array(R) { BooleanArray(C) }

    visited[R - 1][0] = true
    dfs(R - 1, 0, 1)

    println(result)
}

fun dfs(row: Int, col: Int, depth: Int) {
    if (row == 0 && col == C - 1) {
        if (depth == K) result++
        return
    }

    for (dir in 0 until 4) {
        val nr = row + moveRow[dir]
        val nc = col + moveCol[dir]

        if (nr in 0 until R && nc in 0 until C &&
            !visited[nr][nc] && map[nr][nc] != 'T'
        ) {

            visited[nr][nc] = true
            dfs(nr, nc, depth + 1)
            visited[nr][nc] = false
        }
    }
}