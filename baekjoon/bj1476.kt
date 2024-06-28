import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (e, s, m) = br.readLine().split(" ").map { it.toInt() }

    var realE = 1
    var realS = 1
    var realM = 1
    var year = 1

    while (realE != e || realS != s || realM != m) {
        realE += 1
        if (realE > 15) realE = 1
        realS += 1
        if (realS > 28) realS = 1
        realM += 1
        if (realM > 19) realM = 1
        year += 1

    }
    println("$year")

}