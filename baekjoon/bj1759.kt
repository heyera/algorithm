import java.io.BufferedReader
import java.io.InputStreamReader

private var l = 0
private var c = 0
private lateinit var chars: List<String>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ll, cc) = br.readLine().split(" ").map { it.toInt() }
    l = ll
    c = cc
    chars = br.readLine().split(" ").sorted()

    bt(0, 0, 0, mutableListOf())

}

private val gathers = listOf("a", "e", "i", "o", "u")

private fun bt(index: Int, gather: Int, other: Int, strList: MutableList<String>) {
    if (strList.size == l) {
        if (gather >= 1 && other >= 2)
            println(strList.joinToString(""))
        return
    }

    for (i in index until c) {
        strList.add(chars[i])

        if (gathers.contains(chars[i])) {
            bt(i + 1, gather + 1, other, strList)
        } else {
            bt(i + 1, gather, other + 1, strList)
        }

        strList.removeLast()
    }


}