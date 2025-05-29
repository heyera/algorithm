import java.io.BufferedReader
import java.io.InputStreamReader

private val sb = StringBuilder()
private var n = 0
private var m = 0
private lateinit var nums: List<Int>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (nn, mm) = br.readLine().split(" ").map { it.toInt() }
    n = nn
    m = mm
    nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    bt(0, mutableListOf())

    println(sb)

}

private fun bt(index: Int, list: MutableList<Int>) {
    val used = mutableSetOf<Int>()

    if (list.size == m) {
        sb.append(list.joinToString(" ")).append("\n")
        return
    }

    for (i in index until n) {
        if (nums[i] in used) continue

        used.add(nums[i])
        list.add(nums[i])
        bt(i + 1, list)
        list.removeLast()
    }
}