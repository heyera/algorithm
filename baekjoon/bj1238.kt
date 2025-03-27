import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge, start) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }
    val reversGraph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(edge) {
        val (a, b, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, cost))
        reversGraph[b].add(Pair(a, cost))
    }

    val toHome = findWay(start, reversGraph)
    val toParty = findWay(start, graph)

    var max = 0
    for (i in 1..node) {
        max = maxOf(max, toHome[i] + toParty[i])
    }
    println(max)

}

private fun findWay(start: Int, graph: Array<MutableList<Pair<Int, Int>>>): Array<Int> {
    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    val result = Array(graph.size) { Int.MAX_VALUE }
    pq.add(Pair(start, 0))
    result[start] = 0

    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()

        for ((next, cost) in graph[cur]) {
            if (result[next] > cost + curCost) {
                pq.add(Pair(next, cost + curCost))
                result[next] = curCost + cost
            }
        }
    }

    var max = 0
    for (i in 1 until result.size) {
        max = maxOf(max, result[i])
    }
    return result
}