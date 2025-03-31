import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var visited: BooleanArray
private lateinit var inputString: CharArray
private var result = 0
private var length = 0


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    inputString = br.readLine().toCharArray()
    inputString.sort()
    visited = BooleanArray(inputString.size) { false }
    length = inputString.size

    luckString("", ' ')
    println(result)
}

private fun luckString(current: String, prev: Char) {
    if (current.length == length) {
        result += 1
        return
    }

    for (i in inputString.indices) {
        if (visited[i]) continue

        if (i > 0 && inputString[i] == inputString[i - 1] && !visited[i - 1]) continue

        if (inputString[i] == prev) continue

        visited[i] = true
        luckString(current + inputString[i], inputString[i])
        visited[i] = false
    }
}