import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")
    var n = st.nextToken().toInt()
    var k = st.nextToken().toInt()
    val list:Queue<Int> = LinkedList()
    for (i in 1..n) {
        list.add(i)
    }
    val sb = StringBuilder()
    sb.append("<")
    while (list.size > 1) {
        for(i in 0 until k-1){
            list.offer(list.poll())
        }
        sb.append(list.remove()).append(", ")
    }
    sb.append(list.remove()).append(">")
    print(sb)


}