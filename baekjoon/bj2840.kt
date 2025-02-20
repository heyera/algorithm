import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val lucky = List(n) { "?" }.toMutableList()

    var count = 0

    repeat(k) {
        val (num, alpha) = br.readLine().split(" ").let { it[0].toInt() to it[1] }

        count = ((count - num) % n + n) % n  // 한번에 여러바퀴 방지

        if (lucky[count] == alpha || lucky[count] == "?") {
            // 중복된 알파벳이 있는지 검사
            if (alpha in lucky && lucky[count] != alpha) {
                println("!")
                return
            }
            lucky[count] = alpha
        } else {
            println("!")
            return
        }
    }

    val result = lucky.drop(count) + lucky.take(count)
    result.forEach{
        print(it)
    }
}