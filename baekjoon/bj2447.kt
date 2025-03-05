import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = Array(n) { CharArray(n) { ' ' } }

    drawStar(map, n, 0, 0)


    for (line in map) {
        println(line)
    }
}

// 별을 채우는 재귀 함수
fun drawStar(arr: Array<CharArray>, size: Int, x: Int, y: Int) {
    if (size == 1) {
        arr[x][y] = '*'
        return
    }

    val nextSize = size / 3

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == 1 && j == 1) continue
            drawStar(arr, nextSize, x + i * nextSize, y + j * nextSize)
        }
    }
}
