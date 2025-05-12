import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }

    val map = Array<MutableList<Int>>(node + 1) { mutableListOf() }

    repeat(edge) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        map[a].add(b)
        map[b].add(a)
    }

    val totalDistance = IntArray(node + 1) { 0 }
    val visited = BooleanArray(node + 1) { false }

    val que = LinkedList<Int>()
    que.add(1)
    visited[1] = true
    totalDistance[1] = 0

    while (que.isNotEmpty()) {
        val poll = que.poll()
        val distance = totalDistance[poll]

        for (next in map[poll]) {
            if (!visited[next]) {
                que.add(next)
                visited[next] = true
                totalDistance[next] = distance + 1
            }
        }
    }

    var max = 0
    var maxList = mutableListOf<Int>()

    for (i in 1..node) {
        if (max < totalDistance[i]) {
            max = totalDistance[i]
            maxList.clear()
            maxList.add(i)
        } else if (max == totalDistance[i]) {
            maxList.add(i)
        }
    }

    println("${maxList[0]} $max ${maxList.size}")
}