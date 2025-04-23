import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (row, col) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(row) { IntArray(col) }
    val dp = Array(row) { Array(col) { IntArray(3) { Int.MAX_VALUE } } }

    repeat(row) { i ->
        map[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (j in 0 until col) {
        for (dir in 0..2) {
            dp[0][j][dir] = map[0][j]
        }
    }

    for (i in 1 until row) {
        for (j in 0 until col) {
            for (dir in 0..2) {
                val preJ = when (dir) {
                    0 -> j - 1
                    1 -> j
                    2 -> j + 1
                    else -> j
                }

                if (preJ < 0 || preJ >= col)
                    continue

                for (preDir in 0..2) {
                    if (preDir == dir || dp[i - 1][preJ][preDir] == Int.MAX_VALUE)
                        continue
                    dp[i][j][dir] = minOf(
                        dp[i][j][dir],
                        dp[i - 1][preJ][preDir] + map[i][j]
                    )
                }

            }
        }
    }
    var result = Int.MAX_VALUE
    dp[row - 1].forEach { arr ->
        arr.forEach {
            result = minOf(result, it)
        }
    }

    println(result)

}