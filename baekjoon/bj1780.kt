import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var n: Int = 0
private lateinit var paper: Array<IntArray>
private var minus = 0
private var zero = 0
private var one = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    paper = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until n) {
            paper[i][j] = st.nextToken().toInt()
        }
    }
    partition(0, 0, n)
    println(minus)
    println(zero)
    println(one)

}

private fun partition(row: Int, col: Int, size: Int) {
    if (check(row, col, size)) {
        when (paper[row][col]) {
            -1 -> minus += 1
            0 -> zero += 1
            1 -> one += 1
        }
        return
    }

    val partSize = size / 3
    for (i: Int in row until row + size step partSize) {
        for (j: Int in col until col + size step partSize) {
            partition(i, j, partSize)
        }
    }
}

private fun check(row: Int, col: Int, size: Int): Boolean {
    for (i: Int in row until row + size) {
        for (j: Int in col until col + size) {
            if (paper[i][j] != paper[row][col])
                return false
        }
    }
    return true
}