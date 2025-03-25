import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }
    val start = br.readLine().toInt()

    val map = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(edge) {
        val (s, f, w) = br.readLine().split(" ").map { it.toInt() }
        map[s].add(Pair(f, w))
    }

    val result = Array(node + 1) { Int.MAX_VALUE }
    result[start] = 0

    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    pq.add(Pair(start, 0))

    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()

        if (curCost > result[cur]) continue

        for ((next, cost) in map[cur]) {
            if (result[next] > cost + curCost) {
                val newCost = cost + curCost
                result[next] = newCost
                pq.add(Pair(next, newCost))
            }
        }

    }

    for (i in 1..node) {
        if (result[i] == Int.MAX_VALUE) {
            println("INF")
        } else {
            println(result[i])
        }
    }
}