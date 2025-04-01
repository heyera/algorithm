import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, range, edge) = br.readLine().split(" ").map { it.toInt() }
    val item = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }


    repeat(edge) {
        val (a, b, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, cost))
        graph[b].add(Pair(a, cost))
    }

    var count = 0


    for (start in 1..node) {
        val dist = IntArray(node + 1) { Int.MAX_VALUE }

        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
        pq.add(Pair(start, 0))
        dist[start] = 0

        while (pq.isNotEmpty()) {
            val (cur, curCost) = pq.poll()


            for ((next, cost) in graph[cur]) {
                if (dist[next] > cost + curCost) {
                    pq.add(Pair(next, cost + curCost))
                    dist[next] = cost + curCost
                }
            }
        }

        var totalItem = 0
        for (i in 1..node) {
            if (range >= dist[i])
                totalItem += item[i - 1]
        }

        count = maxOf(count, totalItem)
    }
    println(count)
}