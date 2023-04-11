import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var n: Int = 0
private var blue: Int = 0
private var white: Int = 0
private lateinit var paper: Array<IntArray>

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

    partition(0,0,n)
    println(white)
    println(blue)


}

private fun partition(row: Int, col: Int, size: Int) {
    if (check(row, col, size)) {
        when (paper[row][col]) {
            0 -> white += 1
            1 -> blue += 1
        }
        return
    }
    val halfsize= size/2
    for (i:Int in row until row+size step halfsize){
        for (j:Int in col until col+size step halfsize){
            partition(i,j,halfsize)
        }
    }

}

private fun check(row: Int, col: Int, size: Int): Boolean {
    for (i: Int in row until row + size) {
        for (j: Int in col until col + size) {
            if (paper[row][col] != paper[i][j])
                return false
        }
    }
    return true
}