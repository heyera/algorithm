import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private lateinit var energys: IntArray
private var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    energys = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    bt(energys.toMutableList(), 0)

    println(result)
}

private fun bt(energyList: MutableList<Int>, sum: Int) {
    if (energyList.size == 2) {
        result = maxOf(result, sum)
        return
    }

    for (i in 1 until energyList.size - 1) {
        val energy = energyList[i - 1] * energyList[i + 1]
        val temp = energyList.removeAt(i)

        bt(energyList, sum + energy)
        energyList.add(i, temp)
    }
}