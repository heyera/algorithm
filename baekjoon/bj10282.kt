import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()

    repeat(testCase) {
        val (node, edge, start) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }
        repeat(edge) {
            val (a, b, s) = br.readLine().split(" ").map { it.toInt() }
            graph[b].add(Pair(a, s))
        }

        hacking(start, graph)

    }

}

private fun hacking(start: Int, graph: Array<MutableList<Pair<Int, Int>>>) {
    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    val timeArr = Array(graph.size) { Int.MAX_VALUE }
    pq.add(Pair(start, 0))
    timeArr[start] = 0


    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()

        for ((next, cost) in graph[cur]) {
            if (timeArr[next] > curCost + cost) {
                pq.add(Pair(next, curCost + cost))
                timeArr[next] = curCost + cost
            }
        }
    }
    var count = 0
    var maxTime = 0
    timeArr.forEach { i ->
        if (i != Int.MAX_VALUE) {
            count += 1
            maxTime = maxOf(i, maxTime)
        }
    }

    println("$count $maxTime")

}