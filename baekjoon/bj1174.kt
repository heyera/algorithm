import java.io.BufferedReader
import java.io.InputStreamReader

private val result = mutableListOf<Long>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    for (i in 0..9) {
        dfs(i.toLong(), i)
    }
    result.add(0)
    result.sort()

    if (n >= result.size) {
        println(-1)
    } else {
        println(result[n])
    }
}

private fun dfs(num: Long, last: Int) {
    result.add(num)

    for (i in 0 until last) {
        dfs(num * 10 + i, i)
    }
}