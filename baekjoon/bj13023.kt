import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val relation = Array(n) { mutableListOf<Int>() }
    val visited = Array(n) { false }

    repeat(m) {
        val (r1, r2) = br.readLine().split(" ").map { it.toInt() }
        relation[r1].add(r2)
        relation[r2].add(r1)
    }

    repeat(n) {
        dfs(it, 1, relation, visited)
    }

    println(0)

}

fun dfs(now: Int, depth: Int, relation: Array<MutableList<Int>>, visited: Array<Boolean>) {
    if (depth == 5) {
        println(1)
        exitProcess(0)
    }
    visited[now] = true

    for (next in relation[now]) {
        if (!visited[next]) {
            dfs(next, depth + 1, relation, visited)
        }
    }

    visited[now] = false
}

