import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array<MutableList<Pair<Int, Int>>>(n + 1) { mutableListOf() }

    repeat(n - 1) {
        val (a, b, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, cost))
        graph[b].add(Pair(a, cost))
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        bfs(a, b, graph)
    }
}

private fun bfs(start: Int, end: Int, graph: Array<MutableList<Pair<Int, Int>>>) {
    val visited = BooleanArray(graph.size) { false }
    val que = LinkedList<Pair<Int, Int>>()

    que.add(Pair(start, 0))
    visited[start] = true

    while (que.isNotEmpty()) {
        val (now, cost) = que.poll()
        if (now == end) {
            println(cost)
            break
        }

        for (i in graph[now]) {
            if (!visited[i.first]) {
                que.add(Pair(i.first, i.second+cost))
                visited[i.first] = true
            }
        }
    }
}