import java.io.BufferedReader
import java.io.InputStreamReader

private data class Egg(var durability: Int, val weight: Int)

private var n = 0
private lateinit var eggs: MutableList<Egg>

private var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    eggs = MutableList(n) {
        val (d, w) = br.readLine().split(" ").map { it.toInt() }
        Egg(d, w)
    }

    bt(0)

    println(count)

}

private fun bt(cur: Int) {
    if (cur == n) {
        val brokenEgg = eggs.count { it.durability <= 0 }
        count = maxOf(count, brokenEgg)
        return
    }

    if (eggs[cur].durability <= 0) {
        bt(cur + 1)
        return
    }

    var hitFlag = false

    for (i in 0 until n) {
        if (i == cur || eggs[i].durability <= 0) continue

        eggs[cur].durability -= eggs[i].weight
        eggs[i].durability -= eggs[cur].weight
        hitFlag = true

        bt(cur + 1)
        eggs[cur].durability += eggs[i].weight
        eggs[i].durability += eggs[cur].weight

    }

    if (!hitFlag) bt(cur + 1)
}