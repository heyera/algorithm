import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val S = br.readLine()
    var T = br.readLine()

    while (T.length > S.length) {
        when (T.last()) {
            'A' -> T = T.dropLast(1)
            'B' -> T = T.dropLast(1).reversed()
        }
    }

    println(if (S == T) 1 else 0)
}