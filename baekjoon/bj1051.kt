import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (col, row) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(col) { Array(row) { 0 } }

    repeat(col) { i ->
        val str = br.readLine().toCharArray()
        repeat(row) { j ->
            arr[i][j] = str[j].toString().toInt()
        }
    }

    var len = if (col > row) row else col
    while(len>1){
        for (i in 0..col - len) {
            for (j in 0..row - len) {
                val num: Int = arr[i][j]
                if (num == arr[i][j + len - 1] && num == arr[i + len - 1][j] && num == arr[i + len - 1][j + len - 1]
                ) {
                    println(len * len)
                    return
                }
            }
        }
        len--
    }
    println(len*len);
}
