import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private var l = 0
private var r = 0
private var x = 0
private lateinit var scores: IntArray

private var count = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (nn, ll, rr, xx) = br.readLine().split(" ").map { it.toInt() }
    n = nn
    l = ll
    r = rr
    x = xx

    scores = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    bt(0, Int.MAX_VALUE, Int.MIN_VALUE, 0, mutableListOf())

    println(count)

}

private fun bt(index: Int, min: Int, max: Int, sum: Int, nums: MutableList<Int>) {
    if (nums.size >= 2 && sum >= l && sum <= r && max - min >= x) {
        count += 1
    }

    for (i in index until n) {
        nums.add(scores[i])
        bt(i + 1, minOf(min, scores[i]), maxOf(max, scores[i]), sum + scores[i], nums)
        nums.removeLast()
    }

}