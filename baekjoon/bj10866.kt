import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque


fun main(){
    val br=BufferedReader(InputStreamReader(System.`in`))
    var n=br.readLine().toInt()
    val sb=StringBuilder()
    val deqe= ArrayDeque<Int>()
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        val str = st.nextToken()
        when (str) {
            "push_front" -> {
                deqe.addFirst(st.nextToken().toInt())
            }
            "push_back" -> {
                deqe.addLast(st.nextToken().toInt())
            }
            "pop_front" -> {
                if (deqe.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append(deqe.first(),"\n")
                    deqe.removeFirst()
                }
            }
            "pop_back" -> {
                if (deqe.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append(deqe.last(), "\n")
                    deqe.removeLast()
                }
            }
            "size" -> {
                if (deqe.isEmpty()) {
                    sb.append("0\n")
                } else {
                    sb.append(deqe.size,"\n")
                }
            }
            "empty" -> {
                if (deqe.isEmpty()) {
                    sb.append("1\n")
                } else {
                    sb.append("0\n")
                }
            }
            "front" -> {
                if (deqe.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append(deqe.first(), "\n")
                }
            }
            "back" -> {
                if (deqe.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append(deqe.last(), "\n")
                }
            }
            else -> {}
        }
    }
    print(sb)
}