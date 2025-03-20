import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var houses: MutableList<Pair<Int, Int>>
lateinit var chickens: MutableList<Pair<Int, Int>>
var minDistance = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    houses = mutableListOf()
    chickens = mutableListOf()

    for (col in 0 until n) {

        val inRow = br.readLine().split(" ").map { it.toInt() }
        for (row in inRow.indices) {
            when (inRow[row]) {
                1 -> houses.add(Pair(col, row))
                2 -> chickens.add(Pair(col, row))
            }
        }
    }
    selectChicken(0, mutableListOf(), m)
    println(minDistance)

}

fun selectChicken(start: Int, selected: MutableList<Pair<Int, Int>>, size: Int) {
    if (selected.size == size) {
        minDistance = minOf(minDistance, chickenDistance(selected))
        return
    }
    for (i in start until chickens.size) {
        selected.add(chickens[i])
        selectChicken(i + 1, selected, size)
        selected.removeLast()
    }

}

fun chickenDistance(selectedChicken: List<Pair<Int, Int>>): Int {
    var totalDistance = 0

    for (house in houses) {

        var chickenDistance = Int.MAX_VALUE

        for (chicken in selectedChicken) {
            chickenDistance = minOf(
                chickenDistance,
                kotlin.math.abs(house.first - chicken.first) + kotlin.math.abs(house.second - chicken.second)
            )
        }
        totalDistance += chickenDistance
    }


    return totalDistance
}