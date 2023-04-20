//Recursion_Kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val map = Array(size) { IntArray(size) }
    for (i in 0 until size) {
        var num = br.readLine()
        for (a in 0 until size) {
            map[i][a] = num.substring(a, a + 1).toInt()
        }
    }
    quad(0, 0, size, map)
}

private fun quad(row: Int, col: Int, size: Int, map: Array<IntArray>) {
    if (size == 1) {
        print(map[row][col])
        return
    }
    if (allSame(row, col, size, map)) {
        print(map[row][col])
        return
    }
    print("(")
    quad(row, col, size / 2, map)
    quad(row, col + size / 2, size / 2, map)
    quad(row + size / 2, col, size / 2, map)
    quad(row + size / 2, col + size / 2, size / 2, map)
    print(")")
}

private fun allSame(row: Int, col: Int, size: Int, map: Array<IntArray>): Boolean {
    val temp = map[row][col]
    for (i in row until row + size) {
        for (j in col until col + size)
            if (map[i][j] != temp) return false
    }
    return true
}
