import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val scoreList = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    var count = 0
    scoreList.sort()

    for (i in 0 until n) {
        var left = i + 1
        var right = n - 1

        while (left < right) {
            val sum = scoreList[i] + scoreList[left] + scoreList[right]

            if (sum == 0) {
                count += 1
                left += 1
            } else if (sum < 0)
                left += 1
            else
                right -= 1
        }
    }


    println(count)
}