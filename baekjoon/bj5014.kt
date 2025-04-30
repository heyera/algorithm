import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = br.readLine().split(" ").map { it.toInt() }
    val hight = arr[0]
    val now = arr[1]
    val target = arr[2]
    val up = arr[3]
    val down = arr[4]

    val visited = IntArray(hight + 1) { -1 }
    val que = LinkedList<Int>()
    que.add(now)
    visited[now] = 0

    while (que.isNotEmpty()) {
        val poll = que.poll()
        if (poll == target)
            break
        if (poll + up <= hight && visited[poll + up] == -1) {
            que.add(poll + up)
            visited[poll + up] = visited[poll] + 1
        }
        if (poll - down > 0 && visited[poll - down] == -1) {
            que.add(poll - down)
            visited[poll - down] = visited[poll] + 1
        }
    }

    println(if (visited[target] != -1) visited[target] else "use the stairs")

}