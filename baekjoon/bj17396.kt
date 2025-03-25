import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node) { mutableListOf<Pair<Int, Long>>() }
    val visibility = br.readLine().split(" ").map { it.toInt() }

    repeat(edge) {
        val (s, f, c) = br.readLine().split(" ").map { it.toInt() }
        if ((visibility[s] == 0 || s == node - 1) && (visibility[f] == 0 || f == node - 1)) {
            graph[s].add(Pair(f, c.toLong()))
            graph[f].add(Pair(s, c.toLong()))
        }
    }


    val result = findWay(graph, visibility)
    println(if (result[node - 1] == Long.MAX_VALUE) -1 else result[node - 1])


}

private fun findWay(graph: Array<MutableList<Pair<Int, Long>>>, visibility: List<Int>): Array<Long> {
    val result = Array(graph.size) { Long.MAX_VALUE }
    val pq = PriorityQueue(compareBy<Pair<Int, Long>> { it.second })
    pq.add(Pair(0, 0))
    result[0] = 0

    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()

        if (result[cur] < curCost) continue

        for ((next, cost) in graph[cur]) {
            if (next != graph.lastIndex && visibility[next] == 1) continue
            if (result[next] > curCost + cost) {
                val nextCost = curCost + cost
                pq.add(Pair(next, nextCost))
                result[next] = nextCost
            }
        }
    }

    return result
}