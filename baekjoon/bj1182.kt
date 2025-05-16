import java.io.BufferedReader
import java.io.InputStreamReader

private var s = 0
private var n = 0
private lateinit var numbers: IntArray
private var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (count, target) = br.readLine().split(" ").map { it.toInt() }
    s = target
    n = count

    numbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    bt(0,0)
    if(s==0) result-=1
    println(result)

}

private fun bt(depth: Int, now: Int) {
    if (depth == n) {
        if(now==s)
            result+=1
        return
    }

    bt(depth+1, now+numbers[depth])
    bt(depth+1, now)

}