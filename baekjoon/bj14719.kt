import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val blocks = br.readLine().split(" ").map { it.toInt() }


    var count = 0

    for (i in 1 until w - 1) {
        val leftMax = blocks.subList(0, i).maxOrNull() ?: 0
        val rightMax = blocks.subList(i + 1, w).maxOrNull() ?: 0

        val hight = minOf(leftMax, rightMax)
        if (hight > blocks[i]) {
            count += hight - blocks[i]
        }
    }

    println(count)
}