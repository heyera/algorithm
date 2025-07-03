import java.io.BufferedReader
import java.io.InputStreamReader


private var maxNumber = -1
private var b = 0

private lateinit var aNum: List<Int>
private lateinit var used: Array<Boolean>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, bb) = br.readLine().split(" ").map { it.toInt() }

    b = bb
    aNum = a.toString().map { it.toString().toInt() }.sorted()
    used = Array(aNum.size) { false }


    bt(0, mutableListOf())

    println(maxNumber)

}

fun bt(depth: Int, path: MutableList<Int>) {
    if (depth == aNum.size) {
        if (path[0] == 0) return
        val num = path.joinToString("").toInt()
        if (num < b) {
            maxNumber = maxOf(maxNumber, num)
        }
        return
    }

    for (i in aNum.indices) {
        if (used[i]) continue
        if (i > 0 && aNum[i] == aNum[i - 1] && !used[i - 1]) continue

        used[i] = true
        path.add(aNum[i])
        backtrack(depth + 1, path)
        path.removeLast()
        used[i] = false
    }
}
