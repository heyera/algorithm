//BFS_Kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    for (i in 1..t) {
        val st = StringTokenizer(br.readLine(), " ")
        val start = st.nextToken().toLong()
        val end = st.nextToken().toLong()
        sb.append(bfs(start, end)).append("\n")
    }
    print(sb)
}

private fun bfs(start: Long, end: Long): String {
    val visited = Array(100000) { item -> false }
    val que: Queue<LongArray> = LinkedList()
    que.add(longArrayOf(start, 0))
    visited[start.toInt()] = true

    while (!que.isEmpty()) {
        val temp = que.poll()
        val num = temp[0]
        //DSLR을 숫자로 입력들을 기록하고, int는 범위가 짧아 long으로 선언함
        //ex)D연산을 하면 1을 넣은뒤 다음에 S연산하면 '12' 이런식으로 기록
        val dslr = temp[1]

        if (num == end) {
            return change(dslr)
        }

        //D연산
        val dNum = (num * 2) % 10000
        if (!visited[dNum.toInt()]) {
            que.add(longArrayOf(dNum, dslr * 10 + 1))
            visited[dNum.toInt()] = true
        }
        //S연산
        val sNum = if (num.toInt() == 0) 9999 else num - 1
        if (!visited[sNum.toInt()]) {
            que.add(longArrayOf(sNum, dslr * 10 + 2))
            visited[sNum.toInt()] = true
        }
        //L연산
        val lNum = ((num % 1000) * 10 + (num / 1000))
        if (!visited[lNum.toInt()]) {
            que.add(longArrayOf(lNum, dslr * 10 + 3))
            visited[lNum.toInt()] = true
        }
        //R연산
        val rNum = (((num % 10) * 1000) + (num / 10))
        if (!visited[rNum.toInt()]) {
            que.add(longArrayOf(rNum, dslr * 10 + 4))
            visited[rNum.toInt()] = true
        }
    }
    return "-1"
}
//기록한 숫자들을 DSLR인 문자열로 바꿔주는 함수
private fun change(num: Long): String {
    val str = num.toString()
    val sb = StringBuilder()
    for (i in str) when (i) {
        '1' -> sb.append("D")
        '2' -> sb.append("S")
        '3' -> sb.append("L")
        '4' -> sb.append("R")
    }
    return sb.toString()
}