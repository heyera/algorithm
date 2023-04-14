//String

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    val st = StringTokenizer(readLine(), "*")
    val front = st.nextToken()
    val back = st.nextToken()

    val sb = StringBuilder()
    for (i in 1..tc) {
        val temp = readLine()
        if (front.length + back.length > temp.length) {
            sb.append("NE").append("\n")
            continue
        }
        val testFront = temp.substring(0, front.length)
        val testBack=temp.substring(temp.length-back.length,temp.length)
        if(front==testFront&&back==testBack) {
            sb.append("DA").append("\n")
            continue
        }
        sb.append("NE").append("\n")
    }
    println(sb)
}