import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numList = mutableListOf<Int>()
    val twoSumPlace = mutableSetOf<Int>()

    repeat(n) {
        numList.add(br.readLine().toInt())
    }
    numList.sort()

    for (i in numList) {
        for (j in numList) {
            twoSumPlace.add(i + j)
        }
    }

    for (i in numList.size - 1 downTo 0) {
        for (j in numList.indices) {
            if (numList[i] - numList[j] in twoSumPlace) {
                println(numList[i])
                return
            }
        }
    }


}