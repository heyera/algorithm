//BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private lateinit var map: Array<ArrayList<Int>>

fun main() =with(System.`in`.bufferedReader()){
    var st = StringTokenizer(readLine(), " ")
    val node = st.nextToken().toInt()
    val edge = st.nextToken().toInt()
    val reach = st.nextToken().toInt()
    val start = st.nextToken().toInt()

    map = Array(node + 1) { ArrayList<Int>() }
    for (i in 1..edge) {
        st = StringTokenizer(readLine(), " ")
        /*val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()*/
        map[st.nextToken().toInt()].add(st.nextToken().toInt())
    }
    bfs(start,reach)


}

private fun bfs(start: Int, reach: Int) {
    var arr = IntArray(map.size){-1}

    val que: Queue<Int> = LinkedList()
    que.add(start)
    arr[start] = 0

    while (!que.isEmpty()) {
        val now = que.poll()
        for (i in map[now]) {
            if (arr[i]==-1) {
                arr[i] = arr[now]+1
                que.add(i)
            }
        }
    }
    var result = false
    for (i in 1 until map.size) {
        if (arr[i] == reach) {
            result = true
            println(i)
        }

    }

    if(!result)
        println(-1)

}