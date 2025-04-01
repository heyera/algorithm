import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }
    val sb = StringBuilder()

    repeat(edge) {
        val (a, b, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, cost))
        graph[b].add(Pair(a, cost))
    }

    for (start in 1..node) {
        val dist = Array(node + 1) { Int.MAX_VALUE }
        val parent = Array(node + 1) { 0 }
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
        pq.add(Pair(start, 0))
        dist[start] = 0
        parent[start] = 0

        while (pq.isNotEmpty()) {
            val (cur, curCost) = pq.poll()

            for ((next, cost) in graph[cur]) {
                if (dist[next] > cost + curCost) {
                    pq.add(Pair(next, cost + curCost))
                    dist[next] = cost + curCost
                    parent[next] = if (cur == start) next else parent[cur]
                }
            }
        }

        for (i in 1..node) {
            sb.append(if (parent[i] == 0) "- " else "${parent[i]} ")
        }
        sb.append("\n")
    }

    println(sb.toString())

}