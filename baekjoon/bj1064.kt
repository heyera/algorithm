import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pointList = br.readLine().split(" ").map { it.toDouble() }

    val x1 = pointList[0]
    val y1 = pointList[1]
    val x2 = pointList[2]
    val y2 = pointList[3]
    val x3 = pointList[4]
    val y3 = pointList[5]

    if ((x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)) {
        println("-1.0")
        return
    }

        val len1 = length(x1, y1, x2, y2) + length(x1, y1, x3, y3)
        val len2 = length(x2, y2, x1, y1) + length(x2, y2, x3, y3)
        val len3 = length(x3, y3, x1, y1) + length(x3, y3, x2, y2)

        val min = minOf(len1, len2, len3) * 2
        val max = maxOf(len1, len2, len3) * 2

        println("%.10f".format(max - min))
}



private fun length(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
}
