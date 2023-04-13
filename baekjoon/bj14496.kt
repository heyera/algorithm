//BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


/*private var a:Int =0
private var b:Int =0*/
private lateinit var map: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine(), " ")
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    st = StringTokenizer(br.readLine(), " ")
    val node = st.nextToken().toInt()
    val edge = st.nextToken().toInt()

    map = Array(node + 1) { IntArray(node + 1) }
    for (i in 0 until edge) {
        st = StringTokenizer(br.readLine(), " ")
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        map[x][y] = 1
        map[y][x] = 1
    }
    println(bfs(a, b))

}

private fun bfs(start: Int, end: Int): Int {
    var visited = Array(map.size) { item -> false }
    val que: Queue<IntArray> = LinkedList()
    que.add(intArrayOf(start, 0))
    visited[start] = true

    while (!que.isEmpty()) {
        val temp = que.poll()
        val now = temp[0]
        val length = temp[1]

        if (now == end) {
            return length
        }

        for (i in 1 until map.size) {
            if (map[now][i] == 1 && !visited[i]) {
                que.add(intArrayOf(i, length + 1))
                visited[i]=true
            }
        }
    }
    return -1
}