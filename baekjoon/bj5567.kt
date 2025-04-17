import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val friend = Array<MutableList<Int>>(n + 1) { mutableListOf() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        friend[a].add(b)
        friend[b].add(a)
    }

    val visited = BooleanArray(n + 1) { false }

    val que = LinkedList<Pair<Int, Int>>()
    visited[1] = true
    que.add(Pair(1, 0))
    var count = 0
    while (que.isNotEmpty()) {
        val (now, reach) = que.poll()

        for (i in friend[now]) {
            if (!visited[i] && reach < 2) {
                que.add(Pair(i, reach + 1))
                visited[i] = true
                count += 1
            }
        }
    }

    println(count)
}