import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(edge) {
        val (s, f, c) = br.readLine().split(" ").map { it.toInt() }
        graph[s].add(Pair(f, c))
        graph[f].add(Pair(s, c))
    }

    println(findWay(graph)[node])

}

private fun findWay(graph: Array<MutableList<Pair<Int, Int>>>): Array<Int> {
    val result = Array(graph.size) { Int.MAX_VALUE }
    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    pq.add(Pair(1, 0))
    result[1] = 0

    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()

        if (result[cur] < curCost) continue

        for ((next, cost) in graph[cur]) {
            if (result[next] > curCost + cost) {
                val nextCost = curCost + cost
                pq.add(Pair(next, nextCost))
                result[next] = nextCost
            }
        }
    }

    return result
}