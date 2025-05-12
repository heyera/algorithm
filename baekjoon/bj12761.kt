import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, n, m) = br.readLine().split(" ").map { it.toInt() }

    val visited = IntArray(100001) { -1 }
    val que = LinkedList<Int>()
    que.add(n)
    visited[n] = 0
    while (que.isNotEmpty()) {
        val poll = que.poll()
        val nextList = listOf(
            poll + 1, poll - 1,
            poll + a, poll - a,
            poll + b, poll - b,
            poll * a, poll * b
        )

        for (next in nextList) {
            if (next in 0 until 100001&& visited[next] == -1) {
                visited[next] = visited[poll] + 1
                que.add(next)
            }
        }

        if(poll==m) break
    }

    println(visited[m])
}