import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, length, weight) = br.readLine().split(" ").map { it.toInt() }
    val truckList = br.readLine().split(" ").map { it.toInt() }

    var time = 0
    var index = 0
    var now = 0

    val que = LinkedList<Int>()
    repeat(length) {
        que.add(0)
    }
    while (index < n) {
        time += 1

        now -= que.poll()

        if (now + truckList[index] <= weight) {
            que.add(truckList[index])
            now += truckList[index]
            index += 1
        } else {
            que.add(0)
        }
    }
    time+=length

    println(time)

}