import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val scoreList = br.readLine().split(" ").map { it.toInt() }.sorted()

    var count = 0L

    for (i in 0 until n - 2) {
        var left = i + 1
        var right = n - 1

        while (left < right) {
            val sum = scoreList[i] + scoreList[left] + scoreList[right]

            when {
                sum == 0 -> {
                    if (scoreList[left] == scoreList[right]) {
                        val cnt = right - left + 1
                        count += cnt.toLong() * (cnt - 1) / 2
                        break
                    }

                    var leftCount = 1
                    var rightCount = 1

                    while (left + 1 < right && scoreList[left] == scoreList[left + 1]) {
                        leftCount++
                        left++
                    }

                    while (right - 1 > left && scoreList[right] == scoreList[right - 1]) {
                        rightCount++
                        right--
                    }

                    count += leftCount.toLong() * rightCount
                    left++
                    right--
                }

                sum < 0 -> left++
                else -> right--
            }
        }
    }

    println(count)
}
