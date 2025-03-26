import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val node = br.readLine().toInt()
    val edge = br.readLine().toInt()

    val map = Array(node + 1) { mutableListOf<Pair<Int, Long>>() }
    repeat(edge) {
        val (s, f, cost) = br.readLine().split(" ").map { it.toInt() }
        map[s].add(Pair(f, cost.toLong()))
    }
    val (start, end) = br.readLine().split(" ").map { it.toInt() }




    println(findWay(start, map)[end])


}

private fun findWay(
    start: Int,
    map: Array<MutableList<Pair<Int, Long>>>
): Array<Long> {
    val result = Array(map.size) { Long.MAX_VALUE }
    val pq = PriorityQueue(compareBy<Pair<Int, Long>> { it.second })
    pq.add(Pair(start, 0))
    result[start] = 0

    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()

        if (curCost > result[cur]) continue

        for ((next, cost) in map[cur]) {
            if (result[next] > cost + curCost) {
                pq.add(Pair(next, cost + curCost))
                result[next] = cost + curCost
            }
        }
    }
    return result
}