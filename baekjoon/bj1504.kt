import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(edge) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    val (n1, n2) = br.readLine().split(" ").map { it.toInt() }

    val d1 = findWay(1, graph)
    val dn1 = findWay(n1, graph)
    val dn2 = findWay(n2, graph)

    val path1 = d1[n1] + dn1[n2] + dn2[node]
    val path2 = d1[n2] + dn2[n1] + dn1[node]
    val result = minOf(path1, path2)

    if (d1[n1] == Int.MAX_VALUE || dn1[n2] == Int.MAX_VALUE || dn2[node] == Int.MAX_VALUE ||
        d1[n2] == Int.MAX_VALUE || dn2[n1] == Int.MAX_VALUE || dn1[node] == Int.MAX_VALUE
    ) {
        println(-1)
    } else {
        println(result)
    }


}

private fun findWay(start: Int, graph: Array<MutableList<Pair<Int, Int>>>): Array<Int> {
    val result = Array(graph.size) { Int.MAX_VALUE }
    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    pq.add(Pair(start, 0))
    result[start] = 0

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
