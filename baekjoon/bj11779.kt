import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val node = br.readLine().toInt()
    val edge = br.readLine().toInt()

    val graph = Array(node + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(edge) {
        val (s, f, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[s].add(Pair(f, cost))
    }
    val (start, end) = br.readLine().split(" ").map { it.toInt() }

    val parent = Array(node + 1) { 0 }
    val result = Array(node + 1) { Int.MAX_VALUE }

    val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    pq.add(Pair(start, 0))
    result[start] = 0

    while (pq.isNotEmpty()) {
        val (cur, curCost) = pq.poll()
        if (result[cur] < curCost) continue
        for ((next, cost) in graph[cur]) {
            if (result[next] > curCost + cost) {
                pq.add(Pair(next, curCost + cost))
                result[next] = curCost + cost
                parent[next] = cur
            }
        }
    }
    println(result[end])
    var now = end
    val parentStack = Stack<Int>()

    while (true) {
        if (now == parent[start]) break
        parentStack.add(now)
        now = parent[now]
    }
    println(parentStack.size)
    while (parentStack.isNotEmpty()) {
        print("${parentStack.pop()} ")
    }

}